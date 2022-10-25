package w04OF;

public class Person {
	private String name;
	
	
	public Person(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		checkThatNameIsReal(name);
		this.name = name;
	}
	
	private boolean checkThatNameIsReal(String name) {
		//en metode som skal sjekke at name er riktigs
		return true;
	}
	
	
	public static void main(String[] args) {
		Person p1 = new Person("Eskil");
		System.out.println(p1.name);
	}
}
