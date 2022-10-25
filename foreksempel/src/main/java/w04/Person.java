package w04;

/*
 * En utvidelse av PersonOrig, med to ny konstrukt�rer, ogs� er den gjort fornorsket
 */

public class Person extends PersonOrig {
	public Person() {
		// Hvis ikke noe er nevnt, Ola Nordmann.
		this("Ola Nordmann");
	}

	public Person(String navn) {
		 // Hvis ikke alder er nevnt, 0 �r.
		this(navn, 0);
	}

	/*
	 * Selv om denne konstrukt�ren er lik som super s� m� vi ogs� ha denne her
	 * for at denne konstrukt�ren ogs� skal bli st�ttet 
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
		// bare for � vise den nye enkle konstrukt�ren
		System.out.println(new Person());
		System.out.println();
		
		// her en utvidet utgave
		Person p = new Person("Per", 23);
		System.out.println(p.toString());
		System.out.println(p.toStringSuper());
	}
}
