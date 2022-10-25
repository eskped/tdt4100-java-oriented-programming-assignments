package w14.household.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class LivingThing implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String name;
	private LocalDateTime lastCare;
	private LivingState state;	
	private float stateScore = 0f;

	public LivingThing(String name) {
		setName(name);
		setState(LivingState.UNKNOWN);
	}

	public String getName() {
		return name;
	}

	/*
	 * For å sikre konsistense tillates det ikke at en kan endre navn i ettertid.
	 */
	private void setName(String name) {
		if (name == null || name.isBlank())
			throw new NullPointerException("Navnet kan ikke være blankt");
		
		this.name = name;
	}
	
	public LivingState getState() {
		return state;
	}
	
	void setState(LivingState state) {
		this.state = state;
	}
	
	public float getStateScore() {
		return stateScore;
	}
	
	void setStateScore(float score) {
		if (score < 0f)
			stateScore = 0f;
		else if (score > 1f)
			stateScore = 1f;
		else
			stateScore = score;
	}
	
	/**
	 * Updates the state based on real time
	 */
	public void updateState() {
		updateState(1);
	};
	
	public LocalDateTime getLastCare() {
		return lastCare;
	}
	
	void setLastCare(LocalDateTime date) {
		if (date != null )
			lastCare = date;
	}

	void setLastCareNow() {
		lastCare = LocalDateTime.now();
	}
		
	abstract public void doCare();
	
	abstract public void updateState(int speedMultiplier);
}
