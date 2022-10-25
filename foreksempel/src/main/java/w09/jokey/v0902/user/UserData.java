package w09.jokey.v0902.user;

import java.util.HashSet;

import w09.jokey.v0902.core.IJokeyIdentifier;

/**
 * Her kan vi ta vare p� litt data om brukeren, feks historikk over viste
 * vitser.
 * 
 * @author steinlt
 * 
 */
/*
 * Tidligere laget vi en egen spesiell identifikator for � identifisere de ulike
 * vitsene, dette var uheldig da det er Joke-klassen selv som b�r kunne ha
 * kontroll p� egne identifikatorer. Dette er n� fikset ved help av
 * IJokeyIdentifier interfacet/grensesnittet. Klasser som trenger en
 * identifikator implementerer dette interfacet/grensesnittet, og kan dermed
 * benyttes p� en mer forsvarlig m�te slik som i denne klassen.
 */
public class UserData extends Object {
	/**
	 * Vi benytter i dette tilfelle et HashSet, den er optimalisert for � holde og
	 * finne unike verdier i motsetning til en ArrayList som kan ha flere like
	 * verdier.
	 */
	private HashSet<String> jokesSeen;

	/**
	 * Oppretter et opjekt for brukerdata slik som vitser sett.
	 */
	public UserData() {
		jokesSeen = new HashSet<String>();
	}

	/**
	 * Legger til en sett vits og returnerer en indikasjon p� om den er sett
	 * tidligere eller ei.
	 * 
	 * @param joke Vitsen som er sett som skal skal legges til
	 * @return {@code true} hvis den har ikke har blitt lagt til f�r, ellers
	 *         {@code false}
	 */
	public boolean addJokeSeen(IJokeyIdentifier joke) {
		if (joke == null) {
			return false;
		}

		/*
		 * N� kan vi gj�re det enkelt og bare pr�ve � legge den til. Add metoden for
		 * HashSet returnere true hvis den kan legges til, men returnerer false hvis den
		 * allerede finnes.
		 */
		return jokesSeen.add(joke.getIdentifierAsString());
	}

	/**
	 * En test for � sjekke om bruker har sett en vits tidligere.
	 * 
	 * @param joke Vitsen som skal sjekkes om har blitt sett
	 * @return {@code true} hvis den har v�rt sett f�r, ellers {@code false}
	 */
	/*
	 * Legg merke til at her benytter vi {@code true} i steden for
	 * <code>true</code>. Dette er nesten det samme, men hvor f�rstnevnte tillater
	 * spesialtegn uten at de m� spesialbehandles (en litt nyere og mer praktisk
	 * notasjon).
	 */
	public boolean seenJoke(IJokeyIdentifier joke) {
		if (joke == null) {
			return false;
		}

		return jokesSeen.contains(joke.getIdentifierAsString());
	}

	/**
	 * Resetter listen over vitser som har blitt sett.
	 */
	public void resetJokesSeen() {
		jokesSeen.clear();
	}

	/**
	 * Henter antallet unike vitser som er sett siden forrige reset av listen, dvs
	 * denne tar ikke hensyn til at samme vits kan ha blitt sett en eller flere
	 * ganger.
	 * 
	 * @return Antall unike vitser som er sett siden forrige reset av listen.
	 */
	public int getUniqueJokesSeenCount() {
		return jokesSeen.size();
	}
}
