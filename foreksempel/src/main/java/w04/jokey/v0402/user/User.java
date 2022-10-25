package w04.jokey.v0402.user;

/**
 * En brukerklasse som har informasjon om brukeren. Vi starter med litt
 * struktur. Brukeren har et unikt brukernavn, enkelt og greit s� lenge det bare
 * er en bruker, men etter hvert skal vi kunne ha flere brukere. Hvordan gj�r vi
 * det da? Den unike brukeridentifikatoren kan brukes til � holde styr p� data
 * relatert til brukeren, men hva hvis vi �nsker at bruker kan endre brukernavn?
 * Ulike utfordringer vi skal se p� etter hvert.
 * 
 * @author steinlt
 *
 */
/*
 * N� har vi gjort en endring, vi har lagt til sjekk p� brukernavn, og ved feil
 * s� kastes et unntak.
 */
public class User {
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
	 * Oppretter en bruker som m� ha et gyldig brukernavn.
	 * 
	 * @param userName et gyldig brukernavn som ikke er null eller blank og best�r
	 *                 av minst 3 tegn
	 * @throws IllegalArgumentException hvis userName er null, blank eller kortere
	 *                                  enn 3 tegn
	 */
	public User(String userName) {
		this(userName, null, null);
	}

	/**
	 * Oppretter en bruker som m� ha et gyldig brukernavn.
	 * 
	 * @param userName   et gyldig brukernavn som ikke er null eller blank og best�r
	 *                   av minst 3 tegn
	 * @param givenName  fornavn eller blank/null
	 * @param familyName etternavn eller blank/null
	 * @throws IllegalArgumentException hvis userName er null, blank eller kortere
	 *                                  enn 3 tegn
	 */
	public User(String userName, String givenName, String familyName) {
		if (userName == null || userName.trim().length() < 3)
			throw new IllegalArgumentException("userName kan ikke v�re null, blank eller kortere enn 3 tegn");

		/*
		 * string.trim() fjerner blanke tegn fra starten og fra slutten av en streng,
		 * mens andre blank tegn i selve strengen blir opprettholdt
		 */
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
}
