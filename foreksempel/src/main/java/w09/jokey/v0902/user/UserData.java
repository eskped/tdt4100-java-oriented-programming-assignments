package w09.jokey.v0902.user;

import java.util.HashSet;

import w09.jokey.v0902.core.IJokeyIdentifier;

/**
 * Her kan vi ta vare på litt data om brukeren, feks historikk over viste
 * vitser.
 * 
 * @author steinlt
 * 
 */
/*
 * Tidligere laget vi en egen spesiell identifikator for å identifisere de ulike
 * vitsene, dette var uheldig da det er Joke-klassen selv som bør kunne ha
 * kontroll på egne identifikatorer. Dette er nå fikset ved help av
 * IJokeyIdentifier interfacet/grensesnittet. Klasser som trenger en
 * identifikator implementerer dette interfacet/grensesnittet, og kan dermed
 * benyttes på en mer forsvarlig måte slik som i denne klassen.
 */
public class UserData extends Object {
	/**
	 * Vi benytter i dette tilfelle et HashSet, den er optimalisert for å holde og
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
	 * Legger til en sett vits og returnerer en indikasjon på om den er sett
	 * tidligere eller ei.
	 * 
	 * @param joke Vitsen som er sett som skal skal legges til
	 * @return {@code true} hvis den har ikke har blitt lagt til før, ellers
	 *         {@code false}
	 */
	public boolean addJokeSeen(IJokeyIdentifier joke) {
		if (joke == null) {
			return false;
		}

		/*
		 * Nå kan vi gjøre det enkelt og bare prøve å legge den til. Add metoden for
		 * HashSet returnere true hvis den kan legges til, men returnerer false hvis den
		 * allerede finnes.
		 */
		return jokesSeen.add(joke.getIdentifierAsString());
	}

	/**
	 * En test for å sjekke om bruker har sett en vits tidligere.
	 * 
	 * @param joke Vitsen som skal sjekkes om har blitt sett
	 * @return {@code true} hvis den har vært sett før, ellers {@code false}
	 */
	/*
	 * Legg merke til at her benytter vi {@code true} i steden for
	 * <code>true</code>. Dette er nesten det samme, men hvor førstnevnte tillater
	 * spesialtegn uten at de må spesialbehandles (en litt nyere og mer praktisk
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
