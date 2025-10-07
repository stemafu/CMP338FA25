
public class LinkedList<I extends java.lang.Comparable<? super I>> 
implements ListInterface<I>{
	
	private Node<I> head = null;
	private Node<I> tail = null;
	private int numElements = 0;
	
	
	/*
	 * A linked list data structure is a data structure 
	 * containing the list's head and tail, and may also 
	 * include additional information, such as the list's size.
	 */

	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
	
		return this.numElements == 0;
	}

	@Override
	public void add(I element) {
		
		/*
		 * We need to check if the element is null because we don't
		 * want such element in our list
		*/
		
		/*if the list is empty, it means the element being added will
		 * head and the tail
		 */
		Node<I> node1 = new Node<I>(element);
		if(this.isEmpty()) {
			//Node<I> node1 = new Node<I>(element);
			
			
			head = node1;
			//tail = node1;
			//this.numElements++;
		}else {
			/*If the list is not empty, we add the new element to the
			 * tail of the list
			 */
			//Node<I> node1 = new Node<I>(element);
			this.tail.setNext(node1);
			//this.tail = node1;
			//this.numElements++;
		}
		this.tai nl =ode1;
		this.numElements++;
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index > this.numElements) {
			throw new IndexOutOfBoundsException("Please use a valid index");
		}
		
		if(this.isEmpty() || (index == this.numElements) ) {
			this.add(element);
		}else if (index == 0) {
			Node<I> newNode = new Node<I>(element);
			newNode.setNext(this.head);
			this.head = newNode;
			this.numElements++;
			
		}else {
			
			int currentNodeIndex = 0;
			Node<I> currentNode = this.head;
			Node<I> previousNode = null;
			// Search where to insert the neweNode
			while(currentNodeIndex < index) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				currentNodeIndex++;
			}
			
			Node<I> newNode = new Node<I>(element);
			
			previousNode.setNext(newNode);
			newNode.setNext(currentNode);
			this.numElements++;
			
			
		}
		
	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= this.numElements) {
			throw new IndexOutOfBoundsException("Please use a valid index");
		}
		
		
		/*
		 * Unlike arrays, Linked lists have no random access.
		 * As such, in order for us to get values from a linkedlist,
		 * we have to iterate through the list until the intended index.
		 */
		int currentIndex = 0;
		Node<I> currentNode = this.head;
		
		while(currentIndex != index) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		
		
		return currentNode.getData();
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
	
		if(index < 0 || index >= this.numElements) {
			throw new IndexOutOfBoundsException("Please use a valid index");
		}		
		
		int currentIndex = 0;
		Node<I> currentNode = this.head;
		
		while(currentIndex != index) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		
		I removedElement = currentNode.getData();
		
		currentNode.setData(element);
		
		return removedElement;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= this.numElements) {
			throw new IndexOutOfBoundsException("Please use a valid index");
		}	
		
		I removedElement = null;
		if(this.numElements == 1) {
			removedElement = this.head.getData();
			this.removeAll();
		}else if (index == 0) {
			removedElement = this.head.getData();
			this.head = this.head.getNext();
			this.numElements--;
		} else {
			// {
	       //}
			
			int currentNodeIndex = 0;
			Node<I> currentNode = this.head;
			Node<I> previousNode = null;
			// Search where to insert the neweNode
			while(currentNodeIndex < index) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				currentNodeIndex++;
			}
			
			if(index == (this.numElements - 1 )) {
				removedElement = tail.getData();
				this.tail = previousNode;
				this.tail.setNext(null);
				this.numElements--;
			}else {
				removedElement = currentNode.getData();
				previousNode.setNext(currentNode.getNext());
				this.numElements--;
			}
			
		}
		
		return removedElement;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
		
	}

}
