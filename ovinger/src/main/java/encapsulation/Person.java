package encapsulation;

import java.util.Date;

public class Person {
	String name; //fornavn og etternavn, ingen mellomnavn
	//To bokstaver lang hver
	//Skilt med ett mellomromg, og kun bokstaver
	String email; 
	//E-post-adressen (hvis den ikke er null), skal være fornavn.etternavn@domene.landskode
	//f.eks. hallvard.trætteberg@ntnu.no.
	Date birthday;
	//kan ikke være frem i tid
	//På java.util.Date-form
	char gender;
	//Være M, F eller null
	
	int tall;
	Integer Tall1; 
	
	
	
	public void checkName(String name) {
		if (countChar(name,' ') == 1 && name.matches("[a-zA-Z]+")) {
			int index = name.indexOf(' ');
			//if (name.substring(0,index).length() >=2 || name.substring(index,name.length()).length() !>= 2) {
			//	throw new IllegalArgumentException("Du må ha mellomrom");
			}
		}
		//else {
		//	throw new IllegalArgumentException("Du må ha mellomrom");
		//}
	//}
	
	private void checkEmail(String email) {
		//halla
	}

	public int countChar(String str, char c)
	{
	    int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == c)
	            count++;
	    }
	    return count;
	}
	
	public void setName (String name) {
		//sjekke name her
		this.name = name;
	}
	
	
	public void setEmail (String mail) {
		//sjekke mail her
		this.email = mail;
	}
	
	public void setBirthday(Date birthday) {
		//sjekke birthday
		this.birthday = birthday;
	}
	
	public void setGender(char gender) {
		//sjekke gender
		this.gender = gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public String getEmail() {
		return this.getEmail();
	}
	
}

