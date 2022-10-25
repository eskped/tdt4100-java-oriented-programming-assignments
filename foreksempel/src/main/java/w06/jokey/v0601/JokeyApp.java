package w06.jokey.v0601;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import w06.jokey.v0601.core.*;
import w06.jokey.v0601.user.*;

public class JokeyApp extends Application {
	private String title, version;
	private static IJokes jokesInstance;
	private static User currentUserInstance;

	public static IJokes getJokesInstance() {
		return jokesInstance;
	}

	public static User getCurrentUserInstance() {
		return currentUserInstance;
	}

	@Override
	public void init() throws Exception {
		Parameters params = getParameters();
		title = params.getNamed().get("title");
		version = params.getNamed().get("version");
		String username = params.getNamed().get("username");

		if (jokesInstance == null) {
			/*
			 * Her kan du bytte kilde til vitser, i neste utgave vil vi legge til at dette
			 * kan gj�res fra det grafiske brukergrensesnittet
			 */
			//jokesInstance = new JokesMemoryRepository();
			jokesInstance = new JokesWockaFileRepository();
		}
		if (currentUserInstance == null) {
			if (username != null) {
				currentUserInstance = new User(username);
			} else {
				// adding a default user
				currentUserInstance = new User("defaultAppUser");
			}
		}

		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(title + " (" + version + ")");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("gui/JokeyGUIMain.fxml"))));
		primaryStage.setMinHeight(150);
		primaryStage.setMinWidth(200);
		primaryStage.show();
	}

	public static void launch(String username, String title, String version) throws Exception {
		String[] args = new String[] { "--title=" + title, "--version=" + version }; // , "--username=" + username };
		JokeyApp.launch(args);
	}
}