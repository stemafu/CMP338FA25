
public class ArrayBasedStackTester {

	public static void main(String[] args) {
		
		ArrayBasedStack<Integer> stack;
		stack = new ArrayBasedStack<Integer>();
		System.out.println(stack.size());
		stack.push(100);
		stack.push(300);
		stack.push(50);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.size());

	}

}
