/**
 * CLASS: AddOperator (AddOperator.java)
 * 
 * DESCRIPTION
 * AddOperator represents the addition operator (+). A subclass of BinaryOperator.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class AddOperator extends BinaryOperator {

	public AddOperator() { }

	@Override
	public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
		/**
		 * Returns the sum of pLhsOperand and pRhsOperand.
		 */
		
		return new Operand(pLhsOperand.getValue() + pRhsOperand.getValue());
	}
	
	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of AddOperator.
		 */
		
		return 2;
	}
	
	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of AddOperator.
		 */
		
		return 2;
	}
}
