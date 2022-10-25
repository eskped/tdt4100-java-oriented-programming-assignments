package w05.jokey.v0502;

import java.util.Random;

import w05.jokey.v0502.core.Joke;
import w05.jokey.v0502.core.Jokes;
import w05.jokey.v0502.user.User;

/**
 * Her har vi strippet den litt ned for en enkel konsoll-utgave da fremover vil
 * det primært være fokus på den utgaven med et grafisk grensesnitt. Se eldre
 * utgaver av Jokey, feks v0501 og Jokey-klassen for kommentarer.
 * 
 */
public class JokeyConsole {
	private String title, version;
	private Jokes jokes = new Jokes();
	private User user;

	private JokeyConsole(String username, String title, String version) {
		this.title = title;
		this.version = version;

		if (username != null) {
			user = new User(username);
		} else {
			// adding a default user
			user = new User("defaultConsoleUser");
		}
	}

	/**
	 * Skriver ut en vits på basis av et vits-nummer.
	 * 
	 * @param jokeIndex En indeks som beskriver vitsens plassering i en liste
	 */
	private void printlnJokeAt(int jokeIndex) {
		try {
			Joke joke = jokes.getJokeAt(jokeIndex);
			System.out.println("\"" + joke.toString() + "\"");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ingen vits funnet for denne identifikatoren");
		}
	}

	/**
	 * Skriver ut en tilfeldig vits.
	 */
	private void printlnRandomJoke() {
		Random random = new Random();
		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			System.err.println("Alle vitsene har blitt sett tidligere!!");
		} else {
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

	private void runApplication() {
		System.out.println(title.toUpperCase());
		System.out.println("Versjon: " + version);
		System.out.println("Bruker: " + user.getUserName());
		System.out.println();

		System.out.println("Hva er \"vitsen\"?");
		printlnRandomJoke();
	}

	public static void launch(String username, String title, String version) {
		JokeyConsole app = new JokeyConsole(username, title, version);
		app.runApplication();
	}
}
