package w05.jokey.v0501.core;

/**
 * En enkel klasse som inneholder en vits. Selv om den er enkel så er litt av
 * poenget at vi ønsker å kapsle inn vitsen i en egen klasse. Dette gir større
 * fleksibilitet da vi ønsker å kunne ha mer funksjonalitet seinere, men vi vet
 * ennå ikke hva.
 * 
 * @author steinlt
 */
public class Joke implements IJokeyIdentifier {
	private final String jokeyIdentifier;

	/**
	 * Vi har en global variabel av typen streng som inneholder vitsen. Vi setter
	 * den til private slik at den ikke er tilgengelig uten at en benytter getJoke()
	 * metoden.
	 */
	private String joke;

	/**
	 * Her har vi en enkel konstruktør som tar inn en streng. Legg merke til at det
	 * ikke er mulig å endre på vitsen når den først er satt. Dette kan være litt
	 * uheldig hvis feks vitsen har en feil eller noe, mao lite fleksibelt. Men ok
	 * for dette eksemplet. I tillegg må en spesifisere en identifikator
	 * 
	 * @param joke            selve vitsen
	 * @param jokeyIdentifier en identifikator som unikt identifiserer vitsen
	 */
	public Joke(String joke, String jokeyIdentifier) {
		if (jokeyIdentifier == null)
			throw new IllegalArgumentException("identifier kan ikke være null");

		this.jokeyIdentifier = jokeyIdentifier;
		this.joke = joke;
	}

	/**
	 * Dette er en enkel metode som bare henter vitsen som en tekststreng.
	 */
	@Override
	public String toString() {
		return joke;
	}

	@Override
	public IJokeyIdentifier getIdentifier() {
		return this;
	}

	@Override
	public String getIdentifierAsString() {
		return jokeyIdentifier;
	}

	@Override
	public boolean sameIdentifier(IJokeyIdentifier otherIdentifier) {
		return JokeyIdentifierHelper.equals(this, otherIdentifier);
	}
}
