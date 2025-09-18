
public class ArrayBasedList <I extends Comparable<? super I>> implements ListInterface<I>{

	
	private static final int INITIAL_DEFAULT_ARRAY_SIZE = 10;
	private Object [] elements = new Object[INITIAL_DEFAULT_ARRAY_SIZE];
	
	/*
	 * The following variable will be used to keep track of the amount of the elements that
	 * are currently stored in the array elements.
	 */
	private int numElements = 0;	
	
	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (numElements == 0);
	}

	@Override
	public void add(I element) {
		
		if(this.isFull()) {
			//resize
			this.resize();
			
		}
		
		
		this.elements[this.numElements] = element;
		this.numElements++;	
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {

		if(index < 0 || index > this.numElements) {
			throw new IndexOutOfBoundsException("Invalid index provided " + index);
		}
		

		if(index ==this.numElements) {
			add(element);
		}else {
			
			if(isFull()) {
				resize();
			}
			
			// Shift values
			for(int i = this.numElements; i > index; i--) {
				elements[i] = elements[i - 1];
			}
			
			this.elements[index] = element;
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
			throw new IndexOutOfBoundsException("Invalid index provided " + index);
		}
		
		
		return (I)elements[index];
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= this.numElements) {
			throw new IndexOutOfBoundsException("Invalid index provided " + index);
		}
		
		
		I replacedElement = (I)elements[index];
		elements[index] = element;
		
		return replacedElement;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= this.numElements) {
			throw new IndexOutOfBoundsException("Invalid index provided " + index);
		}
		
		
		I removedElement;
		if (this.numElements == 1) {
			removedElement = (I)elements[this.numElements - 1];
			
			removeAll();
			return removedElement;
			
		} else if(index == this.numElements-1) {
			removedElement = (I)elements[this.numElements - 1];
			this.numElements--;
			return removedElement;
		}else {
			removedElement = (I)elements[index];
			
			// shift
			for(int i = index; i < numElements -1; i++) {
				elements[i] = elements[i + 1];
			}
			
			this.numElements--;
			return removedElement;
		}
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.elements = new Object[this.elements.length];
		
	}
	
	
	private boolean isFull() {
		return this.numElements == this.elements.length;
	}
	
	private void resize() {
		Object [] elementsCopy = new Object[ (elements.length * 2) ];
		
		for(int i = 0; i < elements.length; i++) {
			elementsCopy[i] =  elements[i];
		}
		
		elements = elementsCopy;
	}	

}
