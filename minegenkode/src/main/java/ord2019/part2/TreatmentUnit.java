package ord2019.part2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * A class for managing a set of doctors and the patients they're treating.
 * When doctors or patients arrive, it is made sure that patients are treated
 * as soon as possible.
 */
public class TreatmentUnit {


	protected Collection<Patient> patients = new ArrayList<>();
	protected Collection<Doctor> doctors = new ArrayList<>();
	
	/**
	 * Adds a doctor and makes sure s/he starts treating a patient, if one
	 * is waiting.
	 * @param doctor
	 */
	public void addDoctor(final Doctor doctor) {
		doctors.add(doctor);
		startTreatment(doctor);
	}


	/**
	 * @return the currently available doctors
	 */
	public Collection<Doctor> getAvailableDoctors() {
		Collection<Doctor> ready = new ArrayList<>();
		for (Doctor doctor : doctors) {
			if (doctor.isAvailable()) {
				ready.add(doctor);
			}
		}
		return ready;
	}


	/**
	 * Adds a patient to this treatment unit, and makes sure treatment starts
	 * if any doctor is available.
	 * Otherwise the patient is queued for treatment when a doctor becomes
	 * available.
	 * @param patient
	 */
	public void addPatient(final Patient patient) {
		patients.add(patient);
		startTreatment(patient);
	}


	/**
	 * @param pred the predicate that the doctor must satisfy
	 * @return some doctor satisfying the predicate
	 */
	public Doctor getDoctor(final Predicate<Doctor> pred) {
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
	 * @return the doctor treating the provided patient, or null if the
	 * patient isn't currently being treated.
	 */
	public Doctor getDoctor(final Patient patient) {
		for (Doctor doctor : doctors) {
			if (doctor.getPatient().equals(patient)) {
				return doctor;
			}
		}
		return null;
	}


	/**
	 * Find all patients that are not currently being treated
	 * @return the patients not currently being treated
	 */
	public Collection<Patient> getWaitingPatients() {
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
	 * Will only accept a patient that has some condition that the doctor actually
	 * can treat.
	 * @param doctor the doctor for which a patient to treat should be found
	 * @return true if a patient for the provided doctor was found, false
	 * otherwise.
	 */
	private boolean startTreatment(final Doctor doctor) {
		for (Patient patient : getWaitingPatients()) {
			if (doctor.canTreat(patient) > 0.0) {
				doctor.setPatient(patient);
				fireTreatmentStarted(patient, doctor);
				return true;
			}
		}
		return false;
	}


	/**
	 * Finds an available doctor for the provided patient, and sets that
	 * doctor to treat the patient.
	 * Will only accept a doctor that actually can treat some condition for the
	 * provided patient.
	 * @param patient the patient for which a treating doctor should be found
	 * @return true if a doctor for the provided patient was found, false
	 * otherwise.
	 */
	protected boolean startTreatment(final Patient patient) {
		for (Doctor doctor : getAvailableDoctors()) {
			if (doctor.canTreat(patient) > 0.0 ) {
				doctor.setPatient(patient);
				fireTreatmentStarted(patient, doctor);
				return true;
			}
		}
		return false;
	}


	/**
	 * Removes the link between doctor and patient, after treatment is finished.
	 * If the patient is fully treated, s/he is removed from this treatment unit,
	 * otherwise another round of treatment is initiated.
	 * Also ensure the doctor starts treating another patient.
	 * @param doctor the doctor that has finished treating his/her patient
	 */
	public void treatmentFinished(final Doctor doctor) {
		if (doctor.getPatient() == null) {
			throw new IllegalStateException(doctor + " had no patient!");
		}
		Patient patient = doctor.getPatient();
		if (!patient.requiresTreatment()) {
			patients.remove(patient);
		} else {
			startTreatment(patient);
		}
		
		doctor.setPatient(null);
		startTreatment(doctor);
	}
	
	Collection<TreatmentUnitController> lyttere = new ArrayList<>();
	
	public void addTreatmentUnitLytter(TreatmentUnitController treatmentUnitController) {
		lyttere.add(treatmentUnitController);
	}
	
	public void removeTreatmentUnitLytter(TreatmentUnitLytter lytter) {
		lyttere.remove(lytter);
	}
	
	private void fireTreatmentStarted(Patient patient, Doctor doctor) {
		for (TreatmentUnitController lytter : lyttere) {
			lytter.treatmentStarted(doctor, patient, this);
		}
	}
	
	
	
}
