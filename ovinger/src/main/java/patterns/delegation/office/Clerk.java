package patterns.delegation.office;

import java.util.HashMap;
import java.util.function.BinaryOperator;


public class Clerk implements Employee {

	private Printer printer;
	
	HashMap<Employee, Integer> taskCount = new HashMap<Employee, Integer>();

	
	public Clerk(Printer printer) {
		this.printer = printer;
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
		
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
	}

	@Override
	public int getTaskCount() {
		int printere = 0;
		int kalkulasjoner = 0;
		if (this.printer.getPrintHistory(this) != null) {
			printere += this.printer.getPrintHistory(this).size();
		}
		if (taskCount.get(this) != null) {
			kalkulasjoner += taskCount.get(this);
		}
		return printere + kalkulasjoner;
	}

	@Override
	public int getResourceCount() {		
		return 1;
	}
	
//	public static void main(String[] args) {
//		Printer printer = new Printer();
//		Clerk clerk1 = new Clerk(printer);
//		Clerk clerk2 = new Clerk(printer);
//		
//		printer.printDocument("dokument1", clerk1);
////		Assertions.assertEquals(1
//		System.out.println(printer.getPrintHistory(clerk1).size());
////		Assertions.assertTrue(
//		System.out.println(printer.getPrintHistory(clerk1).contains("dokument1"));
////		Assertions.assertEquals(0, 
//		System.out.println(printer.getPrintHistory(clerk2).size());
//	}

}
