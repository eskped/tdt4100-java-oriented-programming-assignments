package w10.household.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class HouseholdManager  {

	

	private HouseholdManager() {
	}
	
	/**
	 * Her bruker vi et s�kalt Singleton Pattern
	 * (https://en.wikipedia.org/wiki/Singleton_pattern) for � sikre at vi bare f�r
	 * en instans av en klasse. Det finnes mange ulike patterns, men det � lage en
	 * helper-klasse er ganske vanlig da den er b�de thread-safe (sikker med tanke
	 * p� flertr�dkj�ring) samt at den ikke lastest f�r det faktisk blir gjort en
	 * foresp�rsel (mao vi sparer eventuelt minne hvis den ikke skulle bli kj�rt).
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
