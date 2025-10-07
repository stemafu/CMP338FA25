

/**
 * 
 * Generic interface for a LIFO stack. 
 * 
 * @author Sameh Fakhouri
 *
 * @param	<E>		The type of Object that the stack will accept.
 * 
 */

public interface StackInterface<E> extends Iterable<E> {

	/**
	 * This method is called to determine if the stack is empty.
	 * 
	 * @return 	Returns <b>true</b> if the stack is empty, otherwise it returns <b>false</b>. 
	 */
	public boolean isEmpty();
	
	/**
	 * This method is called to obtain the count of elements in the stack.
	 * 
	 * @return 	Returns the numbers of elements that are currently in the stack.
	 */
	public int size();
	
	/**
	 * This method creates a copy of the current stack and returns the copy to the caller.
	 * 
	 * @return A complete copy of the current stack. Please note that an <b>ArrayBasedStack</b>
	 * instance, will return an <b>ArrayBasedStack</b> copy of itself. Similarly, a 
	 * <b>LinkedStack</b> instance will return a <b>LinkedStack</b> copy of itself.
	 */
	public StackInterface<E> copy();

	/**
	 * 
	 * Pushed the specified element into this queue if it is possible to do so immediately without 
	 * violating capacity restrictions, otherwise, throwing an IllegalStateException 
	 * if no space is currently available or NullPointerException if the specified element is null.
	 * 
	 * @param 	e	The element to add.
	 * 
	 * @throws 	IllegalStateException	If the element cannot be added at this time due to capacity restrictions.
	 * @throws 	NullPointerException	If the specified element being added is null. 
	 * 
	 */
	public void push(E e) throws IllegalStateException, NullPointerException;
	
	/**
	 * 
	 * Retrieves, but does not remove, the top of the stack.
	 * 
	 * @return	The element at the top of the stack or null if the stack is empty.
	 * 
	 */
	public E peek();	
	
	/**
	 * 
	 * Retrieves and removes the element at the top of the stack.
	 * 
	 * @return	The element at the top of the stack or null if the stack is empty.
	 * 
	 */
	public E pop();

	/**
	 * 
	 * Removes all elements from the stack.
	 * 
	 */
	public void clear();
}
