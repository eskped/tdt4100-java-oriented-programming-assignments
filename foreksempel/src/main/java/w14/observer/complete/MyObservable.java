package w14.observer.complete;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Her viser vi observatør-observert-samspill, men hvor vi benytter
 * standardklasser. Vi delegerer altså oppgaven med å ivareta en liste med
 * observatører og det å gi observatører melding om endringer til
 * standardklassen i Java for observatør-observert-samspill.
 * 
 * NB! Dette eksemplet benytter JavaBeans, det betyr at hvis du får feil med
 * importsetningene over slik som "The type java.beans.PropertyChangeListener is
 * not accessible" betyr det at du må legge til "requires java.desktop;" i
 * module-info.java filen eller eventuelt velge "Add 'requires java.desktop;' to
 * module-info.java" når du enten klikker på feilikonet til venstre for import
 * linjen eller fra popupen som kommer når du har musepeker over den feilaktige
 * import linjen.
 * 
 * Hvis du fortsatt skulle få feil, prøve følgende som ofte hjelper. Høyreklikke
 * på prosjektet ditt, velg Maven -> Update Project...
 *
 */
public class MyObservable extends Thread {
	private String lastMsg;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void fireChangeNotification(String msg) {
		pcs.firePropertyChange("melding", lastMsg, msg);
		lastMsg = msg;
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
