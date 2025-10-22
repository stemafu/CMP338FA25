
public class Node <E> {
	private Node<E> previous;
	private E data;
	private Node<E> next;
	
	public Node(E data) {
		this.data = data;
		this.next = null;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}	
	
	public E getData() {
		return this.data;
	}
	
	public Node<E> getNext(){
		return this.next;
	}
	 
	public Node<E> getPrevious(){
		return previous;
	}
	 

}
