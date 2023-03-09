/**
 * CLASS: Operator (Operator.java)
 * 
 * DESCRIPTION
 * Operator is the superclass of all binary and unary operators.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public abstract class Operator extends Token {
	
	public Operator() { }
	
	public abstract boolean isBinaryOperator();
	
	public abstract int precedence();
	
	public abstract int stackPrecedence();
}
