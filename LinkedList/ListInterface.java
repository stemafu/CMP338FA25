
/**
 * <p>
 * This is the interface for the List Abstract Data Type (ADT). 
 * </p>
 * 
 * <p>
 * Please note that this
 * interface uses the generic type <code>I</code> which either implements the
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">
 * <code>Comparable</code> interface
 * </a>
 * , or some <code>super</code> class of <code>I</code>
 * implements the 
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">
 * <code>Comparable</code> interface
 * </a>
 * </p>
 * 
 * @author Sameh Fakhouri
 *
 */

public interface ListInterface<I extends Comparable<? super I>> {
	

	/**
	 * 
	 * This method will make a copy of the list and return it.
	 * 
	 * @return a copy of the list.
	 */
	public ListInterface<I> copy();

	
	
	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of <b>Element</b>s that are currently in the list.
	 */
	
	public int size();

	
	
	/**
	 * This method is called to determine if the list is empty.
	 * 
	 * @return 	Returns <b>true</b> if the list is empty, otherwise it returns <b>false</b>. 
	 */
	
	public boolean isEmpty();

	
	
	/**
	 * This method is called to add the specified Element to the end of the list.
	 * 
	 * @param 	element	A reference to the element to be added to the end of the list.
	 * 					All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void add(I element);
	
	
	
	/**
	 * This method is called to add the specified Element to the list at the given index.
	 * 
	 * @param 	element	A reference to the element to be added to the list. 
	 * 					All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @param 	index 	Indicates the position at which to add the specified Element.
	 * <br>
	 * <ul>
	 * <li>
	 * Using an <b>index = 0</b> indicates that the element being added should
	 * become the <b>head</b> of the list and the add should succeed even if
	 * the list is currently empty.
	 * </li>
	 * <li>
	 * If the list currently contains <b>n</b> elements, using an index = n
	 * indicates that the element being added should become the <b>tail</b>
	 * of the list and the add should succeed.
	 * </li>
	 * <li>
	 * If the list currently contains <b>n</b> elements, using an index = i,
	 * where 0 &le; i &le; n, the add should succeed, since the index is valid. 
	 * </li>
	 * <li>
	 * If the list currently contains <b>n</b> elements, using an index = i,
	 * where i &gt; n, the add should fail and cause the method to <b>throw</b> an
	 * <b>IndexOutOfBoundsException</b>.
	 * </li>
	 * </ul>
	 * 
	 * @throws IndexOutOfBoundsException This exception is thrown if the specified
	 * index is invalid.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void add(I element, int index) throws IndexOutOfBoundsException; 
	
	

	/**
	 * This method is called to add the specified Element to the list in sorted order. More
	 * specifically, the Elements preceding the specified Element must be "less than" the
	 * specified Element, and the Elements following the specified Element must be "greater
	 * than or equal to" the specified Element.
	 * 
	 * @param 	element 	A reference to the <b>element</b> being added, in sorted order, 
	 * 					to the list. All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void addSorted(I element);
	
	
	
	/**
	 * This method is called to retrieve the Element at the specified index.
	 * 
	 * @param 	index	Indicates the position from which to retrieve the Element.
	 * 					If the list currently contains <b>n</b> elements, using an index = i,
	 * 					where 0 &le; i &lt; n, the get should succeed, since the index is valid. 
	 * 
	 * @throws 	IndexOutOfBoundsException 	This exception is thrown if the specified
	 * 		   								index is invalid.
	 * 
	 * @return	Returns a reference to the <b>Element</b> at the given index.
	 * 
	 */
	public I get(int index) throws IndexOutOfBoundsException;
		
	
	
	/**
	 * 
	 * This method is called to replace the element at the specified <b>index</b> with the specified
	 * <b>element</b>. The method then returns the replaced element or <b>null</b> if no element exists
	 * at the specified <b>index</b>.
	 * 
	 * @param element	A reference to the <b>element</b> that will replace the current element in the list.
	 * 
	 * @param 	index 	Indicates the position in the list where the replacement should be made.
	 * 					If the list currently contains <b>n</b> elements, using an index = i,
	 * 					where 0 &le; i &lt; n, the get should succeed, since the index is valid. 
	 * 
	 * @throws 	IndexOutOfBoundsException 	This exception is thrown if the specified
	 * 		   								index is invalid.
	 * 
	 * @return			If the replacement is successful, the method will return a reference to the replaced
	 * 					element at the specified index.
	 */
	public I replace(I element, int index) throws IndexOutOfBoundsException;

	
	
	/**
	 * This method is called to remove the Element at the specified index
	 * 
	 * @param 	index	Indicates the position from which to remove the Element.
	 * 					If the list currently contains <b>n</b> elements, using an index = i,
	 * 					where 0 &le; i &lt; n, the get should succeed, since the index is valid. 
	 * 
	 * @throws 	IndexOutOfBoundsException 	This exception is thrown if the specified
	 * 		   								index is invalid.
	 * 
	 * @return			If the remove is successful, the method will return a reference to the removed
	 * 					element at the specified index.
	 */
	public I remove(int index) throws IndexOutOfBoundsException;

	
	
	/**
	 * This method removes all Elements from the list, making the list empty.
	 */
	public void removeAll();
	
}
