package ord2019.part4;

import ord2019.part2.Doctor;
import ord2019.part2.Patient;

public class DefaultDoctorAllocator implements DoctorAllocator {

	@Override
	public Patient allocatePatient(final Doctor doctor, final TreatmentUnit treatmentUnit) {
		for (final Patient patient : treatmentUnit.getWaitingPatients()) {
			if (doctor.canTreat(patient) > 0.0) {
				return patient;
			}
		}
		return null;
	}

	@Override
	public Doctor allocateDoctor(Patient patient, TreatmentUnit treatmentUnit) {
		for (final Doctor doctor : treatmentUnit.getAvailableDoctors()) {
            if (doctor.canTreat(patient) > 0.0) {
                return doctor;
            }
        }
		return null;
	}
	
	
	
}
