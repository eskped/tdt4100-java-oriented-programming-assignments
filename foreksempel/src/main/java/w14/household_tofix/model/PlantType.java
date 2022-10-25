package w14.household_tofix.model;

public enum PlantType {
	// trenger veldig lite vann
	KAKTUS(1, "Kaktus"),
	// trenger lite vann
	ALOEVERA(35, "Aloevera"),
	// trenger middels vann
	BONSAIFIKEN(50, "Bonsaifiken"),
	// trenger mye vann
	DVERGFJÆRPALME(80, "Dvergfjærpalme");
	
	private int waterNeedsPerDayInMl = 0;
	
	private String textual;
	
	private PlantType(int waterNeedsPerDayInMl, String textual) {
		this.waterNeedsPerDayInMl = waterNeedsPerDayInMl;
		this.textual = textual;
	}

	public int getWaterNeedsPerDayInMl() {
		return waterNeedsPerDayInMl;
	}
	
	@Override
	public String toString() {
		return textual;
	}
}
