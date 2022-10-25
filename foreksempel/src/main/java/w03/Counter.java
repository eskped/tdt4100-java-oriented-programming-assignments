package w03;

public class Counter {
	int end;
	int counter = 1;

	// Konstruktøren. Vi måtte ha inn hva end skulle være. counter skulle
	// alltid starte på 1.
	public Counter(int end) {
		this.end = end;
	}

	int getCounter() {
		return counter;
	}

	boolean count() {
		return count(1);
	}

	/**
	 * Vi kan jo starte med å lage den akkurat som når en skal gå opp med 1.
	 */
	boolean count(int inc) {
		if (counter >= end)
			return true;
		else {
			counter += inc;
			return counter >= end;
			// Ser dere hva som blir feil her? Kan dere fikse feilene selv?
		}
	}
	/*
	 * For øvrig kan en se på kravene slik de er beskrevet i lysarkene og spørre om
	 * det er helt spesifikt beskrevet. Gitt tilstanden counter = 4, end = 5, og en
	 * kaller count(2). Det er nettopp usikkerheten i beskrivelsen som gjør at det
	 * blir litt vanskelig å lage ting uten at det også kan krasje.
	 */

	public static void main(String[] args) {
		// Eksemplet i lysarkene er ikke helt det samme som her. Hva er forskjellen? Hvilke endringer skal til for at det blir likt?
		System.out.println("## C0");
		Counter c0 = new Counter(3);
		System.out.println(c0.getCounter());
		System.out.println(c0.count());
		System.out.println(c0.count());
		// hvorfor må vi ha et ekstra kall i dette eksemplet?
		System.out.println(c0.count());
		System.out.println();
		
		System.out.println("## C1");
		Counter c1 = new Counter(3);
		System.out.println(c1.getCounter());
		System.out.println(c1.count(3));
		System.out.println(c1.getCounter());
		System.out.println(c1.count(2));
		System.out.println();
		
		// Her kan vi også lage en løkke som gås igjennom helt til vi er ferdige:
//		System.out.println("## C2");
//		Counter c2 = new Counter(8);
//		while (c2.count() == false) {
//			System.out.println(c2.count());
//			System.out.println(c2.getCounter());
//		}
//		System.out.println();

		// Kan dere finne ut hva som er galt her, og fikse det?
//		System.out.println("## C3");
//		Counter c3 = new Counter(8);
//		while (c3.count() == false) {
//			System.out.println(c3.count(3));
//			System.out.println(c3.getCounter());
//		}
	}

}
