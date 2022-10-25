package w05.person_v1;

public interface IPerson {
	String getGivenName();

	void setGivenName(String givenName);

	String getFamilyName();

	void setFamilyName(String familyName);

	String getFullName();

	void setFullName(String fullName);
	
	int getId();
}