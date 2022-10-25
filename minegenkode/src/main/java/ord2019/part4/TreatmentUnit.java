package ord2019.part4;

import java.util.Collection;
import java.util.function.Predicate;

import ord2019.part2.Doctor;
import ord2019.part2.Patient;

public class TreatmentUnit {

	/**
	 * A class for managing a set of doctors and the patients they're treating. When
	 * doctors or patients arrive, or a doctor finishes a treatment, it is made sure
	 * that patients are treated as soon as possible.
	 */
	
    private DoctorAllocator doctorAllocator = new DefaultDoctorAllocator();


	public void addDoctor(final Doctor doctor) {
		// Implementation hidden
	}

	public Collection<Doctor> getAllDoctors() {
		return null;
		// Implementation hidden
	}

	public Collection<Doctor> getAvailableDoctors() {
		return null;
		// Implementation hidden
	}

	public void addPatient(final Patient patient) {
		// Implementation hidden
	}

	public Doctor getDoctor(final Predicate<Doctor> pred) {
		return null;
		// Implementation hidden
	}

	public Doctor getDoctor(final Patient patient) {
		return null;
		// Implementation hidden
	}

	public Collection<Patient> getAllPatients() {
		return null;
		// Implementation hidden
	}

	public Collection<Patient> getWaitingPatients() {
		return null;
		// Implementation hidden
	}

	

	private void setDoctorAllocator(final DoctorAllocator doctorAllocator) {
		this.doctorAllocator = doctorAllocator;
	}

	protected boolean startTreatment(final Doctor doctor) { 
	
		final Patient patient = doctorAllocator.allocatePatient(doctor, this);
		
		if (patient != null) {
			final Patient oldPatient = doctor.getPatient();
			doctor.setPatient(patient);
			if (oldPatient != null) {
				startTreatment(oldPatient);
			}
			return true;
		}	
		return false;
	}

	protected boolean startTreatment(final Patient patient) { // Part 4
		final Doctor doctor = doctorAllocator.allocateDoctor(patient, this);
		
		if (patient != null) {
			final Patient oldPatient = doctor.getPatient();
			doctor.setPatient(patient);
			if (oldPatient != null) {
				startTreatment(oldPatient);
			}
			return true;
		}
		
		return false;
	    
	   }

	public void treatmentFinished(final Doctor doctor) {
		final Patient oldPatient = doctor.getPatient();
		if (oldPatient != null) {
			if (!oldPatient.requiresTreatment()) {
				Collection<Doctor> patients = null;
				patients.remove(oldPatient);
			} else {
				startTreatment(oldPatient);
			}
		}
		
		doctor.setPatient(null);
		startTreatment(doctor);
	}


}
