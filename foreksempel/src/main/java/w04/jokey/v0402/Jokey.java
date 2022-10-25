package w04.jokey.v0402;

import java.util.Random;

import w04.jokey.v0402.user.User;

/**
 * I tidligere har vi returnert stort sett true/false for å indikere feil. For
 * konstruktører er dette en dårlig strategi. I denne utgaven forbedrer vi koden
 * ved å innfører vi throw/catch av Exceptions.
 * <p>
 * Vi har gjort endring i Jokes.main(...), Jokes.printlnJokeAt(...) og
 * Joke.getJokeAt(...). Er det flere plasser det burde vært gjort forbedringer?
 * Hva tenker du? Forslag til forbedringer kommer i neste utgave.
 * 
 * @author steinlt
 */
/*
 * Her er det lagt inn en feil med hint om løsninger. Prøv å finn feilen(e) ved
 * å benytte debuggeren og forbedre systemet slik at slik feil kan fanges opp på
 * en bedre måte.
 */

public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gjør egentlig? Hint, se på
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	private final String TITLE = "Jokey - hva er vitsen?";

	/**
	 * Her lager lager vi en instans av Jokes klassen. Vi får en objektreferanse som
	 * vi tar vare på i den globale variabelen 'jokes'. Denne kan vi så benytte for
	 * å hente vitser.
	 */
	private Jokes jokes = new Jokes();

	/**
	 * Vi legger til en bruker, som også har litt brukerdata slik at vi kan slippe å
	 * se tilfeldige valgte vitser flere ganger.
	 */
	private User user;

	public Jokey() {
		/*
		 * Her ser vi et eksempel på en exception som har blitt "skjult" fordi vi har
		 * fanget den naivt opp i main. Enhver exception bør fanges opp så nære kilde av
		 * en potensiell feil som mulig for best mulig håndtering.
		 */
		/*
		 * I løsningsforslaget under legger vi altså til en bruker og hvis det feiler så
		 * fanger vi bare dette og skriver ut en feilmelding. Er det godt nok? Vil det
		 * medføre følgefeil? I dette tilfellet ja, men hva gjør man da? Prøv å endre
		 * "henn" til "he" (husk at det var satt et krav om at brukernavnet skulle være
		 * minst 3 tegn langt) og se hva som skjer. Hadde det vært bedre å la feilen gå
		 * og heller fange den opp en annen plass, slik som i main? Det kommer an på
		 * applikasjonen, en løsning kan feks være en defaultbruker med begrenset
		 * funksjonalitet (slik som ikke lagring ol).
		 */
		/*
		 * Merk at vi har kommentert ut try-catch blokken med vilje for å "skjule"
		 * feilen. Hvilke løsninger tenker du
		 */
		// try {
			user = new User("he", "Hen", "Nordmann"); // brukernavn "henn"
//		} catch (Exception e) {
//			System.err.println(e);
//		}
	}

	/**
	 * Skriver ut en vits på basis av et vits-nummer.
	 * 
	 * @param jokeIndex En indeks som beskriver vitsens plassering i en liste
	 */
	/*
	 * Er dette god innkapsling? At vi må vite litt av den indre strukturen til
	 * Jokes? Den er OK, men ikke ideell, vi skal se på en annen løsning etter
	 * hvert.
	 */
	private void printlnJokeAt(int jokeIndex) {
		/*
		 * Tips, ta musepeker over 'getJoke()' metoden og se hva slags informasjon
		 * Eclipse viser deg om metoden. Klikk på metoden og trykk F3 (i Windows) for å
		 * gå til selve implementasjonen av metoden. Legg merke til at vi har lagt til
		 * informasjon om at den nå kan kaste en exception. Vi må derfor endre koden
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
			/*
			 * Dette er på langt nær en optimal måte å gjøre dette på. Hva hvis du har 2
			 * millioner vitser men mangler å se en, det kan ta litt tid å finne denne ene.
			 * En bedre måte hadde vært å laget en spilleliste med tilfeldig rekkefølge for
			 * siden å gå igjennom denne. For viderekommende, lag en spilleliste med
			 * tilfeldig rekkefølge. Hva er fordeler og ulemper med en slik tilnærming?
			 * Hint, hva hvis du bruker en API på nett hvor du ikke har tilgang til alle
			 * vitsene på en gang?
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

		System.out.println("Alle \"vitsene\" i tilfeldig rekkefølge, + 2 til:");
		for (int i = 0; i < jokes.getJokesCount() + 2; i++) {
			printlnRandomJoke();
		}
	}

	public static void main(String[] args) {
		/*
		 * Vi legger til en try catch her for å fange opp eventuelle fatale feil og
		 * prøver å gjøre noe med det som å starte programmet på nytt. Merk at try-catch
		 * alltid bør være så nære der det kan bli kastet en exception som mulig for at
		 * det generelt sett skal kunne bli håndtert riktig av den som initierte kallet
		 * som medførte feilen.
		 */
		try {
			Jokey jokey = new Jokey();
			jokey.runApplication();
		} catch (Exception e) {
			System.err.println("Det oppstod en fatal feil! Prøver å starte programmet på nytt.");
			try {
				Jokey jokey = new Jokey();
				jokey.runApplication();
			} catch (Exception e2) {
				System.err.println("Det oppstod ennå en fatal feil! Avslutter programmet.");
				// siden den oppstod igjen bør vi om ikke annet gi litt mer info om hva som kan
				// være feilen, eller?
				// e2.printStackTrace();
			}
		} finally {
			/*
			 * TIPS! Legg til en finally hvis du har behov for å "rydde opp" etter at en
			 * kode er kjørt. Merk at finally kjøres uavhengig av om det opstår en Exception
			 * eller ei.
			 */
		}
	}
}
