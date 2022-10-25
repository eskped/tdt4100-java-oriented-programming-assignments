package w12.observer;

/**
 * Her viser vi observatør-observert-samspill, men det mangler noe kode men det skal vi fikse i lag.
 *
 */
public class MyObservable extends Thread {
	@Override
	public void run() {

		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println("-=".repeat(20));
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void main(String[] args) {
		MyObservable myObservable = new MyObservable();
		myObservable.start();
	}
}
