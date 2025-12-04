
public class BSTtest {
	public static void main(String [] args) {
		BinarySearchTree<Person<Integer>, Integer> tree;
		
		tree = new BinarySearchTree<Person<Integer>, Integer>();
		
		
		Person <Integer> p1, p2, p3, p4, p5, p6;
		p1 = new Person<Integer>(56, "Person 1", 50);
		p2 = new Person<Integer>(34, "Person 2", 80);
		p3 = new Person<Integer>(68, "Person 3", 50);
		p4 = new Person<Integer>(45, "Ocean Avenue p4", 50);
		p5 = new Person<Integer>(21, "P5", 50);
		p6 = new Person<Integer>(86, "P5", 50);
		
		tree.insert(p1);
		
		tree.insert(p2);
		//System.out.println("Now print the values");
		tree.insert(p3);
		tree.insert(p4);
		tree.insert(p5);
		tree.insert(p6);
		
		tree.inOrder();
		System.out.println();
		tree.preOrder();
		
		System.out.println("The following shows the data in the tree in post order:");
		tree.postOrder();
	}

}
