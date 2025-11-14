
public class BinarySearchTree 
<E extends KeyedElementInterface<K>, K extends Comparable<K>> 
implements BinarySearchTreeInterface<E, K>{
	/* Each BST that you will have must have a root node.
	 * This is because most of the operation that we are going 
	 * to perform on a BST will done start from the root.*/

	private TreeNode<E, K> root;
	
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	
	@Override
	public TreeNode<E, K> getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<E, K> root) {
		this.root = root;		
	}

	@Override
	public boolean isEmpty() {
		return (this.root == null);
	}

	@Override
	public void makeEmpty() {
		this.root = null;		
	}

	@Override
	public BinarySearchTreeInterface<E, K> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E find(K key) {
		
		TreeNode<E, K> findNode = findNode(key);
		
		if(findNode != null) {
			return findNode.getData();
		}
		
		return null;
	}

	@Override
	public void insert(E element) {
		TreeNode<E, K> node = new TreeNode<E, K>(element);
		if(this.isEmpty()) {
			//TreeNode<E, K> node = new TreeNode<E, K>(element);
			this.root = node;
		}else {
			
			K key = element.getKey();
			
			/* if the tree is not empty, we need to search
			 * for the correct leaf node where to insert the
			 * new key (data).
			 * 
			 * We start the search from the root node
			 */
			
			TreeNode<E, K> currNode = this.root;
			//TreeNode<E, K> node = new TreeNode<E, K>(element);
			while(currNode != null) {
				
				K currNodeKey = currNode.getData().getKey();
				
				if(key.compareTo(currNodeKey) < 0) {
					// go to the left
					if(currNode.getLeftChild() == null) {
						
						currNode.setLeftChild(node);
						node.setParent(currNode);
					}else {
						currNode = currNode.getLeftChild();
					}
				}else {
					// go to the right
					
					if(currNode.getRightChild() == null) {
						currNode.setRightChild(node);
						node.setParent(currNode);
					}else {
						currNode = currNode.getRightChild();
					}
				}
			}
			
			
		}
		
	}

	@Override
	public void delete(K key) throws TreeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBalanced() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	}
	
	public int compareTo(K key1, K key2) {
		
	/*/	if(key1 == key2) {
			return 0;
		}else if(key1 < key2) {
			return -1;
		}else {
			return 1;
		}*/
		
		return key1.compareTo(key2);
	}
	
	private TreeNode<E, K> findNode(K key){
		
		TreeNode<E, K> currNode = this.root;
		
		
		while(currNode != null) {
			K currNodeKey = currNode.getData().getKey();
			if(key.compareTo(currNodeKey) == 0) {
				return currNode;
				}else if(key.compareTo(currNodeKey) < 0) {
					currNode = currNode.getLeftChild();
				}else {
			        currNode = currNode.getRightChild();
			    }
		}
		return null;
	}

}
