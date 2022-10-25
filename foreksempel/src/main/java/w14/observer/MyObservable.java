package w14.observer;

/**
 * Her viser vi observat�r-observert-samspill, men det mangler noe kode men det
 * skal vi fikse i lag.
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
