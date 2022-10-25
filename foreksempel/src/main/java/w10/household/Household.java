package w10.household;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import w10.household.model.HouseholdManager;
import w10.household.model.Pet;
import w10.household.model.PetType;
import w10.household.model.Plant;
import w10.household.model.PlantType;

public class Household extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("gui/HouseholdGui.fxml"));
        stage.setScene(new Scene(parent));
		stage.setTitle("Household");
		stage.setMinHeight(350);
		stage.setMinWidth(500);
        stage.show();
    }

	public static void main(String[] args) {
		HouseholdManager hm = HouseholdManager.getInstance();
		hm.addMember(new Plant(PlantType.ALOEVERA, "Healer"));
		hm.addMember(new Plant(PlantType.KAKTUS, "Au"));
		hm.addMember(new Pet(PetType.COCKER_SPANIEL, "Alvin"));
		hm.addMember(new Pet(PetType.CHIHUAHUA, "Josefine"));

		launch(Household.class, args);
	}
}
