/**
 * CLASS: DList<E> (DList.java)
 * 
 * DESCRIPTION
 * Implements a generic doubly linked list where the type of each element is E.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

public class DList<E> {
	
	private Node<E> mHead;
	private int 	mSize;
	private Node<E> mTail;
	
	public DList() {
		/**
		 * Default constructor for an empty DList.
		 */
		
		setHead(null);
		setTail(null);
		setSize(0);
	}
	
	public DList(E pData) {
		/**
		 * Constructor for DList.
		 */
		
		Node<E> newNode = new Node<E>(pData);
		setHead(newNode);
		setTail(newNode);
		setSize(1);
	}
	
	public void add(int pIndex, E pData) throws IndexOutOfBoundsException {
		/**
		 * Inserts a new Node containing pData into this DList at index pIndex. Amends the size of this DList.
		 */
		
		if (pIndex < 0 || pIndex > getSize()) throw new IndexOutOfBoundsException();
		
		if (pIndex == getSize()) {
			Node<E> newNode = new Node<E>(pData, getTail(), null);
			
			if (isEmpty()) setHead(newNode);
			else getTail().setNext(newNode);
			
			setTail(newNode);
		} else {
			Node<E> node = getNodeAt(pIndex);
			Node<E> newNode = new Node<E>(pData, node.getPrev(), node);
			
			if(pIndex != 0) node.getPrev().setNext(newNode);
			
			node.setPrev(newNode);
			
			if(pIndex == 0) setHead(newNode);
		}
		
		setSize(getSize() + 1);
	}
	
	public void append(E pData) {
		/**
		 * Adds a new Node storing pData at the end of this DList.
		 */
		
		add(getSize(), pData);
	}
	
	public void clear() {
		/**
		 * Empties elements from DList.
		 */
		
		while (!isEmpty()) remove(0);
	}
	
	public DList<E> clone() {
		/**
		 * Duplicates this DList as another DList.
		 */
		
		DList<E> cloneList = new DList<E>();
		Node<E> traverse = getHead();
		while (traverse != null) {
			cloneList.append(traverse.getData());
			traverse = traverse.getNext();
		}
		
		return cloneList;
	}
	
	public E get(int pIndex) throws IndexOutOfBoundsException {
		/**
		 * Returns element at index pIndex.
		 */
		
		return getNodeAt(pIndex).getData();
	}
	
	protected Node<E> getHead() {
		/**
		 * Accessor for mHead.
		 */
		
		return mHead;
	}
	
	protected Node<E> getNodeAt(int pIndex) throws IndexOutOfBoundsException {
		/**
		 * Returns a reference to the Node at index pIndex.
		 */
		
		if (pIndex < 0 || pIndex >= getSize()) throw new IndexOutOfBoundsException();
		
		if (pIndex == 0) return getHead();
		else if (pIndex == getSize() - 1) return getTail();
		
		Node<E> node = getHead().getNext();
		for (int index = 1; index < pIndex; index++) node = node.getNext();
		
		return node;
	}
	
	public int getSize() {
		/**
		 * Accessor for mSize.
		 */
		
		return mSize;
	}
	
	protected Node<E> getTail() {
		/**
		 * Accessor for mTail.
		 */
		
		return mTail;
	}
	
	public boolean isEmpty() {
		/**
		 * Checks if DList is empty.
		 */
		
		return getSize() == 0;
	}
	
	public void prepend(E pData) {
		/**
		 * Adds a new Node storing pData at the beginning of this DList.
		 */
		
		add(0, pData);
	}
	
	public E remove(int pIndex) throws IndexOutOfBoundsException {
		/**
		 * Removes the element at index pIndex from this DList. Amends the size of this DList.
		 */
		
		Node<E> node = getNodeAt(pIndex);
		if (getSize() == 1) {
			setHead(null);
			setTail(null);
		} else if (pIndex == 0) {
			node.getNext().setPrev(null);
			setHead(node.getNext());
		} else if (pIndex == getSize() - 1) {
			node.getPrev().setNext(null);
			setTail(node.getPrev());
		} else {
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
		}
		
		setSize(getSize() - 1);
		
		return node.getData();
	}
	
	public E set(int pIndex, E pData) throws IndexOutOfBoundsException {
		/**
		 * Replaces the element at index pIndex of this DList with pData and returns the element that was previously stored at index pIndex.
		 */
		
		Node<E> node = getNodeAt(pIndex);
		E original = node.getData();
		node.setData(pData);
		
		return original;
	}
	
	public void setHead(Node<E> pHead) {
		/**
		 * Mutator for mHead.
		 */
		
		mHead = pHead;
	}
	
	public void setSize(int pSize) {
		/**
		 * Mutator for mSize.
		 */
		
		mSize = pSize;
	}
	
	protected void setTail(Node<E> pTail) {
		/**
		 * Mutator for mTail.
		 */
		
		mTail = pTail;
	}
	
	@Override
	public String toString() {
		/**
		 * Returns a string representation of this DList.
		 */
		
		String string = "";
		int i;
		for (i = 0; i < getSize() - 1; ++i) {
			string += get(i) + "";
		}
		
		if (!isEmpty()) {
			string += get(i);
		}
		
		return string;
	}
	
	protected static class Node<E> {
		
		E mData;
		Node<E> mNext;
		Node<E> mPrev;
		
		public Node() {
			/**
			 * Default constructor for Node.
			 */
			
			this(null);
		}
		
		public Node(E pData) {
			/**
			 * Constructor for Node of a single-entry list.
			 */
			
			setData(pData);
			setNext(null);
			setPrev(null);
		}
		
		public Node(E pData, Node<E> pPrev, Node<E> pNext) {
			/**
			 * Constructor for Node for a multiple-entry list.
			 */
			
			setData(pData);
			setPrev(pPrev);
			setNext(pNext);
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object pNode) {
			/**
			 * Returns true if this Node and pNode are equal to each other.
			 */
			
			Node<E> node = (Node<E>) pNode;
			
			if (node == null) return false;
			if (this == node) return true;
			if (this.getClass() != node.getClass()) return false;
			if (getData() == node.getData() && getNext() == node.getNext() && getPrev() == node.getPrev()) return true;
			
			return false;
		}
		
		@Override
		public int hashCode() {
			/**
			 * Returns the hash code of the node.
			 */
			
			return System.identityHashCode(this);
		}
		
		public E getData() {
			/**
			 * Accessor for mData.
			 */
			
			return mData;
		}
		
		public Node<E> getNext() {
			/**
			 * Accessor of mNext.
			 */
			
			return mNext;
		}
		
		public Node<E> getPrev() {
			/**
			 * Accessor for mPrev.
			 */
			
			return mPrev;
		}
		
		public void setData(E pData) {
			/**
			 * Mutator for pData.
			 */
			
			mData = pData;
		}
		
		public void setNext(Node<E> pNext) {
			/**
			 * Mutator for mNext.
			 */
			
			mNext = pNext;
		}
		
		public void setPrev(Node<E> pPrev) {
			/**
			 * Mutator for mPrev.
			 */
			
			mPrev = pPrev;
		}
		
		@Override
		public String toString() {
			/**
			 * Returns a string representation of the node.
			 */
			
			return "" + getData();
		}
	}
}
