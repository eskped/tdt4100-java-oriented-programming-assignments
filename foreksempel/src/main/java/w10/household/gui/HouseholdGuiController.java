package w10.household.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import w10.household.model.HouseholdManager;
import w10.household.model.LivingThing;
import w10.household.storage.StorageManager;

public class HouseholdGuiController implements Initializable {
	
	@FXML
	private ListView<String> householdList;

	@FXML
	void onReadFromFile(ActionEvent event) {
		HouseholdManager hm = StorageManager.readFromFile();
		if (hm != null) {
			System.out.println("Leste fra fil");
			hm.printHouseholdMembers();
			updateHouseholdListView();
		} else
			System.err.println("Lesing fra fil feilet");
	}

	@FXML
	void onWriteToFile(ActionEvent event) {
		HouseholdManager hm = HouseholdManager.getInstance();
		if (StorageManager.writeToFile(hm))
			System.out.println("Skrev til fil");
		else
			System.err.println("Skriving til fil feilet");
	}
	
	
	private void updateHouseholdListView() {
		HouseholdManager hm = HouseholdManager.getInstance();
		final List<String> listItems = new ArrayList<>();
		Iterator<LivingThing> members = hm.iterator();
		while (members.hasNext()) {
			LivingThing item = (LivingThing) members.next();
			listItems.add(item.toString());
		}
		householdList.getItems().setAll(listItems);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateHouseholdListView();
		
	}
}
