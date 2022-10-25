package w03.jokey.v0301;

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
public class Jokes {
	private ArrayList<Joke> jokes = new ArrayList<Joke>();

	/**
	 * Konstruktør som legger til et sett med vitser ved instansiering.
	 */
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
	 * Her har vi en metode som lar oss hente et objekt med en vits.
	 * 
	 * @param jokeIndex Et tall fra og med 1 og til og med
	 *                  <code>getJokesCount()</code>
	 * @return Hvis identifikatoren finnes så returneres et vitse-objekt, hvis ikke
	 *         returneres <code>null</code>
	 */
	public Joke getJokeAt(int jokeIndex) {
		if (jokeIndex >= 0 && jokeIndex < getJokesCount()) {
			return jokes.get(jokeIndex);
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
		/*
		 * Her returenere vi rette og slette antallet vitser som er tilgjengelig, dette
		 * kan vi nå enkelt gjøre ved å spørre vår tabell om sin størrelse.
		 */
		return jokes.size();
	}
}
