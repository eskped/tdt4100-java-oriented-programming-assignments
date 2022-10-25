package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Printer {
	
	HashMap<Employee, ArrayList<String>> history = new HashMap<Employee, ArrayList<String>>();

	
	public void printDocument(String document, Employee employee) {
		System.out.println(document);
		
		ArrayList<String> work = history.get(employee);
		
		if (work==null) {
		    work = new ArrayList<String>();
		    work.add(document);
		} else {
			work.add(document);
		}
		history.put(employee, work);
	}
	
	public List<String> getPrintHistory(Employee employee) {		
		List<String> newList = new ArrayList<String>();
		if (history.get(employee) != null) {
			newList.addAll(history.get(employee));
			return newList;
		} else {
			return newList;
		}
	}
}
