package w02.jokey.v0202;

import java.util.Random;

/**
 * N� har vi ryddet litt og gjort det litt mer objektorientert ved at vi har
 * flyttet vitsene over til en egen klasse. Denne Jokes klassen har ansvaret for
 * vitsene heretter. 
 * 
 * @author steinlt
 */
public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gj�r egentlig? Hint, se p�
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	/**
	 * Tittelen vil praksis ikke bli endret p� underveis, vi �nsker derfor at den
	 * kan v�re en konstant istedenfor � v�re en variabel. Dette gj�r vi ved � sette
	 * n�kkelordet 'final' foran typen. Vi endrer samtidig til Java-notasjon for
	 * konstanter ved � bare benytte store bokstaver for navnet av konstanten.
	 */
	private final String TITLE = "Jokey - hva er vitsen?";

	/**
	 * Her lager lager vi en instans av Jokes klassen. Vi f�r en objektreferanse som
	 * vi tar vare p� i den globale variabelen 'jokes'. Denne kan vi s� benytte for
	 * � hente vitser.
	 */
	private Jokes jokes = new Jokes();

	/**
	 * En enkel metode som skriver ut en vits p� basis av en vits-nummer.
	 */
	private void printlnJokeAt(int jokeIndex) {
		/*
		 * Tips, ta musepeker over 'getJoke()' metoden og se hva slags informasjon
		 * Eclipse viser deg om metoden. Klikk p� metoden og trykk F3 (i Windows) for �
		 * g� til selve implementasjonen av metoden.
		 */
		Joke joke = jokes.getJokeAt(jokeIndex);
		if (joke != null) {
			System.out.println("\"" + joke.toString() + "\"");
		} else {
			System.err.println("Ingen vits funnet for denne identifikatoren");
		}
	}

	/**
	 * En metode som skriver ut en tilfeldig vits.
	 */
	private void printlnRandomJoke() {
		Random random = new Random();
		/*
		 * Med nextInt(jokes.getJokesCount()) henter vi et tilfeldig tall i spennet
		 * [0..7].
		 */
		int jokeIndex = random.nextInt(jokes.getJokesCount());

		// siden vi allerede har laget en metode for � skrive ut em vits benytter vi
		// denne.
		printlnJokeAt(jokeIndex);
	}

	/**
	 * En metode som lar oss skrive ut alle vitsene.
	 */
	private void printlnAllJokes() {
		for (int jokeIndex = 0; jokeIndex < jokes.getJokesCount(); jokeIndex++) {
			// siden vi allerede har laget en metode for � skrive ut em vits benytter vi
			// denne.
			printlnJokeAt(jokeIndex);
		}
	}

	public static void main(String[] args) {
		Jokey jokey = new Jokey();

		// Litt tittel og versjonsinformasjon
		System.out.println(jokey.TITLE.toUpperCase());
		System.out.println("Versjon: " + jokey.VERSION);
		System.out.println();

		// noen vitser
		// for � vise " i en tekststreng m� vi escape den f�rst, dette gj�res
		// ved � sette \ foran
		System.out.println("Noen valgte \"vitser\":");
		jokey.printlnJokeAt(0);
		jokey.printlnJokeAt(1);
		// hva skjer om vi ber om en vits som kanskje ikke finnes?
		jokey.printlnJokeAt(100000);

		// n� har viu bedt om noen vitser ved � oppgi et spesifikt vitsenummer. Hva om
		// vi kan be om en tilfeldig vits?
		// Legg merke til at her kan noen av vitsene bli vist flere ganger, spesielt
		// siden vi har s� f� forel�pig. Men dette er noe vi skal se l�sninger seinere?
		// Men i mellomtiden, hva tror du kan v�re en l�sning?
		System.out.println();
		System.out.println("Noen tilfeldige \"vitser\":");
		jokey.printlnRandomJoke();
		jokey.printlnRandomJoke();
		jokey.printlnRandomJoke();

		// hva med � skrive ut alle vitsene?
		System.out.println();
		System.out.println("Alle \"vitsene\":");
		jokey.printlnAllJokes();
	}
}
