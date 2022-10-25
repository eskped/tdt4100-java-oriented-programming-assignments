package of9.kode;

public interface Animal extends Comparable<Animal> {
	
	String getName();
	
	int getAge();
	
	String makeSound();
}