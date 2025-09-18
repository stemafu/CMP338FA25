
public class Box <T>{
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public static void main(String [] args) {
		Box <Integer> box1 = new Box<Integer>();
		box1.setValue(90);
		
		Box <String> box2 = new Box<String>();
		box2.setValue("Bronx");
	}

}
