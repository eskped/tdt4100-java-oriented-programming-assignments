package w10.household.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class HouseholdManager  {

	

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
}
