
public class BetterArrayDriver {

	public static void main(String[] args) {
		
		BetterArray list = new BetterArray();
		
		int n = 1000;
		
		int testNums [] = new int [n];
		
		System.out.println("Size before adding values = " +list.size());
		for(int i = 0; i < n; i++) {
			testNums[i] = i;
			list.add(i);
		}
		
		for(int i = 0; i <n; i++) {
			if(testNums[i] != list.get(i)) {
				System.out.println("not equal");
				return;
			}
		}
		System.out.println("test successful");
		//for(int i = 1000; i >= 0; i--) {
			
		//	list.add(i);
		//}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("size after adding values = " + list.size());
		

	}

}
