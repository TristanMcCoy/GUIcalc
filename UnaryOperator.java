/**
 * CLASS: UnaryOperator (UnaryOperator.java)
 * 
 * DESCRIPTION
 * UnaryOperator is the superclass of all unary operators.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public abstract class UnaryOperator extends Operator {
	
	public UnaryOperator() { }
	
	//Evaluates the operator.
	public abstract Operand evaluate(Operand pOperand);
	
	@Override
	public boolean isBinaryOperator() {
		/**
		 * Returns false. All subclasses of UnaryOperator are unary operators.
		 */
		
		return false;
	}
}
