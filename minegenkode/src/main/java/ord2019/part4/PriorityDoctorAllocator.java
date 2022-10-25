package ord2019.part4;

import ord2019.part2.Doctor;
import ord2019.part2.Patient;

public class PriorityDoctorAllocator extends DefaultDoctorAllocator {
	
	
	protected double getPriority(Patient patient) {
		return 0.0;
	}
	
	@Override
	public Patient allocatePatient(final Doctor doctor, final TreatmentUnit treatmentUnit) {
		Patient patient = null;
		
		for (Patient patient2 : treatmentUnit.getWaitingPatients()) {
			if (doctor.canTreat(patient2) > 0.0 && getPriority(patient2) > getPriority(patient)) {
				patient = patient2;
			}
		}
		
		return patient;
	}
}
