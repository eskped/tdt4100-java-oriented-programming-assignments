package of12.lf;

public class TemporaryEmployee extends Employee{
	
	private int numberOfRemainingTasks; 
	
	public TemporaryEmployee(String name, String role, int numberOfRemainingTasks) {
		super(name, role);
		this.numberOfRemainingTasks = numberOfRemainingTasks;
	}
	
	
	@Override 
	public void performTask(String task)  {
		if (numberOfRemainingTasks <= 0 ) {
			throw new IllegalStateException( getName() + " has performed all theyr tasks");
		}
		
		super.performTask(task);
		numberOfRemainingTasks = numberOfRemainingTasks - 1; 
		
		if (numberOfRemainingTasks == 0) {
			role = "Quit"; 
		}
		
	}
	
	@Override
	public boolean canPerformTask(String task) {
		return numberOfRemainingTasks > 0;
	}
	
	public static void main(String[] args) {
		TemporaryEmployee employee = new TemporaryEmployee("Vilde", "Vitass", 2);
		employee.performTask("Svare på mail");
		System.out.println(employee.getRole());
		employee.performTask("Svare på mail");
		System.out.println(employee.getRole());
		employee.performTask("Svare på mail");
	}
	

}
