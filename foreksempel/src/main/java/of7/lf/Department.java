package of7.lf;

import java.util.ArrayList;
import java.util.Collection;

public class Department {

    // Oppgave 1
    private Department parentDepartment;
    private Collection<Department> childDepartments = new ArrayList<>();
    private Collection<Employee> employees = new ArrayList<>();

    public Department(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
		parentDepartment.addChildDepartment(this);
    }
    public Department() {

    }
    

    // Oppgave 2
    public Department getParentDepartment() {
        return parentDepartment;
    }
	
    // Oppgave 3
    // Denne metoden skal være public KUN hvis man også gjør oppgave 10, ellers private
    public void addChildDepartment(Department childDepartment) {
        if (childDepartment == null) {
            throw new IllegalArgumentException("Department is null");
        }
		
        if (childDepartments.contains(childDepartment)) {
            throw new IllegalArgumentException("Provided department is already a child of the parent department");
        }

        if (childDepartment == this.parentDepartment
                || (this.parentDepartment != null && childDepartment == this.parentDepartment.getParentDepartment())) {
            throw new IllegalArgumentException("Provided department is a parent (or grandparent) of this department");
        }
        

        // Oppgave 10 (ekstraoppgave)
        if (childDepartment.getParentDepartment() != this) {
            childDepartment.moveToDepartment(this);
        }


        childDepartments.add(childDepartment);
    }

    
    // Oppgave 4
    public boolean contains(Department department) {
        if (childDepartments.contains(department)) {
            return true;
        }
        for (Department childDepartment : childDepartments) {
            if (childDepartment.contains(department)) {
                return true;
            }
        }
        return false;
    }


    // Oppgave 7
    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("Provided employee is already employed by the department");
        }
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new IllegalArgumentException("The employee is not employed by this department");
        }
        employees.remove(employee);
    }
    

    // Oppgave 10 (ekstraoppgave)
    // Her er cluet å sørge for at det er konsistent og gyldig tilstand.
    // Skriv tester og prøv forskjellige edge-cases for å se at ting blir riktig.
    public void moveToDepartment(Department newDepartment) {
        if (newDepartment == this) {
            throw new IllegalArgumentException("Department cannot be a child of itself");
        }
        if (newDepartment == this.parentDepartment) {
            throw new IllegalArgumentException("Department is already a child of the the provided department");
        }
        if (this.parentDepartment != null && this.parentDepartment.contains(this)) {
            this.parentDepartment.removeChildDepartment(this);
        }
        this.parentDepartment = newDepartment;
        if (newDepartment != null && !newDepartment.contains(this)) {
            newDepartment.addChildDepartment(this);
        }
    }
    public void removeChildDepartment(Department department) {
        if (!childDepartments.contains(department)) {
            throw new IllegalArgumentException("The provided department is not a child of this department");
        }
        childDepartments.remove(department);
        if(department.getParentDepartment() == this) {
            department.moveToDepartment(null);
        }
    }
}
