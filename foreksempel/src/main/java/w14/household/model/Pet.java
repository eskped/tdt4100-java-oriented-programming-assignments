package w14.household.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Pet extends LivingThing {
	private static final long serialVersionUID = 1L;
	private PetType petType;
	private final float TOO_LATE_MULTIPLIER = 14f; // 14 dager
	private final float SOON_DEAD_MULTIPLIER = 8f; // 8 dager
	private final float NEEDS_CARE_MULTIPLIER = 0.5f; // 1/2 dag, mao bør få mat 2 ganger hver dag
	private final float NEEDS_CARE_SOON_MULTIPLIER = 0.3f;

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
			long sinceLastCareSimulated = sinceLastCare.getSeconds() * (speedMultiplier > 0 ? speedMultiplier : 1);

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
		return String.format("Pet: %s (%s), %s", getName(), getPetType(), getState());
	}
}
