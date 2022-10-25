package w09OF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Farm implements Iterable<Animal>{
	
	private List<Animal> animals = new ArrayList<>();
	
	public List<Animal> getAnimals() {
		return new ArrayList<>(animals);
	}
	
	public void addAnimal(Animal animal) {
		if (animals.contains(animal)) {
			throw new IllegalArgumentException();
		}
		animals.add(animal);
	}
	
	
	public Animal getAnimal(int index) {
		return animals.get(index);
	}
	
	public int numberOfAnimals() {
		return animals.size();
	}
	

	@Override
	public Iterator<Animal> iterator() {
		return animals.iterator();
	}
	
	public List<String> getAnimalNames() {
		return animals.stream()
					  .map(animal -> animal.getName())
					  .distinct()
					  .collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm();
		farm.addAnimal(new Dog("Ludo", 12));
		farm.addAnimal(new Dog("Fido", 0));
		farm.addAnimal(new Chicken("Peter", 1));
		farm.addAnimal(new Chicken("Peter", 4));

		for (String name : farm.getAnimalNames()) {
			System.out.println(name);
		}
	}
}


