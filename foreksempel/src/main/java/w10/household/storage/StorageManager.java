package w10.household.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import w10.household.model.HouseholdManager;

public class StorageManager {
	private static Path filePath = Path.of(System.getProperty("user.home"), "tdt4100", "household", "household.ser");

	public static boolean writeToFile(HouseholdManager household) {

		return false;
	}

	public static HouseholdManager readFromFile() {

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

		return false;
	}
}
