/**
 * CLASS: Queue (Queue.java)
 * 
 * DESCRIPTION
 * Implements a generic queue data structure using a DList to store the elements.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class Queue<E> {
	
	private DList<E> mList;
	
	public Queue() {
		/**
		 * Constructor for Queue.
		 */
		
		setList(new DList<>());
	}
	
	public void clear() {
		/**
		 * Clears queue of entries.
		 */
		
		getList().clear();
	}
	
	public E dequeue() {
		/**
		 * Returns and removes the first element in the queue.
		 */
		
		E front = getList().remove(0);
		return front;
	}
	
	public void enqueue(E pData) {
		/**
		 * Adds pData to the end of the queue.
		 */
		
		getList().append(pData);
	}
	
	protected DList<E> getList() {
		/**
		 * Accessor for mList.
		 */
		
		return mList;
	}
	
	public boolean isEmpty() {
		/**
		 * Returns if the queue is empty.
		 */
		
		return getList().isEmpty();
	}
	
	public E peek() {
		/**
		 * Returns the first element in the queue without removing it.
		 */
		
		return getList().get(0);
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
		 * Returns a string representation of the queue.
		 */
		
		return getList().toString();
	}
}
