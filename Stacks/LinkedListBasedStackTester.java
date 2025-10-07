
public class LinkedListBasedStackTester {

	public static void main(String[] args) {
		LinkedListBasedStack<Integer> stack;
		
		stack = new LinkedListBasedStack<Integer>();
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		stack.push(100);
		stack.push(300);
		stack.push(50);
		stack.push(40);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peek());

	}

}
