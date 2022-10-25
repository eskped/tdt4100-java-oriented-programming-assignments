package stateandbehavior;

public class UpOrDownCounter {
	
	int counter = 0;
	int end = 0;
	
	public UpOrDownCounter(int start, int end) {
		if (start == end) throw new IllegalArgumentException("Tallene kan ikke være like");
		
		this.counter = start;
		this.end = end;
	}
	
	public boolean count() {
		if (isFinished()) {
			return false;
		}
		
		if (this.counter < end) {
			counter++;
		}
		else {
			counter--;
		}
		
		if (isFinished()) {
			return false;
		}
		else {
			return true;
		}
		
	}
	

	public int getCounter() {
		return this.counter;
	}
	
	
	public boolean isFinished() {
		return this.counter == this.end;
	}
	
	public static void main(String[] args) {
		UpOrDownCounter dc = new UpOrDownCounter(1, 5);
		/*
		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());
		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());

		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());

		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());

		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());

		dc.count();
		System.out.println(dc.getCounter());
		System.out.println(dc.isFinished());
		
		*/
	}
}
