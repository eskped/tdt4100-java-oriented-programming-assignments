package w14OF;

public abstract class Employee {
	
	private String name;
	protected String role;
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void performTask(String task) {
		if(!canPerformTask(task)) {
			throw new IllegalArgumentException(name + " cannot perform: " + task);
		}
		System.out.println(name + "[" + role + "] performed task " + task);
	}
	
	public abstract boolean canPerformTask(String task);
	
	public static void main(String[] args) {
//		Employee employee = new Employee("Eskil", "Elev");
//		employee.performTask("task");

	}
}
