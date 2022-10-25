package w04.jokey.v0401;

import java.util.Random;

import w04.jokey.v0401.user.User;

/**
 * Tidligere hadde vi et lite problem ved at vi kunne få se samme vits flere
 * ganger når vi ba om flere tilfeldige vitser. Løsningen for det er å holde
 * styre på hvilke som har blitt vist. Det gjør vi ved å introdusere en bruker
 * og litt data om hvilke vitser som har blitt vist.
 * 
 * @author steinlt
 */
public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gjør egentlig? Hint, se på
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	/**
	 * Tittelen vil praksis ikke bli endret på underveis, vi ønsker derfor at den
	 * kan være en konstant istedenfor å være en variabel. Dette gjør vi ved å sette
	 * nøkkelordet 'final' foran typen. Vi endrer samtidig til Java-notasjon for
	 * konstanter ved å bare benytte store bokstaver for navnet av konstanten.
	 */
	private final String TITLE = "Jokey - hva er vitsen?";

	/**
	 * Her lager lager vi en instans av Jokes klassen. Vi får en objektreferanse som
	 * vi tar vare på i den globale variabelen 'jokes'. Denne kan vi så benytte for
	 * å hente vitser.
	 */
	private Jokes jokes = new Jokes();

	/**
	 * Vi legger til en bruker, som også har litt brukerdata slik at vi kan slippe å
	 * se tilfeldige valgte vitser flere ganger
	 */
	private User user;

	public Jokey() {
		user = new User("henn", "Hen", "Nordmann");
	}

	/**
	 * En enkel metode som skriver ut en vits på basis av en vits-nummer.
	 * 
	 * @param jokeIndex En indeks som beskriver vitsens plassering i en liste
	 */
	private void printlnJokeAt(int jokeIndex) {
		/*
		 * Tips, ta musepeker over 'getJoke()' metoden og se hva slags informasjon
		 * Eclipse viser deg om metoden. Klikk på metoden og trykk F3 (i Windows) for å
		 * gå til selve implementasjonen av metoden.
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
		 * Tidligere ble det sånn at vi kunne se den samme vitsen flere ganger. Nå tar
		 * vi vare på litt historikk og kan sjekke om vi har sett den før. La oss bruke
		 * den teknikken nå.
		 */
		Random random = new Random();
		// først sjekker vi om vi har sett alle vitsene
		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			System.err.println("Alle vitsene har blitt sett tidligere!!");
		} else {
			// Dette er på langt nær en optimal måte å gjøre dette på. Hva hvis du har 2
			// millioner vitser men mangler å se en, det kan ta litt tid å finne denne ene.
			// En bedre måte hadde vært å laget en spilleliste med tilfeldig rekkefølge for
			// siden å gå igjennom denne. For viderekommende, lag en spilleliste med
			// tilfeldig rekkefølge. Hva er fordeler og ulemper med en slik tilnærming?
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
			// siden vi allerede har laget en metode for å skrive ut em vits benytter vi
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

		// Nå kan vi se tilfeldige vitser, men har en metode for ikke å se den samme
		// igjen. La oss sjekke ved å se all vitsene i tilfeldig rekkefølge pluss en til
		System.out.println("Alle \"vitsene\" i tilfeldig rekkefølge, + 2 til:");
		for (int i = 0; i < jokey.jokes.getJokesCount() + 2; i++) {
			jokey.printlnRandomJoke();
		}
		
		System.out.println();
		System.out.println("Resetter listen over sette vitser slik at vi kan starte på nytt");
		jokey.user.getUserData().resetJokesSeen();
		System.out.println("Viser igjen alle \"vitsene\" på nytt i tilfeldig rekkefølge, + 2 til:");
		for (int i = 0; i < jokey.jokes.getJokesCount() + 2; i++) {
			jokey.printlnRandomJoke();
		}
	}
}
