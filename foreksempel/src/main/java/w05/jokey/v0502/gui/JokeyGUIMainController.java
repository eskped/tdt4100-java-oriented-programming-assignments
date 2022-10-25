package w05.jokey.v0502.gui;

import java.util.Random;

import javafx.fxml.FXML;
import w05.jokey.v0502.JokeyApp;
import w05.jokey.v0502.core.Joke;
import w05.jokey.v0502.core.Jokes;
import w05.jokey.v0502.user.User;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class JokeyGUIMainController {
	@FXML
	Label jokeStatsLabel;

	@FXML
	Label jokeLabel;

	@FXML
	void initialize() {
		onResetJokesSeenAction();
	}

	@FXML
	public void onRandomJokeAction() {
		Random random = new Random();
		User user = JokeyApp.getCurrentUserInstance();
		Jokes jokes = JokeyApp.getJokesInstance();

		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			setJokeResultsLabels("Alle vitsene har blitt sett tidligere!!",
					user.getUserData().getUniqueJokesSeenCount(), jokes.getJokesCount());
		} else {
			while (!done) {
				int jokeIndex = random.nextInt(jokes.getJokesCount());
				Joke joke = jokes.getJokeAt(jokeIndex);
				if (user.getUserData().addJokeSeen(joke)) {
					setJokeResultsLabels("\"" + joke.toString() + "\"", user.getUserData().getUniqueJokesSeenCount(),
							jokes.getJokesCount());
					done = true;
				}
			}
		}
	}

	private void setJokeResultsLabels(String msg, int jokesSeen, int jokesCount) {
		jokeLabel.setText(msg);
		jokeStatsLabel.setText(jokesSeen + " av " + jokesCount);
	}

	@FXML
	public void onResetJokesSeenAction() {
		User user = JokeyApp.getCurrentUserInstance();
		Jokes jokes = JokeyApp.getJokesInstance();

		user.getUserData().resetJokesSeen();

		setJokeResultsLabels("", user.getUserData().getUniqueJokesSeenCount(), jokes.getJokesCount());
	}
}
