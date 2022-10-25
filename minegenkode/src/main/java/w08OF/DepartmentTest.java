package w08OF;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DepartmentTest {
	
	@Test
	public void testConstructor() {
		Department parentDepartment = new Department();
		assertNull("Parent depertment shjould be null", parentDepartment.getParentDepartment());
		
		Department subDepartment = new Department(parentDepartment);
		assertEquals("partent department is not set correctly", parentDepartment, subDepartment.getParentDepartment());
		
	}
	
	
	
}
