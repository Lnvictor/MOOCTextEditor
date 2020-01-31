package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 * @author Victor 
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		
		if(this.size <= 1) {
			if(this.head.data == null) {
				this.head.data = element;
			}
			else {
				this.tail.data = element;
			}
		}
		else {
			this.tail.next = new LLNode<E>(element);
			this.tail.next.prev = this.tail;
			this.tail = this.tail.next;
		}
		
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {
		// TODO: Implement this method.
		
		return findNode(index).data;
	}
	
	private LLNode<E> findNode(int index){
		if(this.size < 1 || index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> temp = this.head;
		
		for(int k = 1; k <= index; k++) {
			if (temp.next != null)
				temp = temp.next;
		}
		
		return temp;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(element == null) {
			throw new NullPointerException();
		}
		
		if (index == 0) {			
			if(this.size > 1) {
				LLNode<E> temp = new LLNode<E>(this.head.data);
				temp.next = this.head.next;
				temp.prev = this.head;
				this.head.next = temp;
			}
			this.head.data = element;
		}
		else {
			LLNode<E> temp = findNode(index - 1);
			LLNode<E> next = findNode(index);
		
			temp.next = new LLNode<E>(element);
			temp.next.prev = temp;
			temp.next.next = next;
			next.prev = temp.next;
		}
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		int count = 1;
		E datax;
		LLNode<E> helper = this.head;
		
		if(index == 0) {
			datax = this.head.data;
			this.head = this.head.next;
			this.head.prev = null;
		}
		else {
			while(count < index) {
				helper = helper.next;
				count++;
			}
			
			datax = helper.next.data;
			
			helper.next = helper.next.next;
			helper.next.prev  = helper;
			
		}
		this.size--;
		return datax;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> helper = findNode(index);
		E temp = helper.data;
		
		helper.data = element;
		return temp;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

}
