package ord2019.part2;

public class PriorityTreatmentUnit extends TreatmentUnit {
	
	
	protected double getPriority(Patient patient) {
		return 0.0;
	}
	
	protected boolean startTreatment(final Doctor doctor) {
		Patient highest = null; 
		for (Patient patient : getWaitingPatients()) {
			if (doctor.canTreat(patient) > 0.0) {
				if (highest == null || (getPriority(patient) > getPriority(highest))) {
					highest = patient;
				}
			}
		}
		if (highest != null) {
			doctor.setPatient(highest);
			return true;
		}
		
		return false;
	}
}
