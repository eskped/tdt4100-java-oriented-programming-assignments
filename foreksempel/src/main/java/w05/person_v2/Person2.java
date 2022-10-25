package w05.person_v2;

public class Person2 extends Person {
	private String fullName;

	public Person2(String fullName, int id) {
		super(id);
		this.fullName = fullName;
	}

	@Override
	public String getGivenName() {
		return this.fullName.substring(0, this.fullName.indexOf(' '));
	}

	@Override
	public void setGivenName(String givenName) {
		this.fullName = givenName + " " + getFamilyName();
	}

	@Override
	public String getFamilyName() {
		return this.fullName.substring(this.fullName.indexOf(' ') + 1);
	}

	@Override
	public void setFamilyName(String familyName) {
		this.fullName = getGivenName() + " " + familyName;
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPerson2ClassInfo() {
		return this.getClass().getName();
	}
}
