
public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		/*list.add(20);
		list.add(50);
		list.add(70);
		list.add(40);
		
		System.out.println(list.replace(300, 3));
		System.out.println(list.get(3));
		
		
		list.add(1000, 0);
		list.add(2000, 0);
		System.out.println(list.get(0));
		
		list.add(90, 3);
		System.out.println(list.get(3));
		*/
		
		for(int i = 0; i < 1000; i++) {
			list.add(i);
		}
		
		for(int i = 0; i < 1000; i++) {
			System.out.println(list.get(i));
		}
		
	}

}
