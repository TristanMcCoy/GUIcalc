/**
 * CLASS: MultOperator (MultOperator.java)
 * 
 * DESCRIPTION
 * MultOperator represents the multiplication operator (*). A subclass of BinaryOperator.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class MultOperator extends BinaryOperator {

	public MultOperator() { }

	@Override
	public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
		/**
		 * Returns the product of pLhsOperand and pRhsOperand.
		 */
		
		return new Operand(pLhsOperand.getValue() * pRhsOperand.getValue());
	}

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of MultOperator.
		 */
		
		return 3;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of MultOperator.
		 */
		
		return 3;
	}

}
