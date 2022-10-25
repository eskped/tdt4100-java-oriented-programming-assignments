package w02.jokey.v0202;

/**
 * En enkel klasse som inneholder en vits. Selv om den er enkel s� er litt av
 * poenget at vi �nsker � kapsle inn vitsen i en egen klasse. Dette gir st�rre
 * fleksibilitet da vi �nsker � kunne ha mer funksjonalitet seinere, men vi vet
 * enn� ikke hva. 
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
	 * Her har vi en enkel konstrukt�r som tar inn en streng. Legg merke til at det
	 * ikke er mulig � endre p� vitsen n�r den f�rst er satt. Dette kan v�re litt
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
