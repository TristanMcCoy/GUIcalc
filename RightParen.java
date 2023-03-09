/**
 * CLASS: RightParen (RightParen.java)
 * 
 * DESCRIPTION
 * RightParen represents a right parenthesis in the expression.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class RightParen extends Parenthesis {

	public RightParen() { }

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of RightParen.
		 */
		
		return 1;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of RightParen.
		 */
		
		return 1;
	}

}
