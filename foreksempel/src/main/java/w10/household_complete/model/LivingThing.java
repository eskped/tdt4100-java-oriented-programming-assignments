package w10.household_complete.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class LivingThing implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String name;
	private LocalDateTime lastCare = LocalDateTime.now();
	private LivingState state = LivingState.UNKNOWN;

	public LivingThing(String name) {
		setName(name);
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

	public void setState(LivingState state) {
		this.state = state;
	}
	
	public LocalDateTime getLastCare() {
		return lastCare;
	}
	
	public void setLastCare(LocalDateTime date) {
		if (date != null )
			lastCare = date;
	}

	public void setLastCareNow() {
		lastCare = LocalDateTime.now();
	}
		
	/**
	 * 
	 * @param degreeOfCare en verdi mellom 0 og 100
	 */
	abstract public void doCare(int degreeOfCare);	
}
