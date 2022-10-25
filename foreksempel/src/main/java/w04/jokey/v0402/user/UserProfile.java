package w04.jokey.v0402.user;

/**
 * Litt brukerinformasjon (rett og slett en kopi av w04.Person1 klassen).
 * 
 * @author steinlt
 *
 */
/*
 * Forel�pig blir ikke denne brukt, men vi kommer til � bruke denne etter hvert
 * da vi skal ha et grafisk grensesnitt. S� litt overkill akuratt n�, men enkelt
 * siden dette bare er en kopi av w04.Person1 klassen i denne omgang.
 */

public class UserProfile {
	private String givenName, familyName;

	public UserProfile(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFullName() {
		return givenName + " " + familyName;
	}
}
