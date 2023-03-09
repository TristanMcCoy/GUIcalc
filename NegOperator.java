/**
 * CLASS: NegOperator (NegOperator.java)
 * 
 * DESCRIPTION
 * NegOperator represents the negation operator (-). 
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class NegOperator extends UnaryOperator {

	public NegOperator() { }

	@Override
	public Operand evaluate(Operand pOperand) {
		/**
		 * Returns the new NegOperator.
		 */
		
		return new Operand(-pOperand.getValue());
	}

	@Override
	public int precedence() {
		/**
		 * Returns the normal precedence of NegOperator.
		 */
		
		return 4;
	}

	@Override
	public int stackPrecedence() {
		/**
		 * Returns the stack precedence of NegOperator.
		 */
		
		return 4;
	}

}
