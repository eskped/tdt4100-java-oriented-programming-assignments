package w14.household_tofix.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import w14.household_tofix.model.HouseholdManager;

public class StorageManager {
	private static Path filePath = Path.of(System.getProperty("user.home"), "tdt4100", "household", "household.ser");

	public static boolean writeToFile(HouseholdManager household) {
		if (StorageManager.createNewFile(StorageManager.filePath)) {
			try (FileOutputStream fos = new FileOutputStream(StorageManager.filePath.toFile());
					ObjectOutputStream oos = new ObjectOutputStream(fos);) {
				oos.writeObject(household);
				oos.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static HouseholdManager readFromFile() {
		try (FileInputStream fis = new FileInputStream(StorageManager.filePath.toFile());
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			return (HouseholdManager) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Oppretter sti og fil hvis de/den ikke finnes.
	 * 
	 * @param file antar at siste navn etter stideler er filnavnet
	 * @return {@code true} hvis sti og fil er opprettet eller eksisterer, ellers
	 *         {@code false}
	 */
	private static boolean createNewFile(Path file) {
		try {
			Files.createDirectory(file.getParent());
			File f = new File(file.toString());
			f.createNewFile();
			return true;
		} catch (FileAlreadyExistsException e) {
			try {
				File f = new File(file.toString());
				f.createNewFile();
				return true;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
