package w09.jokey.v0901;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import w09.jokey.v0901.core.jokes.JokesMemoryRepository;
import w09.jokey.v0901.core.jokes.JokesRepositoryManager;
import w09.jokey.v0901.core.jokes.JokesWockaFileRepository;
import w09.jokey.v0901.user.User;

public class JokeyApp extends Application {
	private String title, version;
	private static User currentUserInstance;

	public static User getCurrentUserInstance() {
		return currentUserInstance;
	}

	@Override
	public void init() throws Exception {
		Parameters params = getParameters();
		title = params.getNamed().get("title");
		version = params.getNamed().get("version");
		String username = params.getNamed().get("username");

		/*
		 * La oss legge til kilder for vitser
		 */
		JokesRepositoryManager repositoryManager = JokesRepositoryManager.getInstance();
		JokesMemoryRepository memRep = new JokesMemoryRepository();
		repositoryManager.addRepository(memRep);
		JokesWockaFileRepository wockaRep = new JokesWockaFileRepository();
		repositoryManager.addRepository(wockaRep);
		// og til slutt sette default
		// Prøv å sett default til memRep og se om det fungerer slik det skal
		repositoryManager.setCurrentRepository(wockaRep);

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
