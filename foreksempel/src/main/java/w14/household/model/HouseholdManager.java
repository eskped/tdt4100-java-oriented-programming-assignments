package w14.household.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class HouseholdManager implements Iterable<LivingThing>, Serializable {
	private static final long serialVersionUID = 1L;
	public static final String HOUSEHOLD_MEMBER_STATE_CHANGE = "household_member_state_change";
	private HashSet<LivingThing> household = new HashSet<>();
	private PropertyChangeSupport hcs = new PropertyChangeSupport(this);

	@Override
	public Iterator<LivingThing> iterator() {
		return household.iterator();
	}

	public LivingThing getMember(String name) {
		for (var item : household)
			if (item.getName().equals(name))
				return item;
		return null;
	}

	public boolean hasMember(String name) {
		return getMember(name) != null;
	}

	public boolean addMember(LivingThing member) {
		if (member != null && !hasMember(member.getName()))
			return household.add(member);
		return false;
	}

	public boolean removeMember(LivingThing member) {
		return household.remove(member);
	}
	
	public void removeAllMembers() {
		household.clear();
	}

	public void mergeMembers(HouseholdManager anotherHouseholdManager) {
		if (anotherHouseholdManager != null) {
			Iterator<LivingThing> members = anotherHouseholdManager.iterator();
			while (members.hasNext()) {
				LivingThing member = (LivingThing) members.next();
				addMember(member);
			}
		}
	}

	private HouseholdManager() {
	}

	/**
	 * Her bruker vi et såkalt Singleton Pattern
	 * (https://en.wikipedia.org/wiki/Singleton_pattern) for å sikre at vi bare får
	 * en instans av en klasse. Det finnes mange ulike patterns, men det å lage en
	 * helper-klasse er ganske vanlig da den er både thread-safe (sikker med tanke
	 * på flertrådkjøring) samt at den ikke lastest før det faktisk blir gjort en
	 * forespørsel (mao vi sparer eventuelt minne hvis den ikke skulle bli kjørt).
	 */
	private static class SingletonHelper {
		private static final HouseholdManager INSTANCE = new HouseholdManager();
	}

	/**
	 * Returnerer en instans av HouseholdManager.
	 * 
	 * @return instansen av HouseholdManager
	 */
	public static HouseholdManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void printHouseholdMembers() {
		Iterator<LivingThing> members = iterator();
		while (members.hasNext())
			System.out.println(members.next());
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		hcs.addPropertyChangeListener(pcl);
	}

	public void firePropertyChange(LivingThing memberChanged) {
		hcs.firePropertyChange(HOUSEHOLD_MEMBER_STATE_CHANGE, null, memberChanged);
	}
}
