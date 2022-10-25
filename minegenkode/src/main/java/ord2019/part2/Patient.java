package ord2019.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/** * A patient has a set of (health) conditions (of type String) that needs to be treated.
 * Supports iterating over the patient's conditions.
 */
public class Patient implements Iterable<String> {


	private Collection<String> conditions = new ArrayList<>();

	public Patient() {
	}
	
	public void addConditions(String... conditions) {
		this.conditions.addAll(Arrays.asList(conditions));
	}
	
	
	public void removeConditions(Collection<String> fixedConditions) {
		this.conditions.removeAll(fixedConditions);
	}

	/**
	 * Indicates if this patient has conditions that needs to be treated.
	 * @return true if this patient has conditions that needs to be treated,
	 * false otherwise.
	 */
	public boolean requiresTreatment() { // 2a
		if (this.conditions.isEmpty()) {
			return false;
		}
		return true;
	}


	@Override
	public Iterator<String> iterator() {
		return conditions.iterator();
	}
	
}
