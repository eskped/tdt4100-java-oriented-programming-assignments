package w10.household_complete.model;

public class Plant extends LivingThing {
	private static final long serialVersionUID = 1L;	
	private PlantType plantType;

	public Plant(PlantType plantType, String name) {
		super(name);
		setPlantType(plantType);
	}

	public PlantType getPlantType() {
		return plantType;
	}

	public void setPlantType(PlantType plantType) {
		this.plantType = plantType;
	}

	@Override
	public void doCare(int degreeOfCare) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return String.format("Plant: %s (%s), %s", getName(), getPlantType(), getState());
	}
}
