package w09OF;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterAnimalsIterator implements Iterator<Animal> {

	int index = 0;
	Farm farm;
	Predicate<Animal> animalPredicate;
	
	public FilterAnimalsIterator(Farm farm, Predicate<Animal> animalPredicate) {
		this.farm = farm;
		this.animalPredicate = animalPredicate;
	}
	
	@Override
	public boolean hasNext() {
		while (index < farm.numberOfAnimals()) {
			if (animalPredicate.test(farm.getAnimal(index))) {
				return true;
			}
			
			index++;
		}
		
		return false;
	}

	@Override
	public Animal next() {
		if (!hasNext()) {
			throw new NoSuchElementException("There is no next element");
		}
		return farm.getAnimal(index++);
	}

}
