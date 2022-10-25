package w10.household.model;

public class Pet extends LivingThing {
	private static final long serialVersionUID = 1L;
	private PetType petType;

	public Pet(PetType petType, String name) {
		super(name);
		setPetType(petType);
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public void doCare(int degreeOfCare) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return String.format("Pet: %s (%s), %s", getName(), getPetType(), getState());
	}
}
