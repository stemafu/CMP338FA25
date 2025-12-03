
public class MaxHeap {
	
	private int [] heap;
	private int size;
	private int default_capacity = 10;
	
	public MaxHeap() {
		this.heap = new int[default_capacity];
		this.size = 0;
	}
	
	public MaxHeap(int cap) {
		this.heap = new int[cap];
		this.size = 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void insert(int element) {
		if(this.size == this.heap.length) {
			System.out.println("The heap is full");
			return;
		}
		
		this.heap[size] = element;
		this.size++;
		
		heapifyUP();
	}
	
	
	public int remove() {
		
		if(this.size == 0) {
			System.out.println("You cannot remove from an empty heap");
			throw new NullPointerException("You cannot remove from an empty heap");
		}
		
		int removedElement = this.heap[0];
		
		this.heap[0] = this.heap[this.size - 1];
		this.size--;
		this.heapifyDown();
		// we need to return the removed item
		return removedElement;
	}
	
	
	private void heapifyDown() {
		int index = 0;
		
		
		while(true) {
			
			
			int leftChildIndex = (2 * index) + 1;
			int rightChildIndex = (2 * index) + 2;
			int largest = index;
			
			/*
			 * Here our goal is to find which of these two children
			 * is the largest that can substitute the parent
			 */
			
			if(this.heap[leftChildIndex] > this.heap[largest] && leftChildIndex < this.size) {
				largest = leftChildIndex;
			}
			
			if(this.heap[rightChildIndex] > this.heap[largest] && rightChildIndex < this.size) {
				largest = rightChildIndex;
			}
			
			if(largest != index) {
				int temp = this.heap[largest];
				this.heap[largest] = this.heap[index];
				this.heap[index] = temp;
				
				index = largest;
			}else {
				break;
			}
			
			
		}
	}
	
	private void heapifyUP() {
		
		// This is the index of the just newly inserted value
		int index = this.size - 1;
		///System.out.println(heap[index]);
		
		while(index > 0) {
			
			int parentIndex = (index - 1) / 2;
			
			if(this.heap[index] > this.heap[parentIndex]) {
				// swap
				int temp = this.heap[index];
				this.heap[index] = this.heap[parentIndex];
				this.heap[parentIndex] = temp;
				
				index = parentIndex;
			}else {
				break;
			}
			
		}
		
	}
	
	public void display() {
		for(int i = 0; i < this.size; i++) {
			System.out.print(this.heap[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		MaxHeap heap = new MaxHeap();
		
		heap.insert(4);
		heap.insert(10);
		heap.insert(3);
		heap.insert(5);
		heap.insert(1);
		heap.insert(12);
		heap.display();
		
		int [] array = new int[heap.size];
		
		int count = heap.size -1;
		for(int i = 0; i  < array.length; i++, count--) {
			array[count] = heap.remove();
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		//System.out.println(heap.remove());
		//System.out.println(heap.remove());
		//System.out.println(heap.remove());
		//System.out.println(heap.remove());
		//System.out.println(heap.remove());
		//System.out.println(heap.remove());
		
		
	}
	
}
