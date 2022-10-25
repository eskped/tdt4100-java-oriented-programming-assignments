package w05.person_v2;

import java.util.Comparator;

public class PersonFamilyNameComparator implements Comparator<IPerson> {
	@Override
	public int compare(IPerson p1, IPerson p2) {
		String s1 = p1.getFamilyName();
		String s2 = p2.getFamilyName();
		return s1.compareTo(s2);
	}
}
