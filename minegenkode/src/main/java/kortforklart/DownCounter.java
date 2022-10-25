package kortforklart;

public class DownCounter {
	int counter = 0;

	public DownCounter(int counter) {
		this.counter = counter;
	}

	public boolean isFinished() {
		return counter == 0;
	}

	public void countDown() {
		if (!isFinished()) {
			counter--;
			System.out.println("Teller ned, er på " + counter);
		}
	}

	public static void main(String[] args) {
		DownCounter dc = new DownCounter(3);
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();

	}
}
