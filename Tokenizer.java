/**
 * CLASS: Tokenizer (Tokenizer).java
 * 
 * DESCRIPTION
 * Tokenizer scans a string containing an infix expression and breaks it into tokens for further processing.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class Tokenizer {
	
	private static final int 	STATE_DOUBLE = 0;
	private static final int 	STATE_END = 1;
	private static final int 	STATE_START = 2;
	private int 				mIndex;
	private String 				mString;
	
	public Tokenizer(String pString) {
		/**
		 * Constructor for Tokenizer.
		 */
		
		setIndex(-1);
		setString(pString);
	}
	
	protected int getIndex() {
		/**
		 * Accessor for mIndex.
		 */
		
		return mIndex;
	}
	
	protected String getString() {
		/**
		 * Accessor for mString.
		 */
		
		return mString;
	}
	
	public Token nextToken() {
		/**
		 * Returns the next token in the expression.
		 */
		
		boolean scanning = true;
		int state = STATE_START, nextState = STATE_START;
		StringBuffer buffer = new StringBuffer();
		Token token = null;
		
		while (state != STATE_END) {
			Character ch = nextChar();
			switch (state) {
			case STATE_START:
				if (ch == null) {
					token = null;
					nextState = STATE_END;
				} else if (Character.isDigit(ch) || ch == '.') {
					buffer.append(ch);
					nextState = STATE_DOUBLE;
				} else if (ch == '+') {
					token = new AddOperator();
					nextState = STATE_END;
				} else if (ch == '-') {
					token = new SubOperator();
					nextState = STATE_END;
				} else if (ch =='*') {
					token = new MultOperator();
					nextState = STATE_END;
				} else if (ch == '/') {
					token = new DivOperator();
					nextState = STATE_END;
				} else if (ch == '(') {
					token = new LeftParen();
					nextState = STATE_END;
				} else if (ch == ')') {
					token = new RightParen();
					nextState = STATE_END;
				}
				break;
				
			case STATE_DOUBLE:
				if (ch == null) {
					nextState = STATE_END;
				} else if (Character.isDigit(ch) || ch == '.') {
					buffer.append(ch);
					nextState = state;
				} else {
					ungetChar();
					nextState = STATE_END;
				}
				
				if (nextState == STATE_END) token = new Operand(Double.parseDouble(buffer.toString()));
				break;
			}
			state = nextState;
		}
		return token;
	}
	
	private Character nextChar() {
		/**
		 * Returns next Character in mString and updates mIndex.
		 */
		
		Character next = null;
		if (getIndex() < getString().length() - 1) {
			setIndex(getIndex() + 1);
			next = getString().charAt(getIndex());
		}
		return next;
	}
	
	private Character peekNext() {
		/**
		 * Returns next Character in mString without updating mIndex.
		 */
		
		Character next = null;
		if (getIndex() < getString().length()) {
			next = getString().charAt(getIndex() + 1);
		}
		return next;
	}
	
	protected void setIndex(int pIndex) {
		/**
		 * Mutator for mIndex.
		 */
		
		mIndex = pIndex;
	}
	
	protected void setString(String pString) {
		/**
		 * Mutator for mString.
		 */
		
		mString = pString;
	}
	
	private void ungetChar() {
		/**
		 * Sets mIndex to the previous character in mString.
		 */
		
		setIndex(getIndex() - 1);
	}
}
