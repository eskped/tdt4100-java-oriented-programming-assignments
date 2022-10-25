package w14.observer.ownimpl;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Her viser vi observat�r-observert-samspill, men hvor vi har laget v�r egen
 * enkle implementasjon. Vi lager her et interface som observat�rer m�
 * implementere, samt at vi lager v�r egen liste over observat�rer og
 * notifikasjon til observat�rer ved endringer.
 */
public class MyObservable extends Thread {
	private String lastMsg;
	private HashSet<MyChangeListner> changeListners = new HashSet<MyChangeListner>();

	public void addChangeListener(MyChangeListner mcl) {
		changeListners.add(mcl);
	}

	public void fireChangeNotification(String newMsg) {
		for (Iterator<MyChangeListner> iterator = changeListners.iterator(); iterator.hasNext();) {
			iterator.next().changeNotification(lastMsg, newMsg);
		}
		lastMsg = newMsg;
	}

	@Override
	public void run() {
		// legger til noen lyttere
		addChangeListener(new MyObserver("Observer AAA"));
		addChangeListener(new MyObserver("Observer BBB"));
		addChangeListener(new MyObserver("Observer CCC"));

		for (int i = 1; i <= 5; i++) {
			try {
				fireChangeNotification(String.format("Melding nr %d", i));
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
