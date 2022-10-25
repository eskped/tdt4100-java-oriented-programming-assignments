package w09.jokey.v0902.core;

/**
 * Alle Jokey komponenter som benytter en identifikator må implementere dette
 * grensesnittet.
 * 
 * @author steinlt
 *
 */
public interface IJokeyIdentifier {
	/**
	 * Henter Jokey identifikatoren for objektet som en tekststreng
	 * 
	 * @return Jokey-identifikatoren som en tekststreng
	 */
	String getIdentifierAsString();

	/**
	 * Henter Jokey identifikatoren for objektet
	 * 
	 * @return Jokey-identifikatoren
	 */
	IJokeyIdentifier getIdentifier();

	/**
	 * Tester om to identifikatorer er like
	 * 
	 * @param otherIdentifier identifikoren til å test imot
	 * @return {@code true} hvis de er like, ellers {@code false}
	 */
	boolean sameIdentifier(IJokeyIdentifier otherIdentifier);
}
