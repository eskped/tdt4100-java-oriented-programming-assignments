package w06.jokey.v0601.user;

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
