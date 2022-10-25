package w04;

/*
 * En utvidelse av PersonOrig, med to ny konstruktører, også er den gjort fornorsket
 */

public class Person extends PersonOrig {
	public Person() {
		// Hvis ikke noe er nevnt, Ola Nordmann.
		this("Ola Nordmann");
	}

	public Person(String navn) {
		 // Hvis ikke alder er nevnt, 0 år.
		this(navn, 0);
	}

	/*
	 * Selv om denne konstruktøren er lik som super så må vi også ha denne her
	 * for at denne konstruktøren også skal bli støttet 
	 */
	public Person(String navn, int alder) {
		super(navn, alder);
	}
	
	@Override
	public String toString() {
		return "Person [navn=" + getName() + ", alder=" + getAge() + "]";
	}
	
	public String toStringSuper() {
		return super.toString();
	}

	public static void main(String[] args) {
		// bare for å vise den nye enkle konstruktøren
		System.out.println(new Person());
		System.out.println();
		
		// her en utvidet utgave
		Person p = new Person("Per", 23);
		System.out.println(p.toString());
		System.out.println(p.toStringSuper());
	}
}
