/**
 * CLASS: BinaryOperator (BinaryOperator.java)
 * 
 * DESCRIPTION
 * BinaryOperator is the superclass of all binary operators.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public abstract class BinaryOperator extends Operator {
	
	public BinaryOperator() { }
	
	//Evaluates the operator.
	public abstract Operand evaluate(Operand pLhsOperand, Operand pRhsOperand);
	
	@Override
	public boolean isBinaryOperator() {
		/**
		 * Returns true. All subclasses of BinaryOeprator are binary operators.
		 */
		
		return true;
	}
}
