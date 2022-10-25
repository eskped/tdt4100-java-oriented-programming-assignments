package w14.household.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import w14.household.model.HouseholdDummyData;
import w14.household.model.HouseholdManager;
import w14.household.model.LivingState;
import w14.household.model.LivingThing;
import w14.household.model.Pet;
import w14.household.model.Plant;
import w14.household.storage.StorageManager;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.scene.control.Button;

public class HouseholdGuiController implements Initializable, PropertyChangeListener {
	private final String UNKNOWN_COLOR = "derive(violet, 30%)";
	private final String OK_COLOR = "derive(lightgreen, 30%)";
	private final String NEEDS_CARE_SOON_COLOR = "derive(gold, 50%)";
	private final String NEEDS_CARE_COLOR = "derive(orange, 50%)";
	private final String SOON_DEAD_COLOR = "derive(orangered, 50%)";
	private final String TOO_LATE_COLOR = "derive(orangered, 50%)";

	@FXML
	private ListView<String> householdList;
	@FXML
	private Label categoryLabel, typeLabel, nameLabel, statusLabel, lastCareLabel;
	@FXML
	private ProgressBar statusIndicator;
	@FXML
	private AnchorPane detailsPane;
	@FXML
	private Button doCareButton;
	@FXML
	private ProgressBar statusProgressBar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		HouseholdManager.getInstance().addPropertyChangeListener(this);

		householdList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
							setStyle(null);
						} else {
							setText(item);
							HouseholdManager hm = HouseholdManager.getInstance();
							LivingThing member = hm.getMember(item);
							if (member != null) {
								switch (member.getState()) {
								case OK: {
									setStyle("-fx-control-inner-background: " + OK_COLOR + ";");
									break;
								}
								case NEEDS_CARE_SOON: {
									setStyle("-fx-control-inner-background: " + NEEDS_CARE_SOON_COLOR + ";");
									break;
								}
								case NEEDS_CARE: {
									setStyle("-fx-control-inner-background: " + NEEDS_CARE_COLOR + ";");
									break;
								}
								case SOON_DEAD: {
									setStyle("-fx-control-inner-background: " + SOON_DEAD_COLOR + ";");
									break;
								}
								case TOO_LATE: {
									setStyle("-fx-control-inner-background: " + TOO_LATE_COLOR + ";");
									break;
								}
								default:
									// UNKNOWN
									setStyle("-fx-control-inner-background: " + UNKNOWN_COLOR + ";");
								}
							} else
								setStyle(null);
						}
					}
				};
			}
		});
		updateHouseholdListView();
	}

	@FXML
	void onReadFromFile(ActionEvent event) {
		HouseholdManager hmFromFile = StorageManager.readFromFile();
		if (hmFromFile != null) {
			System.out.println("Leste fra fil");
			HouseholdManager hm = HouseholdManager.getInstance();
			hm.removeAllMembers();
			hm.mergeMembers(hmFromFile);
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
		householdList.getItems().clear();
		if (hm != null) {
			hm.printHouseholdMembers();
			final List<String> listItems = new ArrayList<>();
			Iterator<LivingThing> members = hm.iterator();
			while (members.hasNext()) {
				LivingThing item = (LivingThing) members.next();
				listItems.add(item.getName());
			}
			householdList.getItems().setAll(listItems);
		}
		updateSelectionView();
	}

	@FXML
	public void onLoadDummyData() {
		HouseholdDummyData.loadDummyData();
		updateHouseholdListView();
	}

	@FXML
	public void onListSelect() {
		updateSelectionView();
	}

	private void updateSelectionView() {
		String selectedMemberName = householdList.getSelectionModel().getSelectedItem();
		HouseholdManager hm = HouseholdManager.getInstance();
		LivingThing member = hm.getMember(selectedMemberName);
		if (member != null) {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
			String progressBarColor;
			switch (member.getState()) {
			case OK: {
				progressBarColor = OK_COLOR;
				break;
			}
			case NEEDS_CARE_SOON: {
				progressBarColor = NEEDS_CARE_SOON_COLOR;
				break;
			}
			case NEEDS_CARE: {
				progressBarColor = NEEDS_CARE_COLOR;
				break;
			}
			case SOON_DEAD: {
				progressBarColor = SOON_DEAD_COLOR;
				break;
			}
			case TOO_LATE: {
				progressBarColor = TOO_LATE_COLOR;
				break;
			}
			default: {
				progressBarColor = UNKNOWN_COLOR;
				break;
			}
			}

			detailsPane.setVisible(true);
			if (member instanceof Plant) {
				Plant plant = (Plant) member;
				categoryLabel.setText("Plante");
				nameLabel.setText(plant.getName());
				typeLabel.setText(plant.getPlantType().toString());
				statusLabel.setText(plant.getState().toString());
				statusProgressBar.setProgress(plant.getStateScore());
				statusProgressBar.setStyle("-fx-accent: " + progressBarColor + ";");
				if (plant.getLastCare() != null)
					lastCareLabel.setText(plant.getLastCare().format(dateFormatter));
				else
					lastCareLabel.setText("Ukjent");
				if (plant.getState() == LivingState.TOO_LATE)
					doCareButton.setDisable(true);
				else {
					doCareButton.setDisable(false);
					doCareButton.setText(String.format("Gi %s litt kjærlighet", plant.getName()));
				}
			} else if (member instanceof Pet) {
				Pet pet = (Pet) member;
				categoryLabel.setText("Kjæledyr");
				nameLabel.setText(pet.getName());
				typeLabel.setText(pet.getPetType().toString());
				statusLabel.setText(pet.getState().toString());
				statusProgressBar.setProgress(pet.getStateScore());
				statusProgressBar.setStyle("-fx-accent: " + progressBarColor + ";");
				if (pet.getLastCare() != null)
					lastCareLabel.setText(pet.getLastCare().format(dateFormatter));
				else
					lastCareLabel.setText("Ukjent");
				if (pet.getState() == LivingState.TOO_LATE)
					doCareButton.setDisable(true);
				else {
					doCareButton.setDisable(false);
					doCareButton.setText(String.format("Gi %s litt kjærlighet", pet.getName()));
				}
			} else {
				System.err.println("Unknown member type");
				detailsPane.setVisible(false);
			}
		} else {
			detailsPane.setVisible(false);
		}
	}

	@FXML
	public void onDoCare() {
		String selectedMemberName = householdList.getSelectionModel().getSelectedItem();
		HouseholdManager hm = HouseholdManager.getInstance();
		LivingThing member = hm.getMember(selectedMemberName);
		if (member != null) {
			System.out.println(String.format("Gir %s litt kjærlighet!", member.getName()));
			member.doCare();
			updateSelectionView();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt != null && evt.getPropertyName().equals(HouseholdManager.HOUSEHOLD_MEMBER_STATE_CHANGE)) {
			// siden denne metoden kan kalles fra en annen tråd oppretter vi en ny tråd som
			// kan oppdatere grensesnittet når det måtte passe. Da ungår vi at de går i
			// beina på hverandre :-)
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					householdList.refresh();
					updateSelectionView();
				}
			});
		}
	}
}
