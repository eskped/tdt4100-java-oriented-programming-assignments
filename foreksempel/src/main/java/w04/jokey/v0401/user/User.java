package w04.jokey.v0401.user;

/**
 * En brukerklasse som har informasjon om brukeren. Vi starter med litt
 * struktur. Brukeren har et unikt brukernavn, enkelt og greit så lenge det bare
 * er en bruker, men etter hvert skal vi kunne ha flere brukere. Hvordan gjør vi
 * det da? Den unike brukeridentifikatoren kan brukes til å holde styr på data
 * relatert til brukeren, men hva hvis vi ønsker at bruker kan endre brukernavn?
 * Ulike utfordringer vi skal se på etter hvert.
 * 
 * @author steinlt
 *
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

	public User(String userName) {
		this(userName, null, null);
	}

	public User(String userName, String givenName, String familyName) {
		this.userName = userName;
		userProfile = new UserProfile(givenName, familyName);
		userData = new UserData();
	}

	public String getUserName() {
		return userName;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public UserData getUserData() {
		return userData;
	}
}
