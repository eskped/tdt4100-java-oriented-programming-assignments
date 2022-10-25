package w14.household.simulator;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BinaryOperator;

import w14.household.model.HouseholdManager;
import w14.household.model.LivingThing;

public class HousholdSimulator extends Thread {
	private int sleepTimeInMs = 30000;
	private int simulatorMultiplier = 24; // multiplicator, where 1 is real time

	/**
	 * @param checkEvery          must be more than 0s or else set to default being
	 *                            30s
	 * @param simulatorMultiplier must be more than 0 or else set to default being
	 *                            24 (ie. 24h in 1h)
	 */
	public HousholdSimulator(int checkEvery, int simulatorMultiplier) {
		if (checkEvery > 1)
			sleepTimeInMs = checkEvery * 1000;
		if (simulatorMultiplier > 0)
			this.simulatorMultiplier = simulatorMultiplier;

		setDaemon(true);
	}

	@Override
	public void run() {
		// eks på bruk av BinaryOperator
		Comparator<LivingThing> careTimeComparator = (a, b) -> a.getLastCare().compareTo(b.getLastCare());
		BinaryOperator<LivingThing> minCaredFor = BinaryOperator.minBy(careTimeComparator);
		BinaryOperator<LivingThing> maxCaredFor = BinaryOperator.maxBy(careTimeComparator);

		while (isAlive()) {
			try {
				HouseholdManager hm = HouseholdManager.getInstance();
				if (hm != null) {
					LivingThing longestCaredFor = null;
					LivingThing latestCaredFor = null;
					Iterator<LivingThing> members = hm.iterator();

					while (members.hasNext()) {
						/*
						 * For at vi skal kunne se "progresjonen" via statusbar i GUI må vi få
						 * notifikasjon om hver oppdatering, derfor kommenterer vi ut det å sjekke om
						 * det er en forandring av state. Med det får vi en animasjon av progresjonen i
						 * GUIet.
						 */
						var member = (LivingThing) members.next();
						// var oldState = member.getState();
						member.updateState(simulatorMultiplier);
						// var newState = member.getState();
						// if (oldState != newState)
						hm.firePropertyChange(member);

						if (member.getLastCare() != null) {
							if (longestCaredFor == null && latestCaredFor == null) {
								longestCaredFor = member;
								latestCaredFor = member;
							} else {
								longestCaredFor = minCaredFor.apply(longestCaredFor, member);
								latestCaredFor = maxCaredFor.apply(latestCaredFor, member);
							}
						}
					}

					if (longestCaredFor != null && latestCaredFor != null) {
						DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
						System.out.println(String.format("Cared for since:\n\tLongest: '%s' (%s)\n\tLatest: '%s' (%s)",
								longestCaredFor.getName(), longestCaredFor.getLastCare().format(dateFormatter),
								latestCaredFor.getName(), latestCaredFor.getLastCare().format(dateFormatter)));
					}
				}
				System.err.println(".");
				Thread.sleep(sleepTimeInMs);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
