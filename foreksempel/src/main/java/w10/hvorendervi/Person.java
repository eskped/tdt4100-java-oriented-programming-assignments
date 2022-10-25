package w10.hvorendervi;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Ved � ta en vandring gjennom en del spennende tema, og det starter med
 * Interface, vil dere om noen uker kunne forst� hvorfor koden i main her
 * fungerer. Dere vil forst�, og kunne bruke, lambdafunksjoner og streams (men
 * dette skal vi l�re mer om seinere, men du f�r en teaser her). Tenk s� mye tid
 * dere sparer p� � kunne skrive slik kode. Ikke bare p� eksamen, dette brukes
 * masse ute i industrien. Og i andre spr�k! Dette, og myyyyyye mer, kan gj�res.
 */
public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}

	public static void main(String[] args) {
		Collection<Person> persons = new ArrayList<>();
		persons.add(new Person("Per Hansen", 26));
		persons.add(new Person("Ivar Sk�r", 3));
		persons.add(new Person("Jenny Hval", 13));
		persons.add(new Person("Metusalem", 969));
		persons.add(new Person("Fersken", 1));
		persons.add(new Person("Sistemann", 12));

		// Hvem er eldre enn tolv �r?
		System.out.println("Hvem er eldre enn tolv �r?");
		persons.forEach(x -> {
			if (x.getAge() > 12)
				System.out.println(x);
		});

		System.out.println();

		// Hvor mange er eldre enn tolv �r?
		ValueContainer merEnnTolv = new ValueContainer();
		persons.forEach(x -> {
			if (x.getAge() > 12)
				merEnnTolv.setIntValue(merEnnTolv.getIntValue() + 1);
		});
		System.out.println("Hvor mange er eldre enn tolv �r? " + merEnnTolv.getIntValue());

		// samme resultat, men ved bruk av streams, som vi skal l�re om i en seinere
		// forelesning
		// System.out.println("Hvor mange er eldre enn tolv �r? " +
		// persons.stream().filter(p -> p.getAge() > 12).count());

		System.out.println();

		// Hva er summen av alle sine aldere?
		ValueContainer sumAvAlder = new ValueContainer();
		persons.forEach(x -> {
			sumAvAlder.setIntValue(sumAvAlder.getIntValue() + x.getAge());
		});
		System.out.println("Hva er summen av alle sine aldere? " + sumAvAlder.getIntValue());

		// samme resultat, men ved bruk av streams, som vi skal l�re om i en seinere
		// forelesning
		// System.out.println("Hva er summen av alle sine aldere? " +
		// persons.stream().mapToInt(p -> p.getAge()).sum());

		System.out.println();

		// Hva er navnet p� den yngste som har et navn med e?
		ValueContainer navn = new ValueContainer();
		persons.forEach(x -> {
			if (x.getName().contains("e") && (navn.getIntValue() == 0 || navn.getIntValue() > x.getAge())) {
				navn.setIntValue(x.getAge());
				navn.setStringValue(x.getName());
			}
		});
		System.out.println("Hva er navnet p� den yngste som har et navn med e? " + navn.getStringValue() + " ("
				+ navn.getIntValue() + ")");

		// samme resultat, men ved bruk av streams, som vi skal l�re om i en seinere
		// forelesning
//		System.out.println("Hva er navnet p� den yngste som har et navn med e? " + persons.stream()
//				.filter(p -> p.getName().contains("e")).min((o1, o2) -> o1.getAge() - o2.getAge()).get());
	}

	private static class ValueContainer {
		private int intValue = 0;
		private String stringValue = "";

		public int getIntValue() {
			return intValue;
		}

		public void setIntValue(int intValue) {
			this.intValue = intValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}
	}
}
