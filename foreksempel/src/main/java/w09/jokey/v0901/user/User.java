package w09.jokey.v0901.user;

import w09.jokey.v0901.core.IJokeyIdentifier;
import w09.jokey.v0901.core.JokeyIdentifierHelper;

/**
 * En brukerklasse som har informasjon om brukeren.
 * 
 * @author steinlt
 *
 */
/*
 * Brukeren har et unikt brukernavn, enkelt og greit så lenge det bare er en
 * bruker, men etter hvert skal vi kunne ha flere brukere. Hvordan gjør vi det
 * da? Den unike brukeridentifikatoren kan brukes til å holde styr på data
 * relatert til brukeren, men hva hvis vi ønsker at bruker kan endre brukernavn?
 * Ulike utfordringer vi skal se på etter hvert. Kan den nye
 * interfacet/grensesnittet IJokeyIdentifier også benyttes her? Hva er ditt
 * forslag til endring? Hint, se litt på hvordan det kan gjøres slik som i
 * Joke-klassen.
 */
public class User implements IJokeyIdentifier {
	/**
	 * Standard navnerom for en bruker hvis ikke annet er spesifisert.
	 */
	public static final String DEFAULT_USER_IDENTIFIER_NAMESPACE = "user";

	/**
	 * Identifikator for brukeren
	 */
	private final String identifier;
	/**
	 * Et unikt brukernavn som identifiserer brukeren
	 */
	private String userName;
	/**
	 * Litt informasjon om selve brukeren, feks navn.
	 */
	private UserProfile userProfile;
	/**
	 * Data som samles om brukeren, feks hvilke vitser hen liker, har set, ol.
	 */
	private UserData userData;

	/**
	 * Oppretter en bruker som må ha et gyldig brukernavn. Brukeren får tildelt en
	 * brukeridentifikator med navnerom spesifisert av {@code DEFAULT_USER_IDENTIFIER_NAMESPACE}.
	 * 
	 * @param userName et gyldig brukernavn som ikke er null eller blank og består
	 *                 av minst 3 tegn
	 * @throws IllegalArgumentException hvis userName er null, blank eller kortere
	 *                                  enn 3 tegn, eller hvis jokeyIdentifier er
	 *                                  null eller blank
	 */
	public User(String userName) {
		this(userName, null, null, JokeyIdentifierHelper.create(DEFAULT_USER_IDENTIFIER_NAMESPACE));
	}

	/**
	 * Oppretter en bruker som må ha et gyldig brukernavn.
	 * 
	 * @param userName        et gyldig brukernavn som ikke er null eller blank og
	 *                        består av minst 3 tegn
	 * @param jokeyIdentifier en identifikator som unikt identifiserer brukeren
	 * @throws IllegalArgumentException hvis userName er null, blank eller kortere
	 *                                  enn 3 tegn, eller hvis jokeyIdentifier er
	 *                                  null eller blank
	 */
	public User(String userName, String jokeyIdentifier) {
		this(userName, null, null, jokeyIdentifier);
	}

	/**
	 * Oppretter en bruker som må ha et gyldig brukernavn.
	 * 
	 * @param userName        et gyldig brukernavn som ikke er null eller blank og
	 *                        består av minst 3 tegn
	 * @param givenName       fornavn eller blank/null
	 * @param familyName      etternavn eller blank/null
	 * @param jokeyIdentifier en identifikator som unikt identifiserer brukeren
	 * @throws IllegalArgumentException hvis userName er null, blank eller kortere
	 *                                  enn 3 tegn, eller hvis jokeyIdentifier er
	 *                                  null eller blank
	 */
	public User(String userName, String givenName, String familyName, String jokeyIdentifier) {
		if (jokeyIdentifier == null || jokeyIdentifier.isBlank())
			throw new IllegalArgumentException("jokeyIdentifier kan ikke være null eller blank");
		if (userName == null || userName.trim().length() < 3)
			throw new IllegalArgumentException("userName kan ikke være null, blank eller kortere enn 3 tegn");
		/*
		 * string.trim() fjerner blanke tegn fra starten og fra slutten av en streng,
		 * mens andre blank tegn i selve strengen blir opprettholdt
		 */
		this.identifier = jokeyIdentifier;
		this.userName = userName.trim();
		userProfile = new UserProfile(givenName, familyName);
		userData = new UserData();
	}

	/**
	 * Henter brukernavn til brukeren
	 * 
	 * @return brukernavnet til brukeren
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Henter brukerprofilen til brukeren
	 * 
	 * @return brukerprofilen til brukeren
	 */
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * Henter brukerdataene til brukeren
	 * 
	 * @return brukerdataene til brukeren
	 */
	public UserData getUserData() {
		return userData;
	}

	@Override
	public IJokeyIdentifier getIdentifier() {
		return this;
	}

	@Override
	public String getIdentifierAsString() {
		return identifier;
	}

	@Override
	public boolean sameIdentifier(IJokeyIdentifier otherIdentifier) {
		return JokeyIdentifierHelper.equals(this, otherIdentifier);
	}
}
