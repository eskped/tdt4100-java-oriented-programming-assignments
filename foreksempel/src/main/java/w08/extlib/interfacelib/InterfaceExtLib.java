package w08.extlib.interfacelib;

public interface InterfaceExtLib {
	String getContent();

	/*
	 * Hva skjer hvis vi legger til denne metoden. Jo alle klasser som implementerer
	 * dette interfacet m� ogs� implementere denne metoden. Dette er en stor ulempe
	 * ved interface at endringer vil medf�re enringer av alle implementerende
	 * klasser, ogs� selvom de ikke benytter denne nye metoden.
	 */
//	boolean hasContent();

	/*
	 * Men ved bruk av n�kkelordet default kan en lage en implementasjon som KAN
	 * overrides hvis �nskelig. Det fine med dette er at dette ikke vil kreve
	 * implementasjonsendringer av implementerende klasser. Denne muligheten kom med
	 * Java 8.
	 */
//	default boolean hasContent() {
//		return getContent() != null && !getContent().isBlank();
//	};

	/*
	 * Alternativt er � benytte n�kkelordet static, men disse kan ikke overrides og
	 * kan heller ikke referere til andre ikke static metoder
	 */
}
