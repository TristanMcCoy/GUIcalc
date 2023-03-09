/**
 * CLASS: LeftParen (LeftParen.java)
 * 
 * DESCRIPTION
 * LeftParen represents a left parenthesis in an expression.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class LeftParen extends Parenthesis {

	public LeftParen() { }

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence for LeftParen.
		 */
		
		return 5;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence for a LeftParen.
		 */
		
		return 0;
	}

}
