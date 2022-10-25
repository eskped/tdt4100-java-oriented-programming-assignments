package w12.myprog.arv;

import java.io.IOException;

public class Cycling extends TaskBase<Cycling.TripRecord> {
	public Cycling() {
		try {
			readFromFile();
		} catch (Exception e) {
			System.out.println("Ingen data fra cycling.csv");
		}
	}

	public float calculateTotalDistance() {
		return calculate(d -> d.distance);
	}

	private void readFromFile() throws IOException {
		readFromFile("cycling.csv", x -> {
			var record = new TripRecord(x.split("\t"));
			add(record.to, record);
		});
	}
	
	/**
	 * Det var spørsmål om hvordan skrive til en csv fil. Her er et eksempel på det.
	 * Siden du ikke kan skrive til en resursfil, så er dette eksemlpet gjort om
	 * litt i forhold til readFromFile ved å benytte en fil i din tdt4100 katalog.
	 */
	public boolean writeToFile() throws IOException {
		return writeToFile("cycling-arv.csv", x -> {
			return String.format("%s\t%s\t%s\n", x.from, x.to, x.distance);
		});
	}

	static class TripRecord {
		String from;
		String to;
		float distance;

		public TripRecord(String[] tripItems) {
			this.from = tripItems[0];
			this.to = tripItems[1];
			this.distance = Float.parseFloat(tripItems[2]);
		}

		@Override
		public String toString() {
			return String.format("Fra %s til %s, %.0fkm", from, to, distance);
		}
	}
}
