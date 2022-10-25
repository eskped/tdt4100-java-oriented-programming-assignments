package w04;

import junit.framework.TestCase;

public class PersonTest extends TestCase {
	private Person1 person1;
	private Person2 person2;

	@Override
	protected void setUp() throws Exception {
		person1 = new Person1("Ole", "Vik");
		person2 = new Person2("Ole Vik");
	}

	public void testPerson() {
		assertEquals("Ole", person1.getGivenName());
		assertEquals("Vik", person1.getFamilyName());
		assertEquals("Ole Vik", person1.getFullName());

		assertEquals("Ole", person2.getGivenName());
		assertEquals("Vik", person2.getFamilyName());
		assertEquals("Ole Vik", person2.getFullName());
	}

	public void testSetGivenFamilyNames() {
		person1.setGivenName("Jo");
		person1.setFamilyName("Eik");
		assertEquals("Jo", person1.getGivenName());
		assertEquals("Eik", person1.getFamilyName());
		assertEquals("Jo Eik", person1.getFullName());

		person2.setGivenName("Jo");
		person2.setFamilyName("Eik");
		assertEquals("Jo", person2.getGivenName());
		assertEquals("Eik", person2.getFamilyName());
		assertEquals("Jo Eik", person2.getFullName());
	}

	public void testSetFullName() {
		person1.setFullName("Jo Eik");
		assertEquals("Jo", person1.getGivenName());
		assertEquals("Eik", person1.getFamilyName());
		assertEquals("Jo Eik", person1.getFullName());

		person2.setFullName("Jo Eik");
		assertEquals("Jo", person2.getGivenName());
		assertEquals("Eik", person2.getFamilyName());
		assertEquals("Jo Eik", person2.getFullName());
	}
}
