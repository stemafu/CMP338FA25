
public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(20);
		list.add(50);
		list.add(70);
		list.add(40);
		
		System.out.println(list.replace(300, 3));
		System.out.println(list.get(3));
	}

}
