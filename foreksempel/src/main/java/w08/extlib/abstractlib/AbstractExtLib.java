package w08.extlib.abstractlib;

public abstract class AbstractExtLib {
	public abstract String getContent();

	/*
	 * Hva skjer om vi legger til denne metoden? Ingenting for de som arver fra
	 * denne klassen. Dette gir en grad av fleksibilitet med tanke p� endringer av
	 * klassen etter hvert.
	 */
//	public boolean hasContent() {
//		return getContent() != null && !getContent().isBlank();
//	}
}
