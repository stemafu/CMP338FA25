import java.util.Iterator;

public class ArrayBasedStack <E> implements StackInterface<E> {

	/* We need an array which will be used to store values for the stack
	 * We also need a variable that will keep track of the number of the
	 * elements currently stored in the stack.
	 */
	
	private Object arrayStack []; 
	private int size;
	private int max_array_size = 5;
	
	public ArrayBasedStack() {
		this.arrayStack = new Object[max_array_size];
		this.size = 0;
	}
	
	public ArrayBasedStack(int max_size) {
		this.arrayStack = new Object[max_size];
		this.size = 0;
	}	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.size == 0);
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
		
		if(this.size == arrayStack.length) {
			throw new IllegalStateException("The stack is full. You cannot add at the moment");
		}
		
		this.arrayStack[this.size] = e;
		this.size++;
		
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}else {
			return (E)this.arrayStack[(this.size - 1)];
		}
	}

	@Override
	public E pop() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement = (E)arrayStack[this.size - 1];
			this.size--;
			return removedElement;
		}
		
		
	}

	@Override
	public void clear() {
		this.size = 0;
		this.arrayStack = new Object[max_array_size];
	}

}
