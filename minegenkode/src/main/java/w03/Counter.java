package w03;

public class Counter {
	
	int end;
	int counter = 1;
	
	
	//Konstruktøren. Den skal alltid starte på 1
	public Counter(int end) {
		this.end = end;
	}
	
	int getCounter() {
		return counter;
	}
	
	boolean count() {
		if (counter == end) {
			return true;
		}
		else {
			counter++;
			return counter >= end;
		}
	}
	
	boolean count (int inc) {
		if (counter == end) {
			return true;
		}
		else {
			counter += inc;
			return counter >= end;
		}
	}
	
	
	public static void main(String[] args) {
		Counter c0 = new Counter(3);
		System.out.println(c0.getCounter());
		System.out.println(c0.count());
		System.out.println(c0.count());
		System.out.println(c0.count());
		
		System.out.println("");
		
		Counter c1 = new Counter(3);
		System.out.println(c1.getCounter());
		System.out.println(c1.count(3));
		System.out.println(c1.getCounter());
		System.out.println("");

	}

}
