package w02.jokey.v0202;

/**
 * I tillegge til å flytte alle vitsene over i egen Jokes-klasse har vi
 * opprettet en egen klasse, Joke, for selve vitsene også. Den instansieres ved
 * å sette vitsen i det den blir opprettet, slik som
 * <code>private Joke joke1 = new Joke("Katta med slips!");</code>
 * 
 * @author steinlt
 */
/*
 * Hvis du lurer på bruken av taggen <code>. Se hva som skjer når Eclipse viser
 * deg klassebeskrivelsen når du holde musepeker over klassenavnet 'Jokes'
 * under.
 * 
 * Legg også merke til at det brukes /** vs /*. /** lar oss skrive beskrivelser
 * i JavaDoc som kan benyttes for å generere kodedokumentasjon men som også
 * gjenkjennes av Eclipse slik at du kan se når du tar musepekeren over en
 * klasse, metode, osv. /* lar oss skrive beskrivelser som ikke blir vist som en
 * del av JavaDoc. /* Benyttes for en blokk av kommentarer, mens // er brukt for
 * en kort kommentar. 
 */
public class Jokes {
	private Joke joke0 = new Joke("Katta med slips!");
	private Joke joke1 = new Joke(
			"Hund med slips! Dette er nok en helt elendig vits, men hva gjør en vits til en vits egentlig?");
	private Joke joke2 = new Joke("Nå begynner dette å bli pinlig egentlig, for dette er ikke noen vits...");
	private Joke joke3 = new Joke(
			"Hva er vitsen? Ha, den var jo egentlig ikke så dum og litt dobbel? Men er det en vits?");
	private Joke joke4 = new Joke("Flere som gleder seg til vi skal bytte til en annen kilde for vitser?");
	private Joke joke5 = new Joke(
			"Dette begynner egentlig å minne om pappavitser? Tomme for innhold og uten mening...");
	private Joke joke6 = new Joke("Kanskje dette bare er en pappavits-generator? Uff da...");
	private Joke joke7 = new Joke("Slapp av, redningen kommer i rundt uke 6(?)");

	/**
	 * Her har vi en metode som lar oss hente et objekt med en vits.
	 * 
	 * @param jokeIndex Et tall fra og med 0 og til <code>getJokesCount()</code>
	 * @return Hvis identifikatoren finnes så returneres et vitse-objekt, hvis ikke returneres <code>null</code>
	 */
	public Joke getJokeAt(int jokeIndex) {
		if (jokeIndex == 0) {
			return joke0;
		} else if (jokeIndex == 1) {
			return joke1;
		} else if (jokeIndex == 2) {
			return joke2;
		} else if (jokeIndex == 3) {
			return joke3;
		} else if (jokeIndex == 4) {
			return joke4;
		} else if (jokeIndex == 5) {
			return joke5;
		} else if (jokeIndex == 6) {
			return joke6;
		} else if (jokeIndex == 7) {
			return joke7;
		} else {
			// returnerer 'null' som betyr et objekt som ikke er satt til noe hvis det ikke
			// er noen treff
			return null;
		}
	}

	/**
	 * En metode som gir oss antallet vitser tilgjengelig.
	 * 
	 * @return Antallet vitser tilgjengelig
	 */
	public int getJokesCount() {
		// Her returenere vi rette og slette antallet vitser som er tilgjengelig.
		return 8;
	}
}
