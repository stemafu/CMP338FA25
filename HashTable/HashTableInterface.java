/**
 * 
 * This is the interface for creating a <b>hash table</b>.
 * 
 * @author Sameh Fakhouri
 *
 * @param <E>	This parameter is a generic for the type of <b>elements</b> that will be stored in the hash table.
 * 				Please note that all <b>elements</b> must implement the <b>KeyedElement</b> interface.
 * 				If the <b>elements</b>, themselves, do not implement the <b>KeyedElement</b> interface,
 * 				a super-class of <b>element</b> must implement the <b>KeyedElement</b> interface.
 * @param <K>	This parameter is a generic for the type of <b>key</b> each element must have. 
 * 				
 */
public interface HashTableInterface<E extends KeyedElementInterface<K>, K> extends Iterable<E> {
	
	/**
	 * 
	 * This method will return the size of the hash table. The size of the hash table
	 * is the number of elements that have been added to the hash table.
	 * 
	 * @return	The size of the hash table.
	 */
	public int size();
	
	/**
	 * 
	 * This method is used to determine if the hash table is empty.
	 * 
	 * @return	Return <b>true</b> if the hash table is empty, <b>false</b> otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * This method will return a deep copy of the current instance of the HashTable. Deep copy
	 * involves creating a duplicate of the <b>buckets</b> and their contents. Every bucket contains
	 * a <b>LinkedList</b> which must also be duplicated. Please see the ListInterface.copy() method.
	 * 
	 * @return A copy of the current instance of the HashTable.
	 * 
	 * @throws InstantiationException This exception may be thrown by the HashTable constructor. If that
	 * happens, then this method will throw that exception.
	 * 
	 */
	public HashTableInterface<E, K> copy() throws InstantiationException;
	
	/**
	 * 
	 * This method adds the specified <b>element</b> to the hash table. If another
	 * <b>element</b> with the same <b>key</b> exists in the hash table, that <b>element</b>
	 * will be removed before the new <b>element</b> is inserted. 
	 * 
	 * @param element	The <b>element</b> to be inserted into the hash table
	 * 
	 * @return	If this insertion replaced an existing <b>element</b>, this method will
	 * 			return the replaced <b>element</b>. Otherwise, the method will return <b>null</b>. 
	 */
	public E insert(E element);
	
	/**
	 * 
	 * This method is used to retrieve an <b>element</b> with the specified <b>key</b> from the
	 * hash table.
	 * 
	 * @param key	The <b>key</b> of the element being searched for in the hash table
	 * 
	 * @return	This method will return the <b>element</b> found in the hash table. If the <b>element</b>
	 * 			is not found, this method will return <b>null</b>.
	 */
	public E get(K key);
	
	/**
	 * 
	 * This method will remove the <b>element</b> with the specified <b>key</b> from the hash table. 
	 * 
	 * @param key	The <b>key</b> of the <b>element</b> to be removed from the hash table.
	 * 
	 * @return	This method will return the <b>element</b> that is being removed from the hash table.
	 * 			If the <b>element</b> is not found for removal, this method will return <b>null</b>.
	 */
	public E remove(K key);

	/**
	 * 
	 * This method will remove all elements from the hash table, leaving an empty hash table.
	 * 
	 */
	public void removeAll();

	/**
	 * 
	 * This method will look at all the buckets in the HashTable and return the size
	 * of the largest bucket.
	 * 
	 * @return	The size of the largest bucket in the HashTable.
	 */
	public int getSizeOfLargestBucket();

	/**
	 * 
	 * This method will look at all the buckets in the HashTable and return the average
	 * size of all the buckets.
	 * 
	 * @return	The average size of the buckets in the HashTable.
	 */
	public double getAverageBucketSize();
	
	
	/**
	 * 
	 * This method will be used for testing purposes.
	 * The method will return a reference to the <code>buckets</code> array.
	 * 
	 * @return	A reference to the <code>buckets</code> array.
	 */
	public Object[] getBuckets();
}
