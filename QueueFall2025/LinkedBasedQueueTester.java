
public class LinkedBasedQueueTester {

	public static void main(String[] args) {
		LinkedBasedQueue<Integer> queue;
		queue = new LinkedBasedQueue<Integer>();
		
		queue.enqueue(40);
		queue.enqueue(60);
		
		for(int i = 1; i < 20; i++) {
			queue.enqueue(i);
		}
		
		System.out.println(queue.size());
		System.out.println(queue.peek());
		
		System.out.println(queue.dequeue(1));
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		int count = queue.size();
		
		for(int i = 0; i < count; i++) {
			System.out.println(queue.dequeue());
		}
		System.out.println(queue.size());

	}

}
