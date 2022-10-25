package w02.jokey.v0202;

/**
 * En enkel klasse som inneholder en vits. Selv om den er enkel så er litt av
 * poenget at vi ønsker å kapsle inn vitsen i en egen klasse. Dette gir større
 * fleksibilitet da vi ønsker å kunne ha mer funksjonalitet seinere, men vi vet
 * ennå ikke hva. 
 * 
 * @author steinlt
 */
public class Joke {
	/**
	 * Vi har en global variabel av typen streng som inneholder vitsen. Vi setter
	 * den til private slik at den ikke er tilgengelig uten at en benytter getJoke()
	 * metoden.
	 */
	private String joke;

	/**
	 * Her har vi en enkel konstruktør som tar inn en streng. Legg merke til at det
	 * ikke er mulig å endre på vitsen når den først er satt. Dette kan være litt
	 * uheldig hvis feks vitsen har en feil eller noe, mao lite fleksibelt.
	 */
	public Joke(String joke) {
		this.joke = joke;
	}

	/**
	 * Dette er en enkel metode som bare henter vitsen som en tekststreng.
	 */
	public String toString() {
		return joke;
	}
}
