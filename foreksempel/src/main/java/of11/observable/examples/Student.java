package of11.observable.examples;

public class Student implements VitassListener {

	private String nextExerciseDeadline = "12. mars 2021";

	@Override
	public void deadlineChanged(String newDeadline) {
		this.nextExerciseDeadline = newDeadline;
	}
	
	
}
