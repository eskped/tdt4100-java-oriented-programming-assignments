package w09.jokey.v0901;

import w09.jokey.v0901.core.jokes.IJokes;
import w09.jokey.v0901.core.jokes.Joke;
import w09.jokey.v0901.core.jokes.JokesWockaFileRepository;
import w09.jokey.v0901.user.User;

/**
 * Her har vi strippet den litt ned for en enkel konsoll-utgave da fremover vil
 * det primært være fokus på den utgaven med et grafisk grensesnitt. Se eldre
 * utgaver av Jokey, feks v0501 og Jokey-klassen for kommentarer.
 * 
 */
public class JokeyConsole {
	private String title, version;
	private IJokes jokes;
	private User user;

	private JokeyConsole(String username, String title, String version) throws Exception {
		this.title = title;
		this.version = version;

		/*
		 * Her kan du bytte kilde til vitser, i neste utgave vil vi legge til at dette
		 * kan gjøres ved oppstart av programmet via en parameter
		 */
		//jokes = new JokesMemoryRepository();
		jokes = new JokesWockaFileRepository();
		
		if (username != null) {
			user = new User(username);
		} else {
			// adding a default user
			user = new User("defaultConsoleUser");
		}
	}

	/**
	 * Skriver ut en tilfeldig vits.
	 */
	private void printlnRandomJoke() {
		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			System.err.println("Alle vitsene har blitt sett tidligere!!");
		} else {
			while (!done) {
				Joke joke = jokes.getRandomJoke();
				if (user.getUserData().addJokeSeen(joke)) {
					System.out.println("\"" + joke.toString() + "\"");
					done = true;
				}
			}
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

	public static void launch(String username, String title, String version) throws Exception {
		JokeyConsole app = new JokeyConsole(username, title, version);
		app.runApplication();
	}
}
