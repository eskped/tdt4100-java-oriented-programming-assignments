package objectstructures;

import java.util.ArrayList;


public class Person {
	String name;
	char gender;
	Person mother;
	Person father;
	ArrayList<Person> children = new ArrayList<>();
	
	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
		this.father = null;
		this.mother = null;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name;
				//"\tMor:" + this.mother.name + "\tFar:" + this.father;
	}
	
	public String getName() {
		if(this.name == null) {
			return null;
		}
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public Person getChild(int n) {
		if(n < 0 || n > this.children.size()-1) {
			throw new IllegalArgumentException("Oppgi riktig nummer");
		}
		return this.children.get(n);
	}
	
	public void addChild(Person child) {
		checkEqualPersons(this, child);
		
		if (!children.contains(child)) {
			this.children.add(child);
		}
		
		if(this.gender == 'F') {
			if(child.mother == null) {
				child.setMother(this);
			}
			if(!child.mother.equals(this)) {
				if(child.getMother().children.contains(child)) {
					child.getMother().removeChild(child);
				}
				child.setMother(this);
			}
		} else {
			if(child.father == null) {
				child.setFather(this);
			}
			if(!child.getFather().equals(this)) {
				if(child.getFather().children.contains(child)) {
					child.getFather().removeChild(child);
				}
				child.setFather(this);
			}
		}
	}
	
	
	public void removeChild(Person child) {
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
		
		if (child.mother != null && child.mother.equals(this)) {
			this.mother = null;
		}
		if (child.father != null && child.father.equals(this)) {
			this.father = null;
		}
	}
	
	public void setMother(Person mother) {
		checkEqualPersons(this, mother);
		if (mother.gender == 'M' ) {
			throw new IllegalArgumentException("Det er feil");
		}
		
		if(this.mother == null) {
			this.mother = mother;
		}
		
		if (!this.mother.equals(mother)) {
			if(this.getMother().children.contains(this)) {
				this.getMother().removeChild(this);
			}
			this.mother = mother;
		}
		
		if(!mother.children.contains(this)) {
			mother.addChild(this);
		}
	}
	
	public void setFather(Person father) {
		checkEqualPersons(this, father);

		if (father.gender == 'F' ) {
			throw new IllegalArgumentException("Det er feil");
		}
		if(this.father == null) {
			this.father = father;
		}
		
		if (!this.father.equals(father)) {
			if(this.getFather().children.contains(this)) {
				this.getFather().removeChild(this);
			}
			this.father = father;
		}
		
		if(!father.children.contains(this)) {
			father.addChild(this);
		}
	}
	
	private void checkEqualPersons(Person person1, Person person2) {
		if (person1.equals(person2)) {
			throw new IllegalArgumentException("To personer kan ikke være like");
		}
	}
	
	public static void main(String[] args) {
		Person marit = new Person("Marit", 'F');
		Person jens = new Person("Jens", 'M');
		Person anne = new Person("Anne", 'F');
		
		jens.setMother(anne);
		System.out.println(jens.getMother());
		System.out.println(anne.children);

		jens.setMother(marit);
		System.out.println(jens.getMother());
		System.out.println(marit.children);
		System.out.println(anne.getChildCount());
		
	}
}
