package w05.person_v2;

public abstract class Person implements IPerson {
	private int id;

	public Person(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean test(IPerson person) {
		return getFamilyName().equals(person.getFamilyName());
	}

	@Override
	public int compareTo(IPerson person) {
		int sort = getFullName().compareTo(person.getFullName());
		if (sort > 0) {
			return 1;
		} else if (sort < 0) {
			return -1;
		} else {
			return getFullName().compareTo(person.getFullName());
		}
	}

	@Override
	public String toString() {
		return getId() + ": " + getFullName();
	}
}
