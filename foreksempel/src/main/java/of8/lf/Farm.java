package of8.lf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farm {

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
}
