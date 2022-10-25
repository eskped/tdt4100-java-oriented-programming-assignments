package of11.observable.examples;

import java.util.ArrayList;
import java.util.List;

public class Vitass implements VitassListener {

	private List<VitassListener> studenter = new ArrayList<VitassListener>();
	private String nextExerciseDeadline = "12. mars 2021";
	
	public void changeExerciseDeadline(String newDeadline) {
		this.nextExerciseDeadline = newDeadline;
		this.deadlineChanged(newDeadline);
	}
	
	
	// Observatør-observert-teknikken:
	
	// Metoder for å legge til lyttere etc...
	public void addVitassListener(VitassListener listener) {
		if (!studenter.contains(listener)) {
			studenter.add(listener);
		}
	}

	// Metode for å varsle om endringer
	@Override
	public void deadlineChanged(String newDeadline) {
		for (VitassListener l : studenter) {
			l.deadlineChanged(newDeadline);
		}
		
	}
	
	// Flere metoder trengs for å få et fungerende program
}
