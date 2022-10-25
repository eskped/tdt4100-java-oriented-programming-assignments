package w04;

/**
 * En superenkel Personklasse som vi skal stappe inn i biler. Dersom det er
 * plass.
 * 
 * @author borgeha
 *
 */
public class PersonOrig {
	private String name;
	private int age;

	public PersonOrig(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "PersonOrig [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		PersonOrig p = new PersonOrig("Per Orig", 23);
		System.out.println(p.toString());
	}
}
