/**
 * CLASS: SubOperator (SubOperator.java)
 * 
 * DESCRIPTION
 * SubOperator represents the subtraction operator (-). A subclass of BinaryOperator.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class SubOperator extends BinaryOperator {

	public SubOperator() { }

	@Override
	public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
		/**
		 * Returns the difference of pLhsOperand and pRhsOperand.
		 */
		
		return new Operand(pLhsOperand.getValue() - pRhsOperand.getValue());
	}

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of SubOperator.
		 */
		
		return 2;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of SubOperator.
		 */
		
		return 2;
	}

}
