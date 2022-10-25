package w03.jokey.v0301;

/**
 * En enkel klasse som inneholder en vits. Selv om den er enkel s� er litt av
 * poenget at vi �nsker � kapsle inn vitsen i en egen klasse. Dette gir st�rre
 * fleksibilitet da vi �nsker � kunne ha mer funksjonalitet seinere, men vi vet
 * enn� ikke hva.
 * 
 * @author steinlt
 */
public class Joke extends Object {
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
	 * 
	 * @param joke vitsen for dette objektet
	 */
	public Joke(String joke) {
		this.joke = joke;
	}

	/**
	 * Dette er en enkel metode som bare henter vitsen som en tekststreng.
	 */
	/*
	 * N� har vi lagt til @Override da 'public String toString()' er en metode som
	 * finnes i ALLE klasser da ALLE klasser er en underklasse av Object som er
	 * rotklassen i Java. Dette har blitt synligjort i denne klassen ved at vi har
	 * lagt til 'extends Object' for denne klassen. Men, 'extends Object' er
	 * egentlig un�dvendig, og derfor stort sett alltid utelatt da alts� Object er
	 * rotklassen for alle klasser.
	 */
	@Override
	public String toString() {
		return joke;
	}
}
