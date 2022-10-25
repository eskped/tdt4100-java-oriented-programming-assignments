package w14.observer.complete;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
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
public class MyObserver implements PropertyChangeListener {
	private String observerName;

	public MyObserver(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(
				String.format("[%s] => (last) '%s' vs. (new) '%s'", observerName, evt.getOldValue(), evt.getNewValue()));
	}
}
