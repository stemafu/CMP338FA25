/**
 * This list interface is a list ADT 
 */
public interface ListInterface {
	
	/**
	 * The method will return true if the list is empty.
	 * Otherwise it will return false.
	 * 
	 * Calling this method will determine whether the list is empty or not
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * This will the amount of the elements that are currently stored in the list.
	 * @return the number of elements in the list
	 */
	public int size();
	
	/**
	 * This method is called to add the specified element at the end of list.
	 * @param num this is the number to be added to the list
	 */
	public void add(int num);
	
	
	/**
	 * This method is called to add the specified element at the specified index in the list.
	 * @param num this is the number to be added to the list
	 */
	public void add(int num, int index);
	
	public void addSorted(int num);
	
	/**
	 * This method returns an element at the specified index.
	 * What if the specified index is bad? We answer that part later?
	 * @param index - the index where we want to get the value
	 * @return the element at the index
	 */
	public int get(int index);
	
	/**
	 * The following method is used to remove the element at the specified index.
	 * What if the specified index is bad? We will answer later.
	 * @param index
	 * @return
	 */
	public int remove(int index);
	
	/**
	 * The following method removes everything from the list
	 */
	public void removeAll();
	
	/**
	 * The following method is used to replace a num in the list at the specified index with the
	 * given num
	 * What if the index is bad? We will answer that later.
	 * @param num
	 * @param index
	 * @return
	 */
	public int replace(int num, int index);

}
