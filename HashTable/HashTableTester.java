
public class HashTableTester {

	public static void main(String[] args) {
		
		//HashTable<Person<Integer>, Integer> table;
		//table = new HashTable<Person<Integer>, Integer>();
		
		
		HashTable<Person<Integer>, Integer> table;
		table = new HashTable<Person<Integer>, Integer>();
		
		Person <Integer> p1, p2, p3, p4;
		p1 = new Person<Integer>(10, "Person 1", 50);
		p2 = new Person<Integer>(20, "Person 2", 80);
		p3 = new Person<Integer>(0, "Person 3", 50);
		p4 = new Person<Integer>(10, "Ocean Avenue", 50);
		
		
		table.insert(p1);
		table.insert(p2);
		table.insert(p3);
		table.insert(p4);
		
		System.out.println(table.get(10));

	}

}
