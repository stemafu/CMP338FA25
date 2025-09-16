
public class BetterArrayDriver {

	public static void main(String[] args) {
		
		BetterArray list = new BetterArray();
		
		System.out.println(list.size());
		for(int i = 1; i < 1001; i++) {
			
			list.add(i);
		}
		
		
		for(int i = 1000; i >= 0; i--) {
			
			list.add(i);
		}
		
		System.out.println(list.size());

	}

}
