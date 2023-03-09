/**
 * CLASS: Operand (Operand.java)
 * 
 * DESCRIPTION
 * Operand is a numeric value represented as a Double.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class Operand extends Token {
	
	private Double mValue;
	
	public Operand(Double pValue) {
		/**
		 * Constructor for Operand.
		 */
		
		setValue(pValue);
	}
	
	public Double getValue() {
		/**
		 * Accessor for mValue.
		 */
		
		return mValue;
	}
	
	public void setValue(Double pValue) {
		/**
		 * Mutator for mValue.
		 */
		
		mValue = pValue;
	}
}
