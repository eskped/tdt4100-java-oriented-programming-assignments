package w05.person_v2;

public class Person1 extends Person {
	private String givenName, familyName;

	public Person1(String givenName, String familyName, int id) {
		super(id);
		this.givenName = givenName;
		this.familyName = familyName;
	}
	
	@Override
	public String getGivenName() {
		return this.givenName;
	}

	@Override
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Override
	public String getFamilyName() {
		return this.familyName;
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Override
	public String getFullName() {
		return this.givenName + " " + this.familyName;
	}

	@Override
	public void setFullName(String fullName) {
		int pos = fullName.indexOf(' ');
		this.givenName = fullName.substring(0, pos);
		this.familyName = fullName.substring(pos + 1);
	}
	
	public String getPerson1ClassInfo() {
		return this.getClass().getName();
	}
}
