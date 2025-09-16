
public class BetterArray implements ListInterface{
	
	private static final int INITIAL_DEFAULT_ARRAY_SIZE = 10;
	private int [] elements = new int[INITIAL_DEFAULT_ARRAY_SIZE];
	
	/*
	 * The following variable will be used to keep track of the amount of the elements that
	 * are currently stored in the array elements.
	 */
	private int numElements = 0;
	

	@Override
	public boolean isEmpty() {
		
		//if(this.numElements == 0)
		//	return true;
		
		
		
		return (this.numElements == 0);
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public void add(int num) {
	
		
		if(this.isFull()) {
			//resize
			this.resize();
			
		}
		
		
		this.elements[this.numElements] = num;
		this.numElements++;
	}

	@Override
	public void add(int num, int index) {
		
		if(index < 0 || index > this.numElements) {
			System.out.println("Invalid index provided");
			return;
		}
		
		if(index ==this.numElements) {
			add(num);
		}else {
			
			if(isFull()) {
				resize();
			}
			
			// Shift values
			for(int i = this.numElements; i > index; i--) {
				elements[i] = elements[i - 1];
			}
			
			this.elements[index] = num;
			this.numElements++;
			
		}
		
	}

	@Override
	public void addSorted(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) {
		if(index < 0 || index >= this.numElements) {
			System.out.println("Invalid index");
			return -1;// We will need to fix this part later.
		}
		
		return elements[index];
		
	}

	@Override
	public int remove(int index) {
		if(index < 0 || index >= this.numElements) {
			System.out.println("Invalid index");
			return -1;// We will need to fix this part later.
		}
		int removedElement;
		if (this.numElements == 1) {
			removedElement = elements[this.numElements - 1];
			
			removeAll();
			return removedElement;
			
		} else if(index == this.numElements-1) {
			removedElement = elements[this.numElements - 1];
			this.numElements--;
			return removedElement;
		}else {
			removedElement = elements[index];
			
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
		this.elements = new int[this.elements.length];
		
	}

	@Override
	public int replace(int num, int index) {
		if(index < 0 || index >= this.numElements) {
			System.out.println("Invalid index");
			return -1;// We will need to fix this part later.
		}
		
		
		int replacedElement = elements[index];
		elements[index] = num;
		
		return replacedElement;
		
	}
	
	private boolean isFull() {
		return this.numElements == this.elements.length;
	}
	
	private void resize() {
		int [] elementsCopy = new int[ (elements.length * 2) ];
		
		for(int i = 0; i < elements.length; i++) {
			elementsCopy[i] =  elements[i];
		}
		
		elements = elementsCopy;
	}

}
