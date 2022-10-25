package w07.jokey.v0701.core.jokes;

/**
 * Alle kilder til vitser m� implementere dette grensesnittet. Med flere kilder
 * skal vi etter hvert se hvordan vi enkelt kan bytte mellom � bruke de
 * forskjellige kildene. S� skal vi legge til en ny kilde og se at vi ikke
 * trenger � endre p� koden for � st�tte de nye kildene s� lenge de
 * implementerer riktige interface. Det eneste som trengs er � registrer den nye
 * kilden, dette er en av de store fordelene ved � benytte interface. En kan
 * gj�re noe tilsvarende ved � ha en klasse som en kan arve fra, og etter hvert
 * i en seinere forelesning skal vi se p� fordeler og ulemper med de to
 * teknikkene.
 * 
 * @author steinlt
 *
 */
public interface IJokes {
	// ArrayList<String> getJokeCategories();
	/**
	 * Henter neste tilfeldige vits. Merk at det er ingen garanti for at det kan
	 * v�re den samme vitsen som den forrige.
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
