package w07.jokey.v0701.core.jokes;

/**
 * Alle kilder til vitser må implementere dette grensesnittet. Med flere kilder
 * skal vi etter hvert se hvordan vi enkelt kan bytte mellom å bruke de
 * forskjellige kildene. Så skal vi legge til en ny kilde og se at vi ikke
 * trenger å endre på koden for å støtte de nye kildene så lenge de
 * implementerer riktige interface. Det eneste som trengs er å registrer den nye
 * kilden, dette er en av de store fordelene ved å benytte interface. En kan
 * gjøre noe tilsvarende ved å ha en klasse som en kan arve fra, og etter hvert
 * i en seinere forelesning skal vi se på fordeler og ulemper med de to
 * teknikkene.
 * 
 * @author steinlt
 *
 */
public interface IJokes {
	// ArrayList<String> getJokeCategories();
	/**
	 * Henter neste tilfeldige vits. Merk at det er ingen garanti for at det kan
	 * være den samme vitsen som den forrige.
	 * 
	 * @return en vits
	 */
	Joke getRandomJoke();
	// Joke getRandomJoke(String category);
	// ArrayList<Joke> searchJokes(String query);

	/**
	 * Henter antallet vitser som er tilgjengelig. Hvis det er ukjent returneres -1,
	 * 
	 * @return Antallet tilgjengelig vitser, eller -1 hvis det er ukjent.
	 */
	int getJokesCount();
}
