package kortforklart;

public class Dog {
	
	private String name;
	private int age;
	private String breed;
	
	public Dog(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
	}

	public Dog(int age, String breed) {
		this.age = age;
		this.breed = breed;
	}
	
	public Dog(String breed) {
		this(7, breed);
	}
	
	public void bark() {
		System.out.println("Woof");
	}
	
	public int getDogYears() {
		return this.age * 7;
	}
	
	public static void main(String[] args) {
		Dog pluto = new Dog("pluto", 10, "Golden Retriver");
		pluto.bark();
		System.out.println(pluto.getDogYears());
		Dog tinka = new Dog("Puddel");
		System.out.println(tinka.getDogYears());
		
	}
	
}
