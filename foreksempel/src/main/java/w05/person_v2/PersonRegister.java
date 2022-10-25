package w05.person_v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class PersonRegister {
	private ArrayList<IPerson> persons = new ArrayList<IPerson>();

	public PersonRegister() {
		// først opprett noen objekter med hver sin variabel for enkelt tilgang i
		// testene under
		IPerson person1 = new Person1("Stein", "Tomassen", 1);
		IPerson person2 = new Person2("Jens Hansen", 2);
		IPerson person3 = new Person1("Ida", "Hansen", 3);
		IPerson person4 = new Person2("Småen Sund", 4);
		IPerson person5 = new Person2("Geir Tomassen", 5);

		// legge til objektene i listen over personer
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);

		int i = 0;
		for (Iterator<IPerson> iterator = persons.iterator(); iterator.hasNext();) {
			IPerson person = iterator.next();
			System.out.println("Person#" + ++i); // hmm, ++i og ikke i++? Hva er forskjellen?
			println(person);
		}

//		System.out.println();
//		System.out.println("Finn første person som er lik person #2");
//		println(findFirst(person2));
//
//		System.out.println();
//		System.out.println("Finn alle personer som er lik person #2");
//		Collection<IPerson> allPerson2s = findAll(person2);
//		int ii = 1;
//		for (Iterator<IPerson> iterator = allPerson2s.iterator(); iterator.hasNext();) {
//			System.out.println("#" + ii++);
//			println(iterator.next());
//		}

//		System.out.println();
//		System.out.println("Usortert");
//		for (IPerson person : persons) {
//			System.out.println(person);
//		}

		// Standard sammenlikner er implementert med "implements Comparable"
		// ArrayList sin statiske metode gjennomfører selve sorteringen, men
		// DU må fortelle den hva som er rett mhp mer og mindre verd.
//		System.out.println();
//		Collections.sort(persons);  
//		System.out.println("\nSortert etter fullt navn"); 
//		for (IPerson person : persons) {
//			System.out.println(person);
//		}

//		System.out.println();
//		System.out.println("\nSortert etter etternavn"); 
//		// Her bruker vi en annen comparator enn den vanlige
//		Collections.sort(persons, new PersonFamilyNameComparator()); 
//		for (IPerson person : persons) {
//			System.out.println(person);
//		}
	}

	public static void main(String[] args) {
		new PersonRegister();
	}

	/*
	 * Her benytter vi det felles grensesnittet for klasser som implementerer
	 * IPerson.
	 */
	public void println(IPerson person) {
		if (person != null) {
			// men vi kan sjekke om selve objektet er en instans av en spesifikk klasse
			// hvis så er tilfelle kan vi kaste/cast til denne klassen får å få tilgang til
			// dens metoder
			// Casting gjøres ved følgende syntaks
			// "(class) object" feks "(Person1) person"
//			if (person instanceof Person1) {
//				// legg merke til
//				Person1 p1 = (Person1) person;
//				System.out.println("Objekt er instans av " + p1.getPerson1ClassInfo() + " klassen");
//			} else if (person instanceof Person2) {
//				Person2 p2 = (Person2) person;
//				System.out.println("Objekt er instans av " + p2.getPerson2ClassInfo() + " klassen");
//			}

			System.out.println("\tID:\t\t" + person.getId());
			System.out.println("\tGiven name:\t" + person.getGivenName());
			System.out.println("\tFamily name:\t" + person.getFamilyName());
			System.out.println("\tFull name:\t" + person.getFullName());
		}
	}

	public IPerson findFirst(Predicate<IPerson> tester) {
		if (tester != null && persons != null) {
			for (IPerson person : persons) {
				if (tester.test(person)) {
					return person;
				}
			}
		}
		return null;
	}

	public Collection<IPerson> findAll(Predicate<IPerson> tester) {
		Collection<IPerson> result = new ArrayList<IPerson>();
		if (tester != null && persons != null) {
			for (IPerson person : persons) {
				if (tester.test(person)) {
					result.add(person);
				}
			}
		}
		return result;
	}
}
