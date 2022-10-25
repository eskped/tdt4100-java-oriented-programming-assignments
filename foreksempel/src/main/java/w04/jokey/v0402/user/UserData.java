package w04.jokey.v0402.user;

import java.util.HashSet;

import w04.jokey.v0402.Joke;

/**
 * Her kan vi ta vare p� litt data om brukeren, feks histroikk over viste
 * vitser. Implementasjonen er enkel og vi finner og lager en identifikator for
 * et Joke objekt i denne koden. Dette er ikke optimalt og burde v�rt overlatt
 * til Joke klassen � bestemme en god identifikator. Vi har et behov for en
 * identifikator, kanskje vi kan benytte grensesnitt/Interface for dette? Vi sal
 * se p� en bedre impementasjon i neste uke.
 * 
 * @author steinlt
 */
public class UserData {
	/**
	 * Vi benytter i dette tilfelle et HashSet, den er optimalisert for � holde og
	 * finne unike verdier i motsetning til en ArrayList som kan ha flere like
	 * verdier.
	 */
	private HashSet<Integer> jokesSeen;

	public UserData() {
		jokesSeen = new HashSet<Integer>();
	}

	/**
	 * Legger til en sett vits og returnerer en indikasjon p� om den er sett tidligere eller ei.
	 * 
	 * @param joke Vitsen som er sett som skal skal legges til
	 * @return {@code true} hvis den har ikke har blitt lagt til f�r, ellers
	 *         {@code false}
	 */
	public boolean addJokeSeen(Joke joke) {
		if (joke == null) {
			return false;
		}

		/*
		 * HashCode genererer i mange tilfeller en "unik" kode for et objekt, men det er
		 * ingen garanti for at det stemmer. Vi kan forbedre denne noe, men det er for
		 * viderekommende. Men for samme objekt i samme kj�rende sesjon er det en
		 * garanti for at koden skal v�re lik.
		 */
		Integer jokeHash = joke.hashCode();

		/*
		 * N� kan vi gj�re det enkelt og bare pr�ve � legge den til. Add metoden for
		 * HashSet returnere true hvis den kan legges til, men returnerer false hvis den
		 * allerede finnes.
		 */
		return jokesSeen.add(jokeHash);
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
	public boolean seenJoke(Joke joke) {
		if (joke == null) {
			return false;
		}

		/*
		 * HashCode genererer i mange tilfeller en "unik" kode for et objekt, men det er
		 * ingen garanti for at det stemmer. Vi kan forbedre denne noe, men det er for
		 * viderekommende. Men for samme objekt i samme kj�rende sesjon er det en
		 * garanti for at koden skal v�re lik.
		 */
		Integer jokeHash = joke.hashCode();
		return jokesSeen.contains(jokeHash);
	}

	/**
	 * Resetter listen over vitser som har blitt sett.
	 */
	public void resetJokesSeen() {
		jokesSeen.clear();
	}

	/**
	 * Gir et antall p� unike vitser som er sett.
	 * 
	 * @return Antall unike vitser sett.
	 */
	public int getUniqueJokesSeenCount() {
		return jokesSeen.size();
	}
}
