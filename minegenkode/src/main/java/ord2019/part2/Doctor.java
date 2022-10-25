package ord2019.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * A doctor has the capacity to treat one patient at a time.
 * The doctor as a list of competencies (of type String) that
 * indicates what conditions s/he can treat.
 */
public class Doctor {

	private Collection<String> competencies = new ArrayList<>();

	Patient patient;
	
	/**
	 * Initialise this doctor with a set of competencies.
	 * @param competencies
	 */
	public Doctor(String...compentencies) { // 2b
		this.competencies = Arrays.asList(compentencies);
		
	}
	

	/**
	 * Indicates to what extent this doctor can treat the provided patient.
	 * The value is the number of the patient's conditions this doctor
	 * can treat divided by the number of conditions the patient has.
	 * Conditions and competences are matched using simple String comparison.
	 * @param patient
	 * @return the ratio of the patient's conditions that this
	 * doctor can treat.
	 */
	public double canTreat(final Patient patient) { // 2b
		Iterator<String> iterator = patient.iterator();
		
		int numberOfConditions = 0, kanBehandle = 0;
		
		while (iterator.hasNext()) {
			numberOfConditions++;
			String noe = iterator.next();
			if (this.competencies.contains(noe))
				kanBehandle++;
			
		}
		
		return Double.valueOf(kanBehandle / numberOfConditions);
	}


	/**
	 * "Treats" the patient by removing all the patient's conditions
	 * that this doctor can treat.
	 */
	public void treat() { // 2b
		patient.removeConditions(competencies);
	}


	/**
	 * @return the patient this doctor is treating, or null if s/he
	 * isn't currently treating any patient.
	 */
	public Patient getPatient() {
		return null;
	}


	/**
	 * @return true if this doctor is currently treating a patient, otherwise
	 * false.
	 */
	public boolean isAvailable() {
		return false;
	}


	/**
	 * Sets the patient that this doctor is treating, use null to indicate
	 * s/he isn't currently treating any patient.
	 * @param patient
	 */
	public void setPatient(final Patient patient) {
		// Implementation hidden
	}
}


