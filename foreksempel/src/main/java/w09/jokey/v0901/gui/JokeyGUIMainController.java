package w09.jokey.v0901.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import w09.jokey.v0901.JokeyApp;
import w09.jokey.v0901.core.Constants;
import w09.jokey.v0901.core.jokes.IJokes;
import w09.jokey.v0901.core.jokes.IJokesRepository;
import w09.jokey.v0901.core.jokes.Joke;
import w09.jokey.v0901.core.jokes.JokesRepositoryManager;
import w09.jokey.v0901.core.storage.AppPropertiesManager;
import w09.jokey.v0901.user.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	@FXML
	ComboBox<IJokesRepository> repositorySelector;

	@FXML
	void initialize() {
		populateRepositorySelector();
		onRandomJokeAction();
	}

	@FXML
	public void onRandomJokeAction() {
		User user = JokeyApp.getCurrentUserInstance();
		IJokes jokes = (IJokes) JokesRepositoryManager.getInstance().getCurrentRepository();

		boolean done = user.getUserData().getUniqueJokesSeenCount() >= jokes.getJokesCount();
		if (done) {
			setJokeResultsLabels("", "", "Alle vitsene har blitt sett tidligere!!",
					user.getUserData().getUniqueJokesSeenCount(), jokes.getJokesCount());
		} else {
			while (!done) {
				Joke joke = jokes.getRandomJoke();
				if (user.getUserData().addJokeSeen(joke)) {
					setJokeResultsLabels(joke.getTitle(), joke.getCategory(), joke.getBody(),
							user.getUserData().getUniqueJokesSeenCount(), jokes.getJokesCount());
					done = true;
				}
			}
		}
	}

	@FXML
	public void onResetJokesSeenAction() {
		User user = JokeyApp.getCurrentUserInstance();

		user.getUserData().resetJokesSeen();

		// vis en tilfeldig vits vs at det bare blir en blank side
		onRandomJokeAction();
	}

	@FXML
	public void onRepositorySelect() {
		IJokesRepository repositorySelected = repositorySelector.getSelectionModel().getSelectedItem();
		JokesRepositoryManager.getInstance().setCurrentRepository(repositorySelected);
		AppPropertiesManager.getInstance().setProperty(Constants.PROPS_KEY_JOKE_REPOSITORY,
				repositorySelected.getIdentifierAsString());
		// vis en tilfeldig vits etter valg av ny kilde
		onRandomJokeAction();
	}

	private void setJokeResultsLabels(String title, String category, String body, int jokesSeen, int jokesCount) {
		jokeTitleLabel.setText("Tittel: " + title);
		jokeCategoryLabel.setText("Kategori: " + category);
		jokeBodyLabel.setText(body);
		jokeStatsLabel.setText(jokesSeen + " av " + jokesCount);
	}

	private void populateRepositorySelector() {
		JokesRepositoryManager jrm = JokesRepositoryManager.getInstance();

		// sett sist brukte kilde til vitser
		AppPropertiesManager props = AppPropertiesManager.getInstance();
		String jokeRepositoryId = props.getProperty(Constants.PROPS_KEY_JOKE_REPOSITORY);
		IJokesRepository jokeRepository = jrm.getRepository(jokeRepositoryId);
		if (jokeRepository != null)
			jrm.setCurrentRepository(jokeRepository);

		// så kan dropdown-listen populeres
		ObservableList<IJokesRepository> repositories = FXCollections.observableArrayList(jrm.getRepositories());
		repositorySelector.setItems(repositories);
		repositorySelector.getSelectionModel().select(jrm.getCurrentRepository());
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
