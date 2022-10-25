package w05.person_v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
	}

	public static void main(String[] args) {
		new PersonRegister();
	}

	/*
	 * Her benytter vi det felles grensesnittet for IPerson klasser.
	 */
	public void println(IPerson person) {
		if (person != null) {
			System.out.println("ID:\t\t" + person.getId());
			System.out.println("Given name:\t" + person.getGivenName());
			System.out.println("Family name:\t" + person.getFamilyName());
			System.out.println("Full name:\t" + person.getFullName());
		}
	}
}
