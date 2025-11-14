/**
 * 
 * This is the interface that all <b>elements</b> to be inserted into a <b>hash table</b> or
 * a <b>list</b> must implement.
 * 
 * @author Sameh Fakhouri
 *
 * @param <K>	This parameter is a generic for the type of <b>key</b> each element must have.
 */
public interface KeyedElementInterface<K> {

	/**
	 * 
	 * This method returns the <b>key</b> to be used by <b>elements</b> that will be used by 
	 * classes implementing the <b>ListInterface</b> and the <b>HashTableInterface</b>.
	 * 
	 * @return	This method returns the <b>key</b> of the enclosing object.
	 */
	public K getKey();
	
	/**
	 * This method makes a deep copy of the KeyedElement. This involves making a new instance of
	 * the KeyedElement which contains duplicates of all the instance variables of the KeyedElement.
	 *  
	 * @return A deep copy of the object implementing this interface.
	 * 
	 */
	public KeyedElementInterface<K> copy();
}

