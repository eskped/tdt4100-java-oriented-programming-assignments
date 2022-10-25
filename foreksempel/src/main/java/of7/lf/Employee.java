package of7.lf;

public class Employee {
    
    // Oppgave 6
    private Department department;

    public Employee(Department department) {
        this.department = department;

        // Oppgave 7
        department.addEmployee(this);
    }


    // Oppgave 8a
    public void promote() {
        if (department == null || department.getParentDepartment() == null) {
            throw new IllegalStateException("There is no department to be promoted to");
        }

        department.removeEmployee(this); // Remove employee from current department
        department = department.getParentDepartment(); // Update department reference to parent department
        department.addEmployee(this); // Add employee to list of employees in the parent department
    }
    
    // Oppgave 8b
    public void quit() {
        if (this.department == null) {
            throw new IllegalStateException("You cannot quit your job since you are no longer employed");
        }
        department.removeEmployee(this);
        department = null;
    }

    // Nødvendig for tester
    public Department getDepartment() {
        return this.department;
    }
}
