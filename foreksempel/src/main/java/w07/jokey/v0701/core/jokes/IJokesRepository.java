package w07.jokey.v0701.core.jokes;

import java.net.URL;

import w07.jokey.v0701.core.IJokeyIdentifier;

/**
 * Et interface/grensesnitt som benyttes for å beskrive en kilde til vitser.
 * 
 * @author steinlt
 *
 */
public interface IJokesRepository extends IJokeyIdentifier, IJokes {
	/**
	 * Navnet på kilden 
	 * @return navnet på kilden
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
