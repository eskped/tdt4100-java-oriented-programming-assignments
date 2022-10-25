package w14.household.model;

public enum PetType {
	// trenger liten mengde mat
	CHIHUAHUA(15, "Chihuahua"),
	COCKER_SPANIEL(35, "Cocker Spaniel"),
	// trenger middels mengde mat
	IRISH_SETTER(50, "Irish Setter"),
	// trenger stor mengde mat
	IRISH_WOLFHOUND(90, "Irish Wolfhound");
	
	private int foodNeedsPerDayInGram = 0;
	private String textual;
	
	private PetType(int foodNeedsPerDayInGram, String textual) {
		this.foodNeedsPerDayInGram = foodNeedsPerDayInGram;
		this.textual = textual;
	}

	public int getFoodNeedsPerDayInGram() {
		return foodNeedsPerDayInGram;
	}
	
	@Override
	public String toString() {
		return textual;
	}
}
