package w05.person_v2;

import java.util.function.Predicate;

public interface IPerson extends Predicate<IPerson>, Comparable<IPerson> {
	String getGivenName();

	void setGivenName(String givenName);

	String getFamilyName();

	void setFamilyName(String familyName);

	String getFullName();

	void setFullName(String fullName);
	
	int getId();
}