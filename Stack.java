/**
 * CLASS: Stack (Stack.java)
 * 
 * DESCRIPTION
 * Stack implements a generic stack data structure using a DList to store the elements.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class Stack<E> {
	
	private DList<E> mList;
	
	public Stack() {
		/**
		 * Constructor for Stack.
		 */
		
		setList(new DList<>());
	}
	
	public void clear() {
		/**
		 * Clears stack of entries.
		 */
		
		getList().clear();
	}
	
	protected DList<E> getList() {
		/**
		 * Accessor for mList.
		 */
		
		return mList;
	}
	
	public boolean isEmpty() {
		/**
		 * Returns is stack is empty.
		 */
		
		return getList().isEmpty();
	}
	
	public E peek() {
		/**
		 * Returns the first element in the stack without removing it.
		 */
		
		return getList().get(0);
	}
	
	public E pop() {
		/**
		 * Returns and removes the first element in the stack.
		 */
		
		E top = getList().remove(0);
		return top;
	}
	
	public void push(E pData) {
		/**
		 * Adds pData to the front of the stack.
		 */
		
		getList().prepend(pData);
	}
	
	protected void setList(DList<E> pList) {
		/**
		 * Mutator for mList.
		 */
		
		mList = pList;
	}
	
	@Override
	public String toString() {
		/**
		 * Returns a string representation of the stack.
		 */
		
		return getList().toString();
	}
}
