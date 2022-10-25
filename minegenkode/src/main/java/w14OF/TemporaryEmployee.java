package w14OF;

public class TemporaryEmployee extends Employee {

	int numberOfRemainingTasks;
	
	public TemporaryEmployee(String name, String role, int numberOfRemainingTasks) {
		super(name, role);
		this.numberOfRemainingTasks = numberOfRemainingTasks;
	}

	@Override
	public boolean canPerformTask(String task) {
		return numberOfRemainingTasks > 0;
	}
	
	@Override
	public void performTask(String task) {
		if (numberOfRemainingTasks <= 0) {
			throw new IllegalStateException(getName() + " has performed all their tasks");
		}
		super.performTask(task);
		numberOfRemainingTasks--;
		
		if (numberOfRemainingTasks == 0) {
			role = "Quit";
		}
	}
	
	public static void main(String[] args) {
		TemporaryEmployee employee = new TemporaryEmployee("Eskil", "elev", 2);
		employee.performTask("Gjøre oppgaver");
		System.out.println(employee.getRole());
		employee.performTask("Gjøre oppgaver");
		System.out.println(employee.getRole());
		employee.performTask("Gjøre oppgaver");
		System.out.println(employee.getRole());
	}
	
}
