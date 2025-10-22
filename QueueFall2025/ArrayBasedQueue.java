import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBasedQueue<E> implements QueueInterface<E> {
	private int INITIAL_DEFAULT_QUEUE_SIZE = 5;
	private Object [] elements;
	private int front;
	private int back;
	private int count;
	
	public ArrayBasedQueue() {
		this.elements = new Object[INITIAL_DEFAULT_QUEUE_SIZE];
		this.front = -1;
		this.back = 0;
		this.count = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		
		return this.count;
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
		
		//Check to see if the array is full
		if(this.isFull()) {
			throw new IllegalStateException("The queue is full. You cannot add new elements");
		}
		
		if(this.isEmpty()) {
			elements[0] = element;
			this.front = 0;
			//this.back = (this.back + 1) % this.elements.length;
		}else {
			elements[this.back] = element;
			//this.back = (this.back + 1) % this.elements.length;
		}
		this.back = (this.back + 1) % this.elements.length;
		this.count++;
		
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}else {
			return (E)this.elements[this.front];
		}
	}

	@Override
	public E dequeue() {
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement = (E)this.elements[this.front];
			this.front = (this.front + 1) % this.elements.length;
			this.count--;
			return removedElement;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		this.elements = new Object[INITIAL_DEFAULT_QUEUE_SIZE];
		this.front = -1;
		this.back = 0;
		this.count = 0;
		
	}
	
	public boolean isFull() {
		return (this.count == elements.length);
	}

}
