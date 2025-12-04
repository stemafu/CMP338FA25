
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
	
	/*
	 * The following method prints the values(keys) in the BST inorder.
	 * They will appear in ascending order.
	 */
	public void inOrder() {
		inOrder(this.root);
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	public void postOrder(){
		postOrder(this.root);
	}
	
	private void inOrder(TreeNode<E, K> node) {
		
		if(node != null) {
			inOrder(node.getLeftChild());
			System.out.print(node.getData());
			inOrder(node.getRightChild());
			return;
		}
		// traverse to the left first

	}
	
	
	private void preOrder(TreeNode<E, K> node) {
		if (node == null) return;
		
		System.out.print(node.getData());
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}
	
	private void postOrder(TreeNode<E, K> node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		System.out.print(node.getData());
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
				//
				K currNodeKey = currNode.getData().getKey();
				
				if(key.compareTo(currNodeKey) < 0) {
					//System.out.println(key );
					// go to the left
					if(currNode.getLeftChild() == null) {
						
						currNode.setLeftChild(node);
						node.setParent(currNode);
						return;
					}else {
						currNode = currNode.getLeftChild();
					}
				}else {
					// go to the right
					if(currNode.getRightChild() == null) {
						currNode.setRightChild(node);
						node.setParent(currNode);
						return;
					}else {
						currNode = currNode.getRightChild();
					}
				}
			}
			
			
		}
		
	}

	@Override
	public void delete(K key) throws TreeException {
		
		TreeNode <E, K> nodeToDelete = this.findNode(key);
		
		if(nodeToDelete != null) {
			deleteNode(nodeToDelete);
		}
		
		
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
	
	private void deleteNode(TreeNode<E, K> nodeToDelete) {
		
		/*When deleteting in a BST, we have to account for 
		three scenarios
		Case 1: Deleting a leaf node
		Case 2: Deleting a node with one child only
		case 3: Deleting a node with two childten
		*/
		
		TreeNode<E, K> parent = nodeToDelete.getParent();
		// case 1
		if(this.isLeafNode(nodeToDelete)) {
			if(parent == null) {
				this.root = null;
			}else {
				if(this.isNodeToDeleteLeftChildOf(parent, nodeToDelete)) {
					parent.setLeftChild(null);
					nodeToDelete.setParent(null);
				}else {
					parent.setRightChild(null);
					nodeToDelete.setParent(null);
				}
			} // Case 1 ends end
		}else if (this.nodeHasOnlyLeftChild(nodeToDelete)) {
			// Case 2 A
			
			if(parent == null) {
				// the node being deleted is the root
				//
				root = nodeToDelete.getLeftChild();
				root.setParent(null);
			}else {
				
				//nodeToDelete.getParent().setLeftChild(nodeToDelete.getLeftChild());
				parent.setLeftChild(nodeToDelete.getLeftChild());
				nodeToDelete.getLeftChild().setParent(parent);
			}
			
			// replace a node's role with is child in the parent child relationship
		}else if (this.nodeHasOnlyRightChild(nodeToDelete)) {
			// Case 2 B
			
			if(parent == null) {
				root = nodeToDelete.getRightChild();
				root.setParent(null);
			}else {
				parent.setRightChild(nodeToDelete.getRightChild());
				nodeToDelete.getRightChild().setParent(parent);
			}
			
		}else {
			// case 3: node to delete has 2 children
			
			/* If a node has two children, we need to find a replacement node
			 * A node that will take the position of the node to be deleted
			 * We will call this node a successor.
			 * 
			 * We will create a helper method for finding the successor node.
			 * 
			 * Once we find the successor node, we will take the value
			 * at that successor node and place its value at the nodetodelete
			 * the successor node will become the node to delete.
			 * then we will recursively delete the new node to delete
			 */
			
			/* Find the node with the smallest key on the right subtree
			of the node to delete
			*/
			TreeNode<E, K> successor = findSuccessor(nodeToDelete);
			
			/*
			 * replace the element of the nodeToDelete with the element from the
			 * successor
			 */
			nodeToDelete.setData(successor.getData());
			
			deleteNode(successor);
		}
	}
	
	/*
	 * We use this node to find the node with the smalless value of the
	 * right subtree.
	 */
	public TreeNode<E, K> findSuccessor(TreeNode<E, K> node){
		TreeNode<E, K> currentNode = node.getRightChild();
		
		while(currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;
	}
	
	private boolean isLeafNode(TreeNode <E, K> node) {
		return node.getLeftChild() == null && node.getRightChild() == null;
	}
	
	private boolean isNodeToDeleteLeftChildOf(TreeNode <E, K> parentNode, TreeNode<E, K> node) {
		return parentNode.getLeftChild() != null && parentNode.getLeftChild() == node;
	}	
	
	private boolean isNodeToDeleteRightChildOf(TreeNode <E, K> parentNode) {
		return parentNode.getRightChild() != null;
	}
	
	/*
	 * The following method returns true if the node has only a left child
	 * but no right child
	 */
	private boolean nodeHasOnlyLeftChild(TreeNode<E, K> node) {
		return node.getLeftChild() != null && node.getRightChild() == null;
	}

	/*
	 * The following method returns true if the node has only a right child
	 * but no left child
	 */
	private boolean nodeHasOnlyRightChild(TreeNode<E, K> node) {
		return node.getLeftChild() == null && node.getRightChild() != null;
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
