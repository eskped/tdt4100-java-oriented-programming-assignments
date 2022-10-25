package ord2019.part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * A class for managing a set of doctors and the patients they're treating. When
 * doctors or patients arrive, it is made sure that patients are treated as soon
 * as possible.
 */
public class TreatmentUnit {


	private Collection<Patient> patients = new ArrayList<>();
	private Collection<Doctor> doctors = new ArrayList<>();


	/**
	 * Adds a doctor and makes sure s/he starts treating a patient, if one is waiting.
	 * @param doctor
	 */
	public void addDoctor(final Doctor doctor) {  // 1b
		doctors.add(doctor);
		startTreatment(doctor);
	}

	/**
	 * Adds a patient to this treatment unit, and makes sure treatment starts if any doctor is available.
	 * Otherwise the patient is queued for treatment when a doctor becomes available.
	 * @param patient
	 */
	public void addPatient(final Patient patient) {  // 1b
		if (!patients.contains(patient)) {
			patients.add(patient);
			startTreatment(patient);
		}

	}

	/**
	 * @return the currently available doctors
	 */
	public Collection<Doctor> getAvailableDoctors() {  // 1b
		Collection<Doctor> ready = new ArrayList<>();
		for (Doctor doctor : doctors) {
			if (doctor.isAvailable()) {
				ready.add(doctor);
			}
		}
		return ready;
	}



	/**
	 * @param pred the predicate that the doctor must satisfy
	 * @return some doctor satisfying the predicate
	 */
	public Doctor getDoctor(final Predicate<Doctor> pred) {  // 1b
		for (Doctor doctor : doctors) {
			if (pred.test(doctor)) {
				return doctor;
			}
		}
		return null;
	}

	/**
	 * Find the doctor, if any, that treats the provided patient.
	 * @param patient
	 * @return the doctor treating the provided patient, or null, of the patient isn't currently being treated
	 */
	public Doctor getDoctor(final Patient patient) {  // 1b
		for (Doctor doctor : doctors) {
			if (doctor.getPatient().equals(patient)) {
				return doctor;
			}
		}
		return null;
	}

	/**
	 * Find all patients that are not currently being treated.
	 * @return the patients not currently being treated.
	 */
	public Collection<Patient> getWaitingPatients() {  // 1b
		final Collection<Patient> result = new ArrayList<>();
		for (Patient patient : patients) {
			if (getDoctor(patient) == null) {
				result.add(patient);
			}
		}
		return result;
	}

	/**
	 * Finds a waiting patient and sets him/her as the provided doctor's patient.
	 * @param doctor the doctor for which a patient to treat should be found
	 * @return true if a patient for the provided doctor was found, false
	 * otherwise.
	 */
	private boolean startTreatment(final Doctor doctor) {   // 1c
		for (Patient patient : getWaitingPatients()) {
			doctor.setPatient(patient);
			return true;
		}
		return false;
	}

	/**
	 * Finds an available doctor for the provided patient, and sets that doctor to
	 * treat the patient.
	 * @param patient the patient for which a treating doctor should be found.
	 * @return true if a doctor for the provided patient was found, false
	 * otherwise.
	 */
	private boolean startTreatment(final Patient patient) {   // 1c
		for (Doctor doctor : getAvailableDoctors()) {
			doctor.setPatient(patient);
			return true;
		}
		return false;
	}

	/**
	 * Removes the link between doctor and patient, after treatment is finished.
	 * Since the patient is fully treated, s/he is removed from this treatment
	 * unit.
	 * Also ensure the doctor starts treating another patient.
	 * @param doctor the doctor that has finished treating his/her patient.
	 */
	public void treatmentFinished(final Doctor doctor) {  // 1c
		if (doctor.getPatient() == null) {
			throw new IllegalStateException(doctor + " had no patient!");
		}
		Patient patient = doctor.getPatient();
		patients.remove(patient);
		doctor.setPatient(null);
		startTreatment(doctor);
	}

}






