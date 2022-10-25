package ord2019.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * Used to test TreatmentUnit
 */
public class TreatmentUnitTest {


	private TreatmentUnit treatmentUnit;


	@Before
	public void setUp() {
		treatmentUnit = new TreatmentUnit();
	}




	@Test
	public void testAddDoctorsPatient() {
		final Doctor doctor1 = new Doctor("flu"); // new doctor can treat "flu"
		final Doctor doctor2 = new Doctor("noseblead", "pneumonia"); // new doctor can treat "noseblead" and "pneumonia"
		treatmentUnit.addDoctor(doctor1);
		treatmentUnit.addDoctor(doctor2);
		// Test that both doctors are available.
		assertEquals(true, doctor1.isAvailable());
		assertEquals(true, doctor2.isAvailable());


		final Patient patient = new Patient();
		patient.addConditions("flu", "noseblead"); // patient has conditions "flu" and "noseblead"
		// 2e) start sequence diagram
		treatmentUnit.addPatient(patient);
		
		// Test that only one of the doctors are available:
		assertTrue(doctor1.isAvailable() || doctor2.isAvailable());
		assertFalse(doctor1.isAvailable() && doctor2.isAvailable());
		
		Doctor patientDoctor = treatmentUnit.getDoctor(patient);
		patientDoctor.treat();
		treatmentUnit.treatmentFinished(patientDoctor);
		// 2e) end sequence diagram
		// Test that the previous doctor is available and that a
		// new doctor has been assigned to the patient.
		assertTrue(patientDoctor.isAvailable());
        assertNotSame(patientDoctor, treatmentUnit.getDoctor(patient));
        patientDoctor = treatmentUnit.getDoctor(patient);
        patientDoctor.treat();
        treatmentUnit.treatmentFinished(patientDoctor);
        assertTrue(doctor1.isAvailable() && doctor2.isAvailable());
		

		

		
	}
}
