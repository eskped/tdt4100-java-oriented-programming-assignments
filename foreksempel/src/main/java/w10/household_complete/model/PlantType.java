package w10.household_complete.model;

public enum PlantType {
	// trenger veldig lite vann
	KAKTUS(20, "Kaktus"),
	// trenger lite vann
	ALOEVERA(35, "Aloevera"),
	// trenger middels vann
	BONSAIFIKEN(50, "Bonsaifiken"),
	// trenger mye vann
	DVERGFJÆRPALME(80, "Dvergfjærpalme");
	
	public static final int AVERAGE_WEEKLY_WATER_USAGE = 50;
		
	private int waterNeeds = 0; // 0..100
	
	private String textual;
	
	private PlantType(int waterNeeds, String textual) {
		this.waterNeeds = waterNeeds;
		this.textual = textual;
	}

	public int getWeeklyWaterNeeds() {
		return waterNeeds;
	}
	
	@Override
	public String toString() {
		return textual;
	}
}
