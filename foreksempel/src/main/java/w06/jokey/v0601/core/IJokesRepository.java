package w06.jokey.v0601.core;

import java.net.URL;

/**
 * Et interface/grensesnitt som benyttes for � beskrive en kilde til vitser.
 * 
 * @author steinlt
 *
 */
public interface IJokesRepository {
	/**
	 * Navnet p� kilden 
	 * @return navnet p� kilden
	 */
	String getName();
	/**
	 * En kort beskrivelse av kilden
	 * @return beskrivelsen av kilden, eventuelt {@code null} hvis det ikke er relevant
	 */
	String getDescription();
	/**
	 * Kreditering av kilden
	 * @return kreditering av kilden, eventuelt {@code null} hvis det ikke er relevant
	 */
	String getCredits();
	/**
	 * Juridisk informasjon hvis det er relevant for kilden
	 * @return juridisk informasjon, eventuelt {@code null} hvis det ikke er relevant
	 */
	String getLegalDisclaimer();
	/**
	 * Lenke til kildens nettside, hvis det er relevant
	 * @return lenken til kildes nettside, eventuelt {@code null} hvis det ikke er relevant
	 */
	URL getUrl();
}
