package ord2019.part2;

import java.util.List;

public class EmergencyPriorityTreatmentUnit extends TreatmentUnit {

	@Override
	public boolean startTreatment(Patient patient) {
		if (!super.startTreatment(patient)) {
			Patient patientToSuspend = null;
			for (Doctor doctor : getAllDoctors()) {
				if (doctor.canTreat(patient) > 0.0) {
					Patient existingPatient = doctor.getPatient();
					if (existingPatient != null && getPriority(existingPatient) < getPriority(patient)
							&& (patientToSuspend == null
									|| getPriority(existingPatient) < getPriority(patientToSuspend))) {
						patientToSuspend = existingPatient;
					}
				}
			}
			if (patientToSuspend != null) {
				getDoctor(patientToSuspend).setPatient(patient);
				startTreatment(patientToSuspend);
				return true;
			}
		}
		return false;
	}

	private List<Doctor> getAllDoctors() {
		return null;
	}

	private int getPriority(Patient existingPatient) {
		return 0;
	}

}
