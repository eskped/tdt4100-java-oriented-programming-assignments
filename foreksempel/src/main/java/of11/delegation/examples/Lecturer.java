package of11.delegation.examples;

import java.util.ArrayList;
import java.util.List;

public class Lecturer implements TDT4100Employee {

	int nextDelegateIndex = 0;
	private List<TDT4100Employee> undasser = new ArrayList<TDT4100Employee>();

	@Override
	public void answerMail(Mail mail) {
		undasser.get(nextDelegateIndex).answerMail(mail);
		
		nextDelegateIndex++;
		if (nextDelegateIndex >= undasser.size()) {
			nextDelegateIndex = 0;
		}
	}
	

	
	// Metoder for å legge til assistenter etc...
	public void addEmployee(TDT4100Employee employee) {
		if (!undasser.contains(employee)) {
			undasser.add(employee);
		}
	}
	
	// Flere metoder trengs for å få et fungerende program
	
}
