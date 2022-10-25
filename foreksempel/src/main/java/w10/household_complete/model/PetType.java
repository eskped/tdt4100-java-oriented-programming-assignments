package w10.household_complete.model;

public enum PetType {
	// trenger liten mengde mat
	CHIHUAHUA(15, "Chihuahua"),
	COCKER_SPANIEL(35, "Cocker Spaniel"),
	// trenger middels mengde mat
	IRISH_SETTER(50, "Irish Setter"),
	// trenger stor mengde mat
	IRISH_WOLFHOUND(90, "Irish Wolfhound");
	
	public static final int AVERAGE_WEEKLY_FOOD_USAGE = 50;
	
	private int foodNeeds = 0; // 0..100
	private String textual;
	
	private PetType(int foodNeeds, String textual) {
		this.foodNeeds = foodNeeds;
		this.textual = textual;
	}

	public int getFoodNeeds() {
		return foodNeeds;
	}
	
	@Override
	public String toString() {
		return textual;
	}
}
