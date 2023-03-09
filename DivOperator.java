/**
 * CLASS: DivOperator (DivOperator.java)
 * 
 * DESCRIPTION
 * MultOperator represents the division operator (/). A subclass of BinaryOperator.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class DivOperator extends BinaryOperator {

	public DivOperator() { }

	@Override
	public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
		/**
		 * Returns the quotient of the pLhsOperand and pRhsOperand.
		 */
		
		return new Operand(pLhsOperand.getValue() / pRhsOperand.getValue());
	}

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of DivOperator.
		 */
		
		return 3;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of DivOperator.
		 */
		
		return 3;
	}

}
