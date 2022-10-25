package w05.person_w04;

import w04.Person1;
import w04.Person2;
import w05.person_v1.IPerson;

public class PersonRegister {
	public PersonRegister() {
		// først opprett noen objekter med hver sin variabel for enkelt tilgang i
		// testene under
		Person1 person1 = new Person1("Stein", "Tomassen");
		Person2 person2 = new Person2("Jens Hansen");
		Person1 person3 = new Person1("Ida", "Hansen");
		Person2 person4 = new Person2("Småen Sund");
		Person2 person5 = new Person2("Geir Tomassen");

		// så kan vi skrive ut informasjon om hvert objekt
		System.out.println("Person#1");
		println(person1);
		System.out.println("Person#2");
		println(person2);
		System.out.println("Person#3");
		println(person3);
		System.out.println("Person#4");
		println(person4);
		System.out.println("Person#5");
		println(person5);
		/*
		 * Litt tungvint at vi må ha to forskjellige metoder for så godt som samme type
		 * klasse, er det ikke? Kan vi gjøre dette mer elegant? Ja det kan vi, ved feks
		 * hjelp av felles grensesnitt.
		 */
	}

	public static void main(String[] args) {
		new PersonRegister();
	}

	/*
	 * Her bruker vi overlasting som tillater metode med samme navn, men med
	 * forskjellige datatyper
	 */
	public void println(Person1 person) {
		if (person != null) {
			System.out.println("Given name:\t" + person.getGivenName());
			System.out.println("Family name:\t" + person.getFamilyName());
			System.out.println("Full name:\t" + person.getFullName());
		}
	}

	/*
	 * Her bruker vi overlasting som tillater metode med samme navn, men med
	 * forskjellige datatyper
	 */
	public void println(Person2 person) {
		if (person != null) {
			System.out.println("Given name:\t" + person.getGivenName());
			System.out.println("Family name:\t" + person.getFamilyName());
			System.out.println("Full name:\t" + person.getFullName());
		}
	}
}
