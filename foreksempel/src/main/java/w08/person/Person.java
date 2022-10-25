package w08.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Person implements Iterable<Person> {
	private Collection<Person> children = new ArrayList<>();
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void addChild(Person child) {
		children.add(child);
	}

	@Override
	public Iterator<Person> iterator() {
		return children.iterator();
	}

	@Override
	public String toString() {
		// siden children er av type Iterable itereres det automatisk over denne
		// kolleksjonen siden vi ber om at kolleksjonen skal skrives ut
		return String.format("%s (%d), barn= [%s]", getName(), getAge(), children);
	}

	public static void main(String[] args) {
		Person p = new Person("Børge", 46);
		Person j = new Person("Jørn", 27);
		Person h = new Person("Håvard", 11);
		Person s = new Person("Silje", 3);

		p.addChild(j);
		p.addChild(h);
		j.addChild(s);

		// Her skriver vi ut strengen, legg merke til hva som skjer
		System.out.println(p);

		System.out.println("-----------------------");

		// her ber vi om at vår egen iterator benyttes
		for (Iterator<Person> iterator = p.iterator(); iterator.hasNext();) {
			Person person = iterator.next();
			System.out.println(person);
		}
	}
}
