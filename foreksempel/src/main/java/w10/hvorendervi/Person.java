package w10.hvorendervi;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Ved å ta en vandring gjennom en del spennende tema, og det starter med
 * Interface, vil dere om noen uker kunne forstå hvorfor koden i main her
 * fungerer. Dere vil forstå, og kunne bruke, lambdafunksjoner og streams (men
 * dette skal vi lære mer om seinere, men du får en teaser her). Tenk så mye tid
 * dere sparer på å kunne skrive slik kode. Ikke bare på eksamen, dette brukes
 * masse ute i industrien. Og i andre språk! Dette, og myyyyyye mer, kan gjøres.
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
		persons.add(new Person("Ivar Skår", 3));
		persons.add(new Person("Jenny Hval", 13));
		persons.add(new Person("Metusalem", 969));
		persons.add(new Person("Fersken", 1));
		persons.add(new Person("Sistemann", 12));

		// Hvem er eldre enn tolv år?
		System.out.println("Hvem er eldre enn tolv år?");
		persons.forEach(x -> {
			if (x.getAge() > 12)
				System.out.println(x);
		});

		System.out.println();

		// Hvor mange er eldre enn tolv år?
		ValueContainer merEnnTolv = new ValueContainer();
		persons.forEach(x -> {
			if (x.getAge() > 12)
				merEnnTolv.setIntValue(merEnnTolv.getIntValue() + 1);
		});
		System.out.println("Hvor mange er eldre enn tolv år? " + merEnnTolv.getIntValue());

		// samme resultat, men ved bruk av streams, som vi skal lære om i en seinere
		// forelesning
		// System.out.println("Hvor mange er eldre enn tolv år? " +
		// persons.stream().filter(p -> p.getAge() > 12).count());

		System.out.println();

		// Hva er summen av alle sine aldere?
		ValueContainer sumAvAlder = new ValueContainer();
		persons.forEach(x -> {
			sumAvAlder.setIntValue(sumAvAlder.getIntValue() + x.getAge());
		});
		System.out.println("Hva er summen av alle sine aldere? " + sumAvAlder.getIntValue());

		// samme resultat, men ved bruk av streams, som vi skal lære om i en seinere
		// forelesning
		// System.out.println("Hva er summen av alle sine aldere? " +
		// persons.stream().mapToInt(p -> p.getAge()).sum());

		System.out.println();

		// Hva er navnet på den yngste som har et navn med e?
		ValueContainer navn = new ValueContainer();
		persons.forEach(x -> {
			if (x.getName().contains("e") && (navn.getIntValue() == 0 || navn.getIntValue() > x.getAge())) {
				navn.setIntValue(x.getAge());
				navn.setStringValue(x.getName());
			}
		});
		System.out.println("Hva er navnet på den yngste som har et navn med e? " + navn.getStringValue() + " ("
				+ navn.getIntValue() + ")");

		// samme resultat, men ved bruk av streams, som vi skal lære om i en seinere
		// forelesning
//		System.out.println("Hva er navnet på den yngste som har et navn med e? " + persons.stream()
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
