package w04.jokey.v0402;

import java.util.ArrayList;

/**
 * Her viser vi noen av de største fordelene med innkapsling ved at vi endrer på
 * hvordan vitsene er representert i Jokes-klassen. Disse endringene får INGEN
 * betydning for de andre involverte klassene. Det er ellers noen mindre
 * endringer i Joke klassen også og noen nye kommenterer, men disse endringene
 * har heller INGEN betydning for andre involverte klasser.
 * 
 * @author steinlt
 *
 */
/*
 * Denne metoden er litt uheldig, at vi skal vite litt av den indre strukturen
 * til en klasse. Dette må da kunne gjøres på en bedre måte, eller? Noe vi kan
 * se på neste gang.
 */
public class Jokes {
	/**
	 * PlanUML tips!
	 * <p>
	 * Hvis du bruker PlantUML, vil du fort legge merke til at den ikke er så flink
	 * til å legge til relasjoner mellom klasser hvis en benytter noen classer fra
	 * collection standardbiblioteket. Men det er en måte å lure frem relasjonen
	 * slik at den vises i diagrammet. Det kan gjøres ved å lage en tilsvarende
	 * array med samme navn (feks private Joke[] jokes = new Joke[];). Begge lister
	 * må vises samtidig, dvs ikke kommentert ut. Hvis en da markere alle relaterte
	 * klasser i Project Explorer vil en se at relasjoner vises som forventet.
	 */
	//private Joke[] jokes = new Joke[];

	private ArrayList<Joke> jokes = new ArrayList<Joke>();

	public Jokes() {
		jokes.add(new Joke("Katta med slips!"));
		jokes.add(new Joke(
				"Hund med slips! Dette er nok en helt elendig vits, men hva gjør en vits til en vits egentlig?"));
		jokes.add(new Joke("Nå begynner dette å bli pinlig egentlig, for dette er ikke noen vits..."));
		jokes.add(new Joke("Hva er vitsen? Ha, den var jo egentlig ikke så dum og litt dobbel? Men er det en vits?"));
		jokes.add(new Joke("Flere som gleder seg til vi skal bytte til en annen kilde for vitser?"));
		jokes.add(new Joke("Dette begynner egentlig å minne om pappavitser? Tomme for innhold og uten mening..."));
		jokes.add(new Joke("Kanskje dette bare er en pappavits-generator? Uff da..."));
		jokes.add(new Joke("Slapp av, redningen kommer i rundt uke 6(?)"));
	}

	/**
	 * Hentee et objekt med en vits.
	 * 
	 * @param jokeIndex Et tall fra og med 1 og til og med
	 *                  <code>getJokesCount()</code>
	 * @return Hvis identifikatoren finnes så returneres et vitse-objekt
	 * @throws IndexOutOfBoundsException (fra List sin JavaDoc) if the index is out
	 *                                   of range
	 *                                   ({@code index < 0 || index >= size()})
	 */
	public Joke getJokeAt(int jokeIndex) {
		/*
		 * Nå har vi endret denne til ikke å gjøre noen sjekk på forhånd, dermed kan
		 * jokeIndex vare utenfor område for indekser for jokes-listen, det vil da
		 * kastes en IndexOutOfBoundsException som det forventes at den som kaller denne
		 * metoden eventuelt fanger for videre behandling.
		 */
		return jokes.get(jokeIndex);
	}

	/**
	 * En metode som gir oss antallet vitser tilgjengelig.
	 * 
	 * @return Antallet vitser tilgjengelig
	 */
	public int getJokesCount() {
		// Her returenere vi rette og slette antallet vitser som er tilgjengelig.
		return jokes.size();
	}
}
