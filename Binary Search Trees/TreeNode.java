
public class TreeNode <E extends KeyedElementInterface<K>, K extends Comparable<? super K>> {

	/* We know that each treenode will be used in some BST.
	 * Each node in a binary search tree stores 
	 * 1. data
	 * 2. an address to the left child (left node)
	 * 3. an address to the right child (right node)
	 */
	
	/* since data has E as its data type, we expect data to have a key.
	 * Please notice that E extends KeyelementInterface.
	 * We will use this key for arranging the values in  the node
	 *  
	 */
	private TreeNode<E, K> parent;
	private E data; 
	
	private TreeNode<E, K> leftChild;
	
	private TreeNode<E, K> rightChild;
	
	public TreeNode(E data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
	public void setData(E data) {
		this.data = data;
	}
	
	public E getData() {
		return this.data;
	}
	
	public void setLeftChild(TreeNode<E, K> leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode<E, K> getLeftChild(){
		return leftChild;
	}
	
	public void setRightChild(TreeNode<E, K> rightChild) {
		this.rightChild = rightChild;
	}
	
	public TreeNode<E, K> getRightChild(){
		return this.rightChild;
	}
	
	public void setParent(TreeNode<E, K> parent) {
		this.parent = parent;
	}
	
	public TreeNode<E, K> getParent(){
		return parent;
	}
	
}
