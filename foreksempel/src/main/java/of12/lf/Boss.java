package of12.lf;

import java.util.Arrays;
import java.util.List;

public class Boss extends Employee {
	
	private List<Employee> subordinates; 
	
	public Boss(String name, List<Employee> subordinates) {
		super(name, "Boss"); 
		
		if (subordinates.isEmpty()) {
			throw new IllegalArgumentException("A boss needs at least one subordinate");
		}
		this.subordinates = subordinates;
	}
	
	public Boss(String name, Employee... employees) {
		this(name, Arrays.asList(employees));
	}
	
	@Override
	public boolean canPerformTask(String task) {
		return subordinates.stream().anyMatch((subordinate) -> subordinate.canPerformTask(task));
	}
	
	@Override 
	public void performTask(String task) {
		subordinates.stream()
								.filter((subordinate) -> subordinate.canPerformTask(task))
								.findAny()
								.orElseThrow(() -> new IllegalArgumentException("No subordinates can perform this task"))
								.performTask(task);
	}
	
	public static void main(String[] args) {
		// Tester at oppførsel er riktig - skal få feilmelding sinden temp har brukt opp
		// oppgaven sin og assistant kan ikke utføre "make video
		Assistant assitant = new Assistant("assitant1");
		TemporaryEmployee temp = new TemporaryEmployee("temp", "Assistant", 1);
		
		Boss boss = new Boss("Halvard", assitant, temp);
		
		boss.performTask("Arrange meeting");
		boss.performTask("Make video");
		boss.performTask("Make video");

	}
	
	

}
