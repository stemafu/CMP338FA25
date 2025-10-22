
public class ArrayBasedQueueTester {

	public static void main(String[] args) {
		ArrayBasedQueue<Integer> q = new ArrayBasedQueue<Integer>();
		
		q.enqueue(90);
		q.enqueue(40);
		q.enqueue(30);
		q.enqueue(20);
		q.enqueue(10);
		//q.enqueue(10);
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(100);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.size());

	}

}
