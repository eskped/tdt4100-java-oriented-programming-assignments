package w14.household_tofix.simulator;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BinaryOperator;

import w14.household_tofix.model.HouseholdManager;
import w14.household_tofix.model.LivingThing;

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
		while (isAlive()) {
			try {
				HouseholdManager hm = HouseholdManager.getInstance();
				if (hm != null) {
					Iterator<LivingThing> members = hm.iterator();

					while (members.hasNext()) {
						var member = (LivingThing) members.next();
						member.updateState(simulatorMultiplier);
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
