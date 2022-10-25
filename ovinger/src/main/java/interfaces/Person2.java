package interfaces;

public class Person2 implements Named{
	
	String fullName;
	
	
	public Person2(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public void setGivenName(String name) {
		this.fullName = name + " " + fullName.split(" ")[1];
	}

	@Override
	public void setFamilyName(String name) {
		this.fullName = fullName.split(" ")[0] + " " +  name;
	}

	@Override
	public void setFullName(String fullNamme) {
		this.fullName = fullNamme;
		
	}

	@Override
	public String getGivenName() {
		return fullName.split(" ")[0];
	}

	@Override
	public String getFamilyName() {
		return fullName.split(" ")[1];
	}

	@Override
	public String getFullName() {
		return fullName;
	}

}
