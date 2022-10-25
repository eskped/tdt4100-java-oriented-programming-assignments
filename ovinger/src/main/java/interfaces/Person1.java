package interfaces;

public class Person1 implements Named {
	
	String givenName;
	String familyName;
	
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}
	
	@Override
	public void setGivenName(String name) {
		this.givenName = name;
	}

	@Override
	public void setFamilyName(String name) {
		this.familyName = name;
		
	}

	@Override
	public void setFullName(String fullName) {
		String[] names = fullName.split(" ");
		this.givenName = names[0];
		this.familyName = names[1];
		
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public String getFullName() {
		return this.givenName + " " + this.familyName;
	}

}
