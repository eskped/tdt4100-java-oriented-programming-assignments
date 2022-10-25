package w06.jokey.v0601.gui;

import javafx.fxml.FXML;
import w06.jokey.v0601.*;
import w06.jokey.v0601.core.*;
import w06.jokey.v0601.user.*;
import javafx.scene.control.Label;

public class JokeyGUIMainController {
	@FXML
	Label jokeStatsLabel;

	@FXML
	Label jokeBodyLabel;

	@FXML
	Label jokeTitleLabel;

	@FXML
	Label jokeCategoryLabel;

	@FXML
	void initialize() {
		onResetJokesSeenAction();
	}

	@FXML
	public void onRandomJokeAction() {
		User user = JokeyApp.getCurrentUserInstance();
		IJokes jokes = JokeyApp.getJokesInstance();

		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			setJokeResultsLabels("", "", "Alle vitsene har blitt sett tidligere!!",
					user.getUserData().getUniqueJokesSeenCount(), jokes.getJokesCount());
		} else {
			while (!done) {
				Joke joke = jokes.getRandomJoke();
				if (user.getUserData().addJokeSeen(joke)) {
					setJokeResultsLabels(joke.getTitle(), joke.getCategory(), joke.getBody(), user.getUserData().getUniqueJokesSeenCount(),
							jokes.getJokesCount());
					done = true;
				}
			}
		}
	}

	private void setJokeResultsLabels(String title, String category, String body, int jokesSeen, int jokesCount) {
		jokeTitleLabel.setText("Tittel: " + title);
		jokeCategoryLabel.setText("Kategori: " + category);
		jokeBodyLabel.setText(body);
		jokeStatsLabel.setText(jokesSeen + " av " + jokesCount);
	}

	@FXML
	public void onResetJokesSeenAction() {
		User user = JokeyApp.getCurrentUserInstance();

		user.getUserData().resetJokesSeen();
		
		// kjører denne for at du skal få en vist i det du starter opp fremfor en blank skjerm
		onRandomJokeAction();
	}
}
