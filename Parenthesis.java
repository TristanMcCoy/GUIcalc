/**
 * CLASS: Parenthesis (Parenthesis.java)
 * 
 * DESCRIPTION
 * Parenthesis is the superclass of LeftParen and RightParen. Treated as an Operator.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public abstract class Parenthesis extends Operator {

	public Parenthesis() { }

	@Override
	public boolean isBinaryOperator() {
		/**
		 * Returns false. Parentheses are not operators.
		 */
		
		return false;
	}

}
