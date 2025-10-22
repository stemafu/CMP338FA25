import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBasedQueue<E> implements QueueInterface<E> {
	
	/* A queue is an ADT in which items are 
	 * inserted at the end of the queue (rear or back)
	 * and removed from the front of the queue.
	 * 
	 * We need variables that will maintain the node that is
	 * at the front of the queue and the node that is at the
	 * rear (back) of the queue.
	 */
	
	
	private Node<E> front;
	private Node<E> back;
	private int size;
	
	public LinkedBasedQueue() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.size == 0);
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		
		if(element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		
		/*
		 * We need to place the element into a node.
		 * And after that the node with the element will be added to the 
		 * end of the queue.
		 */
		Node<E> node = new Node<E>(element); // Node with the given element
		if(this.isEmpty()) {
			this.front = node;
			this.back = node;
			this.size++;
		}else {
			this.back.setNext(node);
			node.setPrevious(this.back);
			this.back = node;
			this.size++;
		}
		
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}else {
			return this.front.getData();
		}
	}

	@Override
	public E dequeue() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			/* Take the element that is at the front of the
			 * queue and keep in a variable
			 */
			E removedElement = this.peek();
			if(this.size == 1) {
				this.removeAll();
			}else {
				Node<E> newFront = this.front.getNext();
				newFront.setPrevious(null);
				this.front.setNext(null);
				this.front = newFront;
				size--;
			}
			return removedElement;
		}
		
		
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		if (index < 0 || index >= this.size) {
			throw new NoSuchElementException("invalid index");
		}else if (index == 0) {
			return this.dequeue();
		}else if(index == (this.size - 1)) {
			E removedElement = this.back.getData();
			
			Node<E> newBack = this.back.getPrevious();
			this.back.setPrevious(null);
			this.back = newBack;
			this.back.setNext(null);
			this.size--;
			return removedElement;
		}else {
			Node<E> currentNode = this.front;
			int currentNodeIndex = 0;
			
			while(currentNodeIndex != index){
				currentNode = currentNode.getNext();
				currentNodeIndex++;
			}
			Node<E> currentNodePrevious =currentNode.getPrevious();
			Node<E> currentNodeNext = currentNode.getNext();
			currentNodePrevious.setNext(currentNodeNext);
			currentNodeNext.setPrevious(currentNodePrevious);
			
			currentNode.setNext(null);
			currentNode.setPrevious(null);
			this.size--;
			
			return currentNode.getData();
		}
		
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.size = 0;		
	}
	
}
