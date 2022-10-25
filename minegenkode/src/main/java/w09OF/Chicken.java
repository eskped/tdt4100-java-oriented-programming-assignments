package w09OF;

public class Chicken implements Animal{
	
	private String name;
	private int age;
	
	public Chicken(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String makeSound() {
		return name + " sier klukk";
	}

	@Override
	public int compareTo(Animal o) {
		return this.getAge() - o.getAge();
		//Annen løsning: return new AnimalComparator().compare(this, o);
	}
}
