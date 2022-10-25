package w08.strings;

import java.util.Iterator;

/**
 * Dette er en implementasjon hvor vi har splittet opp iterator-implementasjonen
 * i to klasser, Streng og StrengIterator.
 * 
 * @author steinlt
 *
 */
public class Streng implements Iterable<Character> {
	private String streng;

	public Streng(String streng) {
		this.streng = streng;
	}

	@Override
	public Iterator<Character> iterator() {
		/*
		 * Vi lager en ny streng iterator instanse som selv tar vare på sin tilstand,
		 * dvs posisjon i forhold til iterering.
		 */
		return new StrengIterator(streng);
	}

	@Override
	public String toString() {
		return streng;
	}
	
	public static void main(String[] args) {
		Streng streng = new Streng("Heisann");

		System.out.println(streng);

		System.out.println("-----------");

		for (Iterator<Character> iterator = streng.iterator(); iterator.hasNext();) {
			Character tegn = iterator.next();
			System.out.println(tegn);
		}
	}
}
