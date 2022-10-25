package w04.jokey.v0401;

import java.util.Random;

import w04.jokey.v0401.user.User;

/**
 * Tidligere hadde vi et lite problem ved at vi kunne f� se samme vits flere
 * ganger n�r vi ba om flere tilfeldige vitser. L�sningen for det er � holde
 * styre p� hvilke som har blitt vist. Det gj�r vi ved � introdusere en bruker
 * og litt data om hvilke vitser som har blitt vist.
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
	 * Vi legger til en bruker, som ogs� har litt brukerdata slik at vi kan slippe �
	 * se tilfeldige valgte vitser flere ganger
	 */
	private User user;

	public Jokey() {
		user = new User("henn", "Hen", "Nordmann");
	}

	/**
	 * En enkel metode som skriver ut en vits p� basis av en vits-nummer.
	 * 
	 * @param jokeIndex En indeks som beskriver vitsens plassering i en liste
	 */
	private void printlnJokeAt(int jokeIndex) {
		/*
		 * Tips, ta musepeker over 'getJoke()' metoden og se hva slags informasjon
		 * Eclipse viser deg om metoden. Klikk p� metoden og trykk F3 (i Windows) for �
		 * g� til selve implementasjonen av metoden.
		 */
		Joke joke = jokes.getJokeAt(jokeIndex);
		if (joke != null) {
			System.out.println("[" + jokeIndex + "] \"" + joke.toString() + "\"");
		} else {
			System.out.println("Ingen vits funnet for denne identifikatoren");
		}
	}

	/**
	 * En metode som skriver ut en tilfeldig vits.
	 */
	private void printlnRandomJoke() {
		/*
		 * Tidligere ble det s�nn at vi kunne se den samme vitsen flere ganger. N� tar
		 * vi vare p� litt historikk og kan sjekke om vi har sett den f�r. La oss bruke
		 * den teknikken n�.
		 */
		Random random = new Random();
		// f�rst sjekker vi om vi har sett alle vitsene
		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			System.err.println("Alle vitsene har blitt sett tidligere!!");
		} else {
			// Dette er p� langt n�r en optimal m�te � gj�re dette p�. Hva hvis du har 2
			// millioner vitser men mangler � se en, det kan ta litt tid � finne denne ene.
			// En bedre m�te hadde v�rt � laget en spilleliste med tilfeldig rekkef�lge for
			// siden � g� igjennom denne. For viderekommende, lag en spilleliste med
			// tilfeldig rekkef�lge. Hva er fordeler og ulemper med en slik tiln�rming?
			while (!done) {
				int jokeIndex = random.nextInt(jokes.getJokesCount());
				Joke joke = jokes.getJokeAt(jokeIndex);
				if (user.getUserData().addJokeSeen(joke)) {
					printlnJokeAt(jokeIndex);
					done = true;
				}
			}
		}
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

		// N� kan vi se tilfeldige vitser, men har en metode for ikke � se den samme
		// igjen. La oss sjekke ved � se all vitsene i tilfeldig rekkef�lge pluss en til
		System.out.println("Alle \"vitsene\" i tilfeldig rekkef�lge, + 2 til:");
		for (int i = 0; i < jokey.jokes.getJokesCount() + 2; i++) {
			jokey.printlnRandomJoke();
		}
		
		System.out.println();
		System.out.println("Resetter listen over sette vitser slik at vi kan starte p� nytt");
		jokey.user.getUserData().resetJokesSeen();
		System.out.println("Viser igjen alle \"vitsene\" p� nytt i tilfeldig rekkef�lge, + 2 til:");
		for (int i = 0; i < jokey.jokes.getJokesCount() + 2; i++) {
			jokey.printlnRandomJoke();
		}
	}
}
