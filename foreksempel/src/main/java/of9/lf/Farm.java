package of9.lf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Farm implements Iterable<Animal> {

	List<Animal> animals =  new ArrayList<>();
	
	public List<Animal> getAnimals() {
		return new ArrayList<>(animals);
	}
	
	public void addAnimal(Animal animal) {
		if (animals.contains(animal)) { 
			throw new IllegalArgumentException("Animal already added to farm!");
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
}
