package w12.myprog.delegering;

import java.io.IOException;

public class Brewing {
	private TaskHelper<Brewing.BrewRecord> tasks = new TaskHelper<Brewing.BrewRecord>();

	public Brewing() {
		try {
			load();
		} catch (Exception e) {
			System.out.println("Ingen data fra brewing.csv");
		}
	}

	public float getLiters() {
		return tasks.calculate(d -> d.liters);
	}

	private void load() throws IOException {
		tasks.readFromFile("brewing.csv", x -> {
			var record = new BrewRecord(x.split(";"));
			tasks.add(record.name, record);
		});
	}

	/**
	 * Det var spørsmål om hvordan skrive til en csv fil. Her er et eksempel på det.
	 * Siden du ikke kan skrive til en resursfil, så er dette eksemlpet gjort om
	 * litt i forhold til readFromFile ved å benytte en fil i din tdt4100 katalog.
	 */
	public boolean write() throws IOException {
		return tasks.writeToFile("brewing-delegering.csv", x -> {
			return String.format("%s;%s;%s\n", x.brewType, x.liters, x.name);
		});
	}

	@Override
	public String toString() {
		return tasks.toString();
	}

	static class BrewRecord {
		String brewType;
		float liters;
		String name;

		public BrewRecord(String[] brewInfo) {
			this.brewType = brewInfo[0];
			this.liters = Float.parseFloat(brewInfo[1]);
			this.name = brewInfo[2];
		}

		@Override
		public String toString() {
			return String.format("Navn: %s | øltype: %s | liter: %.1fl", name, brewType, liters);
		}
	}
}
