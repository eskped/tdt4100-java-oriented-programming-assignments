package w08OF;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
	private Department parentDepartment;
	private Collection<Department> childDepartments = new ArrayList<>();
	
	public Department(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
		parentDepartment.addChildDeparment(this);
	}
	
	public Department() {
		
	}
	
	public Department getParentDepartment() {
		return parentDepartment;
	}
	
	private void addChildDeparment(Department childDepartment) {
		if (childDepartment == null) {
			throw new IllegalArgumentException("department is null");
		}
		if (childDepartments.contains(childDepartment)) {
			throw new IllegalArgumentException("Department is already added");
		}
		if (childDepartment == this.parentDepartment || (this.parentDepartment != null && childDepartment == this.parentDepartment.getParentDepartment())) {
			throw new IllegalArgumentException("Department is parent og grandparent");
		}
		childDepartments.add(childDepartment);
	}
		
	
}
