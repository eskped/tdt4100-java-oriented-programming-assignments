package ord2019.part1;


/**
 * A doctor has the capacity to treat one patient at a time.
 */
public class Doctor {

	private Patient patient;


	/**
	 * @return the patient this doctor is treating, or null if s/he isn't currently treating any patient.
	 */
	public Patient getPatient() { // 1a
		return patient;
	}


	/**
	 * @return true if this doctor is currently treating a patient, otherwise false.
	 */
	public boolean isAvailable() { // 1a
		return getPatient() == null;
	}

	/**
	 * Sets the patient that this doctor is treating, use null to indicate s/he isn't currently treating any patient.
	 * @param patient
	 */
	public void setPatient(final Patient patient) { // 1a
		this.patient = patient;
	}
}
