package w14.household.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Plant extends LivingThing {
	private static final long serialVersionUID = 1L;
	private PlantType plantType;
	private final float TOO_LATE_MULTIPLIER = 16f; // 16 dager
	private final float SOON_DEAD_MULTIPLIER = 12f; // 12 dager
	private final float NEEDS_CARE_MULTIPLIER = 7f; // 7 dager, mao bør få vann minst en gang i uka
	private final float NEEDS_CARE_SOON_MULTIPLIER = 4f; // 4 dager

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
	public void doCare() {
		setState(LivingState.OK);
		setStateScore(1);
		setLastCareNow();
	}

	@Override
	public void updateState(int speedMultiplier) {
		if (getLastCare() == null) {
			setState(LivingState.UNKNOWN);
			setStateScore(0);
		} else {
			Duration sinceLastCare = Duration.between(getLastCare(), LocalDateTime.now());
			long sinceLastCareSimulated = sinceLastCare.getSeconds()
					* (speedMultiplier > 0 ? speedMultiplier : 1);

			if (sinceLastCareSimulated >= 86400f * TOO_LATE_MULTIPLIER) {
				setState(LivingState.TOO_LATE);
				setStateScore(0);
			} else if (sinceLastCareSimulated >= 86400f * SOON_DEAD_MULTIPLIER) {
				setState(LivingState.SOON_DEAD);
				setStateScore(1f - (sinceLastCareSimulated / (86400f * TOO_LATE_MULTIPLIER)));
			} else if (sinceLastCareSimulated >= 86400f * NEEDS_CARE_MULTIPLIER) {
				setState(LivingState.NEEDS_CARE);
				setStateScore(1f - (sinceLastCareSimulated / (86400f * TOO_LATE_MULTIPLIER)));
			} else if (sinceLastCareSimulated >= 86400f * NEEDS_CARE_SOON_MULTIPLIER) {
				setState(LivingState.NEEDS_CARE_SOON);
				setStateScore(1f - (sinceLastCareSimulated / (86400f * TOO_LATE_MULTIPLIER)));
			} else {
				setState(LivingState.OK);
				setStateScore(1f - (sinceLastCareSimulated / (86400f * TOO_LATE_MULTIPLIER)));
			}
		}
	}

	@Override
	public String toString() {
		return String.format("Plant: %s (%s), %s", getName(), getPlantType(), getState());
	}
}
