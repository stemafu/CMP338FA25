
public class Node<I extends java.lang.Comparable<? super I>> {
	
	
	/*
	 * In a linked list, each node stores data and a link to the next
	 * node
	 */
	
	// The following variable will be used to store data on a node
	private I data;
	
	// The following variable will be use to keep the address of the next node
	private Node<I> next;
	
	// The constructor will be used to create a node
	
	public Node(I data) {
		this.data = data;
		this.next = null;
	}

	public I getData() {
		return data;
	}

	public void setData(I data) {
		this.data = data;
	}

	public Node<I> getNext() {
		return next;
	}

	public void setNext(Node<I> next) {
		this.next = next;
	}
	
	
	
	
}
