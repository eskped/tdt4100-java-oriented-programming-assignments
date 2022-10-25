package w10.household_complete.model;

public enum LivingState {
	UNKNOWN,
	OK,
	NEEDS_CARE,
	SOON_DEAD,
	TOO_LATE;
	
	@Override
	public String toString() {
		return (name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase()).replace('_', ' ');
	}
}
