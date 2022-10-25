package w14.observer.complete;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Her viser vi observat�r-observert-samspill, men hvor vi benytter
 * standardklasser. Vi delegerer alts� oppgaven med � ivareta en liste med
 * observat�rer og det � gi observat�rer melding om endringer til
 * standardklassen i Java for observat�r-observert-samspill.
 * 
 * NB! Dette eksemplet benytter JavaBeans, det betyr at hvis du f�r feil med
 * importsetningene over slik som "The type java.beans.PropertyChangeListener is
 * not accessible" betyr det at du m� legge til "requires java.desktop;" i
 * module-info.java filen eller eventuelt velge "Add 'requires java.desktop;' to
 * module-info.java" n�r du enten klikker p� feilikonet til venstre for import
 * linjen eller fra popupen som kommer n�r du har musepeker over den feilaktige
 * import linjen.
 * 
 * Hvis du fortsatt skulle f� feil, pr�ve f�lgende som ofte hjelper. H�yreklikke
 * p� prosjektet ditt, velg Maven -> Update Project...
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
