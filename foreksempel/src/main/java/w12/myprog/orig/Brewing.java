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

public class Brewing {
	// format key=[name], value=[list of brews]
	private HashMap<String, ArrayList<BrewRecord>> brews = new HashMap<String, ArrayList<BrewRecord>>();

	public Brewing() {
		try {
			load();
		} catch (Exception e) {
			System.out.println("Ingen data fra brewing.csv");
		}
	}

	public float getLiters() {
		var keys = brews.keySet();
		float total = 0f;
		for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
			var key = keysIterator.next();
			var records = brews.get(key);
			if (records != null)
				total += records.stream().mapToDouble(d -> d.liters).sum();
		}
		return total;
	}

	private void load() throws IOException {
		try (Scanner scanner = new Scanner(MyProg.class.getResourceAsStream("brewing.csv"), StandardCharsets.UTF_8)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().stripTrailing();
				if (line.isEmpty())
					continue;
				else {
					// format [name];[liters];[brew type]
					// IPA;17.5;Code of honor
					var record = new BrewRecord(line.split(";"));
					if (brews.containsKey(record.name))
						brews.get(record.name).add(record);
					else {
						var newList = new ArrayList<BrewRecord>();
						newList.add(record);
						brews.put(record.name, newList);
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
	public boolean write() throws IOException {
		Path filePath = Path.of(System.getProperty("user.home"), "tdt4100", "myprog", "brewing-orig.csv");
		if (FileHelper.createNewFile(filePath)) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile()))) {
				var keys = brews.keySet();
				for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
					var key = keysIterator.next();
					var records = brews.get(key);
					if (records != null) {
						for (Iterator<Brewing.BrewRecord> recordsIterator = records.iterator(); recordsIterator
								.hasNext();) {
							Brewing.BrewRecord record = recordsIterator.next();
							bw.write(String.format("%s\t%s\t%s\n", record.brewType, record.liters, record.name));
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
		if (brews.size() > 0) {
			var keys = brews.keySet();
			for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
				var key = keysIterator.next();
				var records = brews.get(key);
				if (records != null)
					records.stream().forEach(t -> sb.append(t + "\n"));
			}
		}
		return sb.toString();
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
