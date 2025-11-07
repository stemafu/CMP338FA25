import java.util.Objects;

public class Person<K> implements KeyedElementInterface<K> {
	private K key;
	private String name;
	private int age;
	
	
	
	public Person(K key, String name, int age) {
		super();
		this.key = key;
		this.name = name;
		this.age = age;
	}

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public KeyedElementInterface<K> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Person [key=" + key + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		
		  int result = 17; // A prime number
	        result = 31 * result + age;
	        result = 31 * result + name.hashCode();
	      
	        return result;
		
	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(key, other.key) && Objects.equals(name, other.name);
	}
	
	
	

}
