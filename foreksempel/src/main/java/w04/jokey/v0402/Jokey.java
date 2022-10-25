package w04.jokey.v0402;

import java.util.Random;

import w04.jokey.v0402.user.User;

/**
 * I tidligere har vi returnert stort sett true/false for � indikere feil. For
 * konstrukt�rer er dette en d�rlig strategi. I denne utgaven forbedrer vi koden
 * ved � innf�rer vi throw/catch av Exceptions.
 * <p>
 * Vi har gjort endring i Jokes.main(...), Jokes.printlnJokeAt(...) og
 * Joke.getJokeAt(...). Er det flere plasser det burde v�rt gjort forbedringer?
 * Hva tenker du? Forslag til forbedringer kommer i neste utgave.
 * 
 * @author steinlt
 */
/*
 * Her er det lagt inn en feil med hint om l�sninger. Pr�v � finn feilen(e) ved
 * � benytte debuggeren og forbedre systemet slik at slik feil kan fanges opp p�
 * en bedre m�te.
 */

public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gj�r egentlig? Hint, se p�
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	private final String TITLE = "Jokey - hva er vitsen?";

	/**
	 * Her lager lager vi en instans av Jokes klassen. Vi f�r en objektreferanse som
	 * vi tar vare p� i den globale variabelen 'jokes'. Denne kan vi s� benytte for
	 * � hente vitser.
	 */
	private Jokes jokes = new Jokes();

	/**
	 * Vi legger til en bruker, som ogs� har litt brukerdata slik at vi kan slippe �
	 * se tilfeldige valgte vitser flere ganger.
	 */
	private User user;

	public Jokey() {
		/*
		 * Her ser vi et eksempel p� en exception som har blitt "skjult" fordi vi har
		 * fanget den naivt opp i main. Enhver exception b�r fanges opp s� n�re kilde av
		 * en potensiell feil som mulig for best mulig h�ndtering.
		 */
		/*
		 * I l�sningsforslaget under legger vi alts� til en bruker og hvis det feiler s�
		 * fanger vi bare dette og skriver ut en feilmelding. Er det godt nok? Vil det
		 * medf�re f�lgefeil? I dette tilfellet ja, men hva gj�r man da? Pr�v � endre
		 * "henn" til "he" (husk at det var satt et krav om at brukernavnet skulle v�re
		 * minst 3 tegn langt) og se hva som skjer. Hadde det v�rt bedre � la feilen g�
		 * og heller fange den opp en annen plass, slik som i main? Det kommer an p�
		 * applikasjonen, en l�sning kan feks v�re en defaultbruker med begrenset
		 * funksjonalitet (slik som ikke lagring ol).
		 */
		/*
		 * Merk at vi har kommentert ut try-catch blokken med vilje for � "skjule"
		 * feilen. Hvilke l�sninger tenker du
		 */
		// try {
			user = new User("he", "Hen", "Nordmann"); // brukernavn "henn"
//		} catch (Exception e) {
//			System.err.println(e);
//		}
	}

	/**
	 * Skriver ut en vits p� basis av et vits-nummer.
	 * 
	 * @param jokeIndex En indeks som beskriver vitsens plassering i en liste
	 */
	/*
	 * Er dette god innkapsling? At vi m� vite litt av den indre strukturen til
	 * Jokes? Den er OK, men ikke ideell, vi skal se p� en annen l�sning etter
	 * hvert.
	 */
	private void printlnJokeAt(int jokeIndex) {
		/*
		 * Tips, ta musepeker over 'getJoke()' metoden og se hva slags informasjon
		 * Eclipse viser deg om metoden. Klikk p� metoden og trykk F3 (i Windows) for �
		 * g� til selve implementasjonen av metoden. Legg merke til at vi har lagt til
		 * informasjon om at den n� kan kaste en exception. Vi m� derfor endre koden
		 * under slik at den tar hensyn til denne endringen.
		 */
		try {
			Joke joke = jokes.getJokeAt(jokeIndex);
			System.out.println("[" + jokeIndex + "] \"" + joke.toString() + "\"");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Ingen vits funnet for denne identifikatoren");
		}
	}

	/**
	 * Skriver ut en tilfeldig vits.
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
			/*
			 * Dette er p� langt n�r en optimal m�te � gj�re dette p�. Hva hvis du har 2
			 * millioner vitser men mangler � se en, det kan ta litt tid � finne denne ene.
			 * En bedre m�te hadde v�rt � laget en spilleliste med tilfeldig rekkef�lge for
			 * siden � g� igjennom denne. For viderekommende, lag en spilleliste med
			 * tilfeldig rekkef�lge. Hva er fordeler og ulemper med en slik tiln�rming?
			 * Hint, hva hvis du bruker en API p� nett hvor du ikke har tilgang til alle
			 * vitsene p� en gang?
			 */
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
	 * Skrive ut alle tilgjengelige vitser.
	 */
	private void printlnAllJokes() {
		for (int jokeIndex = 0; jokeIndex < jokes.getJokesCount(); jokeIndex++) {
			printlnJokeAt(jokeIndex);
		}
	}

	public void runApplication() {
		System.out.println(TITLE.toUpperCase());
		System.out.println("Versjon: " + VERSION);
		System.out.println();

		System.out.println(
				"Test av ny metode som fanger en exception hvis etterspurt vits er utenfor rangen av listen med vitser");
		printlnJokeAt(100);
		System.out.println();

		System.out.println("Alle \"vitsene\" i tilfeldig rekkef�lge, + 2 til:");
		for (int i = 0; i < jokes.getJokesCount() + 2; i++) {
			printlnRandomJoke();
		}
	}

	public static void main(String[] args) {
		/*
		 * Vi legger til en try catch her for � fange opp eventuelle fatale feil og
		 * pr�ver � gj�re noe med det som � starte programmet p� nytt. Merk at try-catch
		 * alltid b�r v�re s� n�re der det kan bli kastet en exception som mulig for at
		 * det generelt sett skal kunne bli h�ndtert riktig av den som initierte kallet
		 * som medf�rte feilen.
		 */
		try {
			Jokey jokey = new Jokey();
			jokey.runApplication();
		} catch (Exception e) {
			System.err.println("Det oppstod en fatal feil! Pr�ver � starte programmet p� nytt.");
			try {
				Jokey jokey = new Jokey();
				jokey.runApplication();
			} catch (Exception e2) {
				System.err.println("Det oppstod enn� en fatal feil! Avslutter programmet.");
				// siden den oppstod igjen b�r vi om ikke annet gi litt mer info om hva som kan
				// v�re feilen, eller?
				// e2.printStackTrace();
			}
		} finally {
			/*
			 * TIPS! Legg til en finally hvis du har behov for � "rydde opp" etter at en
			 * kode er kj�rt. Merk at finally kj�res uavhengig av om det opst�r en Exception
			 * eller ei.
			 */
		}
	}
}
