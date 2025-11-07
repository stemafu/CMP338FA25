import java.util.LinkedList;

public class Intro {
	
	LinkedList [] array = new LinkedList[1069];
	
	public Intro() {
		
		for(int i = 0; i <array.length; i++) {
			array[i] = new LinkedList();
		}
	}
	
	public void add(Integer x, int key) {
		
		int hacoValue  = key % array.length;
		
		for(int i = 0; i <array.length; i++) {
			System.out.println(array[i].size());
		}
		
		System.out.println("Before is done");
		array[hacoValue].add(x);
		
		for(int i = 0; i <array.length; i++) {
			System.out.println(array[i].size());
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] args) {
		 Intro i = new Intro();
		 i.add(67, 9);
		 i.add(100, 19);
		 
		 i.add(100, 0);
	}

}
