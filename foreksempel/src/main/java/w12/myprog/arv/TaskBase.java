package w12.myprog.arv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.function.ToDoubleFunction;

import w12.myprog.MyProg;
import w12.myprog.utils.FileHelper;

public class TaskBase<T> {
	private static Path filePath = Path.of(System.getProperty("user.home"), "tdt4100", "myprog");
	private HashMap<String, ArrayList<T>> tasks = new HashMap<String, ArrayList<T>>();

	Set<String> keySet() {
		return tasks.keySet();
	}
	
	int size() {
		return tasks.size();
	}
	
	ArrayList<T> get(String key) {
		return tasks.get(key);
	}
	
	void add(String key, T value) {
		if (tasks.containsKey(key))
			get(key).add(value);
		else {
			var newList = new ArrayList<T>();
			newList.add(value);
			tasks.put(key, newList);
		}
	}

	public float calculate(ToDoubleFunction<T> func) {
		var keys = keySet();
		float total = 0f;
		for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
			var key = keysIterator.next();
			var records = get(key);
			if (records != null)
				total += records.stream().mapToDouble(func).sum();
		}
		return total;
	}
	
	void readFromFile(String filename, TaskOperator taskOperator) throws IOException {
		try (Scanner scanner = new Scanner(MyProg.class.getResourceAsStream(filename), StandardCharsets.UTF_8)) {
			while (scanner.hasNextLine()) {
				var line = scanner.nextLine().stripTrailing();
				if (line.isEmpty())
					continue;
				else
					taskOperator.addTask(line);
			}
		}
	}
	
	/**
	 * Det var spørsmål om hvordan skrive til en csv fil. Her er et eksempel på det.
	 * Siden du ikke kan skrive til en resursfil, så er dette eksemlpet gjort om
	 * litt i forhold til readFromFile ved å benytte en fil i din tdt4100 katalog.
	 */
	boolean writeToFile(String filename, WriteTaskOperator<T> writeTaskOperator) throws IOException {
		if (FileHelper.createNewFile(filePath.resolve(filename))) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.resolve(filename).toFile()))) {
				var keys = keySet();
				for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
					var key = keysIterator.next();
					var records = get(key);
					if (records != null) {
						for (Iterator<T> recordsIterator = records.iterator(); recordsIterator.hasNext();) {
							T record = recordsIterator.next();
							bw.write(writeTaskOperator.formatTask(record));
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
		if (size() > 0) {
			var keys = keySet();
			for (Iterator<String> keysIterator = keys.iterator(); keysIterator.hasNext();) {
				var key = keysIterator.next();
				var records = get(key);
				if (records != null)
					records.stream().forEach(t -> sb.append(t + "\n"));
			}
		}
		return sb.toString();
	}
}
