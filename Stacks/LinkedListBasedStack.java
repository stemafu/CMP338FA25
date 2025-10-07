import java.util.Iterator;

public class LinkedListBasedStack<E> implements StackInterface<E>{
	
	private Node<E> top;
	private Node<E> bottom;
	private int size;
	
	public LinkedListBasedStack() {
		top = null;
		bottom = null;
		size = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		//return top == null;
		return size == 0;
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		if(e == null) {
			throw new NullPointerException("e cannot be null");
		}
		
		// We create a node
		Node<E> node = new Node<E>(e);
		if(this.isEmpty()) {
			this.top = node;
			this.bottom = node;
		}else {
			
			this.top.setNext(node);
			node.setPrevious(this.top);
			this.top = node;
		}
		
		this.size++;	
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			return this.top.getData();
		}
	}

	@Override
	public E pop() {
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement = this.peek();
			if(this.size == 1) {
				this.clear();
				return removedElement;
			}else {
				
				/*Node<E> currentNode = this.bottom;
				int index = 0;
				
				while(index < (this.size - 2) ) {
					currentNode = currentNode.getNext();
					index++;
				}
				
				top = currentNode;
				top.setNext(null);;
				size--;
				
				return removedElement;*/
				
				this.top = this.top.getPrevious();
				top.setNext(null);
				return removedElement;
				
			}
			
			
			
			
		}
	}

	@Override
	public void clear() {
		this.top = null;
		this.bottom = null;
		this.size = 0;
	}

}
