
/**
 * 
 * @author sameh
 *
 * @param <E> The type of <code>element</code> that the <code>BinarySearchTree</code> will hold. Please note that <code>E</code> must implement the
 * <code>KeyElementInterface</code> or some super class of <code>E</code> must  implement the <code>KeyElementInterface</code>.
 *     
 * @param <K> The type of <code>key</code> that all <code>element</code>s must contain. Please note that <code>K</code> must implement the
 * <code>Comparable</code> interface or some super class of <code>K</code> must  implement the <code>Comparable</code> interface.
 */
public interface BinarySearchTreeInterface<E extends KeyedElementInterface<K>, K extends Comparable<? super K>> {
	
	
	/**
	 * 
	 * Method to get the current root of this BinarySearchTree
	 * 
	 * @return	The root TreeNode for this BinarySearchTree
	 * 
	 */
	public TreeNode<E, K> getRoot();
	
	
	/**
	 * 
	 * Method to set set the root of this BinarySearchTree
	 * 
	 * @param root	The new root of this BinarySearchTree
	 * 
	 */
	public void setRoot(TreeNode<E, K> root);	
	
	
	/**
	 * 
	 * Method to find out if the BinarySearchTree is empty
	 * 
	 * @return	Returns <b>true</b> if the root in <b>null</b>, otherwise, returns <b>false</b>
	 * 
	 */
	public boolean isEmpty();
	
	
	
	/**
	 * 
	 * Method to remove all entries from the BinarySearchTree.
	 * 
	 */
	public void makeEmpty();	
	
	
	
	/**
	 * 
	 * Method to make a deep copy of the BinarySearchTree.
	 * 
	 * @return An identical deep copy of the existing BinarySearchTree.
	 * 
	 */
	public BinarySearchTreeInterface<E, K> copy();	
	
	
	/**
	 * 
	 * Method to find and retrieve the <b>TreeItem</b>
	 * with the given <b>key</b> if it is in the BinarySearchTree.
	 * 
	 * @param key	The <b>key</b> that the user wishes to search for
	 * 
	 * @return		The <b>element</b> with the given <b>key</b> if found. Otherwise, returns
	 * 				<b>null</b>
	 * 
	 */
	public E find(K key);	
	
	
	/**
	 * 
	 * Method to insert the given <b>TreeItem</b> into the BinarySearchTree
	 * 
	 * @param element	The <b>element</b> to insert into the BinarySearchTree
	 * 
	 */
	public void insert(E element);	

	
	/**
	 * 
	 * This is the public method used to delete a TreeItem from the <code>BinarySearchTree</code> based
	 * on the specified <b>key</b>.
	 * 
	 * @param key		The <b>key</b> of the TreeItem the user wishes to delete from the <code>BinarySearchTree</code>.
	 * 
	 */
	public void delete(K key) throws TreeException;	


	/**
	 * 
	 * This method is used to obtain the height of the <code>BinarySearchTree</code>.
	 * 
	 * @return	Returns the height of the <code>BinarySearchTree</code>.
	 * 
	 */
	public int height();
	
	
	/**
	 * 
	 * This is the method the user calls to find out if the <code>BinarySearchTree</code> is balanced.
	 * 
	 * @return	Returns <code>true</code> if the <code>BinarySearchTree</code> is balanced, <code>false</code> otherwise.
	 */
	public boolean isBalanced();	
	
	
	/**
	 * 
	 * This method is used to balance the <code>BinarySearchTree</code>. 
	 * 
	 */
	public void balance();
}
