package w14.household_tofix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import w14.household_tofix.simulator.HousholdSimulator;

public class Household extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("gui/HouseholdGui.fxml"));
		stage.setScene(new Scene(parent));
		stage.setTitle("Household");
		stage.setMinHeight(400);
		stage.setMinWidth(550);
		stage.setHeight(400);
		stage.setWidth(550);
		stage.show();
	}

	public static void main(String[] args) {
		int checkEvery = 2;
		int simulationSpeed = 5760; // 15s tilsvarer 24t

		// vi starter simulatoren som går i en egen tråd i bakgrunnen før vi starter opp
		// selve programmet
		var simulator = new HousholdSimulator(checkEvery, simulationSpeed);
		simulator.start();

		launch(Household.class, args);
	}
}
