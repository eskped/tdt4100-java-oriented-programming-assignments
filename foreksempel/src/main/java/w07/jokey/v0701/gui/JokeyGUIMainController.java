package w07.jokey.v0701.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import w07.jokey.v0701.JokeyApp;
import w07.jokey.v0701.core.jokes.IJokes;
import w07.jokey.v0701.core.jokes.IJokesRepository;
import w07.jokey.v0701.core.jokes.Joke;
import w07.jokey.v0701.core.jokes.JokesRepositoryManager;
import w07.jokey.v0701.user.User;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class JokeyGUIMainController {
	@FXML
	Label jokeStatsLabel;

	@FXML
	Label jokeBodyLabel;

	@FXML
	Label jokeTitleLabel;

	@FXML
	Label jokeCategoryLabel;

	@FXML ComboBox<IJokesRepository> repositorySelector;

	@FXML
	void initialize() {
		populateRepositorySelector();		
		onResetJokesSeenAction();
	}

	@FXML
	public void onRandomJokeAction() {
		User user = JokeyApp.getCurrentUserInstance();
		IJokes jokes = (IJokes) JokesRepositoryManager.getInstance().getCurrentRepository();
		System.out.println(jokes.toString());

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

	@FXML
	public void onResetJokesSeenAction() {
		User user = JokeyApp.getCurrentUserInstance();

		user.getUserData().resetJokesSeen();
		
		// kjører denne for at du skal få en vist i det du starter opp fremfor en blank skjerm
		onRandomJokeAction();
	}

	@FXML public void onRepositorySelect() {
		IJokesRepository repositorySelected =  repositorySelector.getSelectionModel().getSelectedItem();		
		JokesRepositoryManager.getInstance().setCurrentRepository(repositorySelected);
		// da kan vi jo velge å se en fra det som er valgt
		onRandomJokeAction();
	}

	private void setJokeResultsLabels(String title, String category, String body, int jokesSeen, int jokesCount) {
		jokeTitleLabel.setText("Tittel: " + title);
		jokeCategoryLabel.setText("Kategori: " + category);
		jokeBodyLabel.setText(body);
		jokeStatsLabel.setText(jokesSeen + " av " + jokesCount);
	}
	
	private void populateRepositorySelector() {
	    ObservableList<IJokesRepository> repositories = FXCollections.observableArrayList(JokesRepositoryManager.getInstance().getRepositories());	    
		repositorySelector.setItems(repositories);
		repositorySelector.getSelectionModel().select(JokesRepositoryManager.getInstance().getCurrentRepository());
		repositorySelector.setConverter(new StringConverter<IJokesRepository>() {			
			@Override
			public String toString(IJokesRepository rep) {
				
				if (rep != null)
					return rep.getName();
				return "...";
			}
			
			@Override
			public IJokesRepository fromString(String string) {
				return null;
			}
		});
	}

}
