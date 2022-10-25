package ord2019.part2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TreatmentUnitController {

	TreatmentUnit treatmentUnit;
	
	@FXML private Label patientMessage;

	public TreatmentUnitController() {
		treatmentUnit = new TreatmentUnit();
		
		treatmentUnit.addTreatmentUnitLytter(this);
		
    }

	public void upDateView() {
		
	}

	public void treatmentStarted(Doctor doctor, Patient patient, TreatmentUnit treatmentUnit2) {
		patientMessage.setText(doctor.toString() + " har startet behandling på " + patient.toString());
		
	}
}
