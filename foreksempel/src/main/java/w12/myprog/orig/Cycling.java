package w12.myprog.orig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import w12.myprog.MyProg;
import w12.myprog.utils.FileHelper;

public class Cycling {
	// format key=[to], value=[list of trips]
	private HashMap<String, ArrayList<TripRecord>> trips = new HashMap<String, ArrayList<TripRecord>>();

	public Cycling() {
		try {
			readFromFile();
		} catch (Exception e) {
			System.out.println("Ingen data fra cycling.csv");
		}
	}

	public float calculateTotalDistance() {
		var keys = trips.keySet();
		float total = 0f;
		for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
			var key = keysIterator.next();
			var records = trips.get(key);
			if (records != null)
				total += records.stream().mapToDouble(d -> d.distance).sum();
		}
		return total;
	}

	private void readFromFile() throws IOException {
		try (Scanner scanner = new Scanner(MyProg.class.getResourceAsStream("cycling.csv"), StandardCharsets.UTF_8)) {
			while (scanner.hasNextLine()) {
				var line = scanner.nextLine().stripTrailing();
				if (line.isEmpty())
					continue;
				else {
					// format [from]\t[to]\t[distance in km]
					var record = new TripRecord(line.split("\t"));
					if (trips.containsKey(record.to))
						trips.get(record.to).add(record);
					else {
						var newList = new ArrayList<Cycling.TripRecord>();
						newList.add(record);
						trips.put(record.to, newList);
					}
				}
			}
		}
	}

	/**
	 * Det var spørsmål om hvordan skrive til en csv fil. Her er et eksempel på det.
	 * Siden du ikke kan skrive til en resursfil, så er dette eksemlpet gjort om
	 * litt i forhold til readFromFile ved å benytte en fil i din tdt4100 katalog.
	 */
	public boolean writeToFile() throws IOException {
		Path filePath = Path.of(System.getProperty("user.home"), "tdt4100", "myprog", "cycling-orig.csv");
		if (FileHelper.createNewFile(filePath)) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile()))) {
				var keys = trips.keySet();
				for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
					var key = keysIterator.next();
					var records = trips.get(key);
					if (records != null) {
						for (Iterator<Cycling.TripRecord> recordsIterator = records.iterator(); recordsIterator
								.hasNext();) {
							Cycling.TripRecord record = recordsIterator.next();
							bw.write(String.format("%s\t%s\t%s\n", record.from, record.to, record.distance));
						}
					}
				}
				bw.flush();
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (trips.size() > 0) {
			var keys = trips.keySet();
			for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
				var key = keysIterator.next();
				var records = trips.get(key);
				if (records != null)
					records.stream().forEach(t -> sb.append(t + "\n"));
			}
		}
		return sb.toString();
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
