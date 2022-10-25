package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	
	Collection<Employee> employees;
	
	HashMap<Employee, Integer> taskCount = new HashMap<Employee, Integer>();

	
	public Manager(Collection<Employee> employees) {
		if (employees.size() == 0) {
			throw new IllegalArgumentException("Listen er tom");
		}
		this.employees = employees;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		
		Integer work = taskCount.get(this);
		if (work==null) {
		    work = 1;
		} else {
			work++;
		}
		taskCount.put(this, work);
		
		return new ArrayList<Employee>(employees)
				.get(new Random().nextInt(employees.size()))
				.doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		Integer work = taskCount.get(this);
		if (work==null) {
		    work = 1;
		} else {
			work++;
		}
		taskCount.put(this, work);
		
		
		new ArrayList<Employee>(employees)
				.get(new Random()
			    .nextInt(employees.size()))
				.printDocument(document);
	}

	@Override
	public int getTaskCount() {
		int oppgaver = 0;
		if (taskCount.get(this) != null) {
			oppgaver += taskCount.get(this);
		}
		return oppgaver;
	}

	@Override
	public int getResourceCount() {
		int ansatte = 0;
		for (Employee employee : employees) {
			ansatte += employee.getResourceCount();
		}
		return ansatte + 1;
	}
	
	public static void main(String[] args) {
		String docuemt1 = "Et dokument";
		Printer printer = new Printer();
		Clerk clerk1 = new Clerk(printer);
		Clerk clerk2 = new Clerk(printer);
		
		Manager managerLv1 = new Manager(Arrays.asList(clerk1, clerk2));
		managerLv1.printDocument(docuemt1);
		System.out.println(managerLv1.getResourceCount());
		System.out.println(managerLv1.getTaskCount());
		
		
		Manager managerLv2 = new Manager(Arrays.asList(managerLv1));
		managerLv2.printDocument(docuemt1);
		System.out.println(managerLv2.getResourceCount());
		System.out.println(managerLv2.getTaskCount());
		System.out.println(managerLv1.getResourceCount());
		System.out.println(managerLv1.getTaskCount());
		
		
		Manager managerLv3 = new Manager(Arrays.asList(managerLv2));
		managerLv3.printDocument(docuemt1);
		System.out.println(managerLv3.getResourceCount());
		System.out.println(managerLv3.getTaskCount());
		System.out.println(managerLv2.getResourceCount());
		System.out.println(managerLv2.getTaskCount());
		System.out.println(managerLv1.getResourceCount());
		System.out.println(managerLv1.getTaskCount());
		
		Manager managerLv4 = new Manager(Arrays.asList(managerLv3));
		managerLv4.printDocument(docuemt1);
		System.out.println(managerLv4.getResourceCount());
		System.out.println(managerLv4.getTaskCount());
		System.out.println(managerLv3.getResourceCount());
		System.out.println(managerLv3.getTaskCount());
		System.out.println(managerLv2.getResourceCount());
		System.out.println(managerLv2.getTaskCount());
		System.out.println(managerLv1.getResourceCount());
		System.out.println(managerLv1.getTaskCount());
		
		
//		managerLv2.printDocument(docuemt1);
//		System.out.println("Oppgaver managerLv2 har gjort: " + managerLv2.getTaskCount());
//		System.out.println("Oppgaver managerLv1 har gjort: " + managerLv1.getTaskCount());
//		System.out.println("Oppgaver clerk1 har gjort: " + clerk1.getTaskCount());
//		System.out.println("Oppgaver clerk2 har gjort: " + clerk2.getTaskCount() + "\n");
//		
//		managerLv2.printDocument(docuemt1);
//		System.out.println("Oppgaver managerLv2 har gjort: " + managerLv2.getTaskCount());
//		System.out.println("Oppgaver managerLv1 har gjort: " + managerLv1.getTaskCount());
//		System.out.println("Oppgaver clerk1 har gjort: " + clerk1.getTaskCount());
//		System.out.println("Oppgaver clerk2 har gjort: " + clerk2.getTaskCount() + "\n");
//		
//		managerLv2.printDocument(docuemt1);
//		System.out.println("Oppgaver managerLv2 har gjort: " + managerLv2.getTaskCount());
//		System.out.println("Oppgaver managerLv1 har gjort: " + managerLv1.getTaskCount());
//		System.out.println("Oppgaver clerk1 har gjort: " + clerk1.getTaskCount());
//		System.out.println("Oppgaver clerk2 har gjort: " + clerk2.getTaskCount() + "\n");
	}
	
}
