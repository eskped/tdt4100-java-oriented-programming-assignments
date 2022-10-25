package of7.lf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DepartmentTest {

    // Oppgave 2
	@Test
	public void testConstructor() {
		Department parentDepartment = new Department();
		assertNull("Parent of parent department should be null", parentDepartment.getParentDepartment());
		
		Department subDepartment = new Department(parentDepartment);
		assertEquals("Parent department is not set correctly", parentDepartment, subDepartment.getParentDepartment());
	}
	
	@Test
	public void testDepartmentContains() {
		Department NTNU = new Department();
		Department IE = new Department(NTNU);
		Department IDI = new Department(IE);
		Department NV = new Department(NTNU);

		assertTrue("IE should be a sub department of NTNU", NTNU.contains(IE));
		assertTrue("IDI should be a sub department of NTNU", NTNU.contains(IDI));
		assertFalse("NV should not be a sub department of math", IDI.contains(NV));
	}
	
	@Test
	public void testPromote() {
		Department NTNU = new Department();
		Department IDI = new Department(NTNU);
		
		Employee employee = new Employee(IDI);
		
		assertTrue("Before promoting the employee should belong to IDI", employee.getDepartment() == IDI);
		
		employee.promote();

		assertFalse("After promoting the employee should not belong to IDI", employee.getDepartment() == IDI);
		assertTrue("After promoting the employee should belong to the university", employee.getDepartment() == NTNU);
		
		try {
			employee.promote();
			fail("Promotion should throw an IllegalStateException when not possible");
		} catch (IllegalStateException e) {
			assertTrue("After a failed promotion the employee should still belong to NTNU", employee.getDepartment() == NTNU);
		} catch (Exception e) {
			fail("Promotion should throw an IllegalStateException when not possible");
		}
	}

	// Oppgave 9
	@Test
	public void testEmployeeQuit() {
		Department NTNU = new Department();
		Employee employee = new Employee(NTNU);

		employee.quit();
		assertFalse("After quitting, the employee should not belong to NTNU anymore", employee.getDepartment() == NTNU);

		try {
			employee.quit();
			fail("Quitting with no current employer should throw an IllegalStateException");
		} catch (IllegalStateException e) {
			// Do nothing
		} catch (Exception e) {
			fail("Promotion should throw an IllegalStateException when not possible");
		}
	}

	// Oppgave 10 (ekstraoppgave)
	@Test
	public void testDepartmentMove() {
		Department NTNU = new Department();
		Department IE = new Department(NTNU);
		Department IDI = new Department(IE);
		Department NV = new Department(NTNU);

		IDI.moveToDepartment(NV);
		assertTrue("IDI should be part of NV after move", IDI.getParentDepartment() == NV);
		assertFalse("IE should not contain IDI after move", IE.contains(IDI));
		assertTrue("IV should contain IDI after move", NV.contains(IDI));
		IDI.moveToDepartment(null);
		assertFalse("IDI should not be part of NV after move", IDI.getParentDepartment() == NV);
		assertFalse("NV should not contain IDI after move", NV.contains(IDI));
		try {
			IDI.moveToDepartment(IDI);
			fail("Should not be able to move IDI to be child itself");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
		IDI.moveToDepartment(IE);
		try {
			IDI.moveToDepartment(IE);
			fail("Should not be able to move IDI to IE when it is already part of IE");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}

		// This sequence of operations should ordinarily not fail 
		// They may fail if encapsulation is not done properly:
		IDI.moveToDepartment(NTNU);
		IDI.moveToDepartment(IE);
	}
}
