package ord2019.part4;

import ord2019.part2.Doctor;
import ord2019.part2.Patient;

public class EmergencyPriorityDoctorAllocator extends DefaultDoctorAllocator {
	
	
	@Override
	public Doctor allocateDoctor(final Patient patient, final TreatmentUnit treatmentUnit) {
		final Doctor doctor = super.allocateDoctor(patient, treatmentUnit);
        if (doctor != null) {
            return doctor;
        }
        
        Patient patientToSuspend = null;
        for (final Doctor doctor2 : treatmentUnit.getAllDoctors()) {
            if (doctor2.canTreat(patient) > 0.0) {
                final Patient existingPatient = doctor2.getPatient();
                if (existingPatient != null && getPriority(existingPatient) < getPriority(patient) &&
                        (patientToSuspend == null || getPriority(existingPatient) < getPriority(patientToSuspend))) {
                    patientToSuspend = existingPatient;
                }
            }
        }
        if (patientToSuspend != null) {
            return treatmentUnit.getDoctor(patientToSuspend);
        }
        return null;
    }

	private int getPriority(Patient existingPatient) {
		return 0;
	}
}
