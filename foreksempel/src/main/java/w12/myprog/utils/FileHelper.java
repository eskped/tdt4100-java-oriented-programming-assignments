package w12.myprog.utils;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {
	/**
	 * Oppretter sti og fil hvis de/den ikke finnes.
	 * 
	 * @param file antar at siste navn etter stideler er filnavnet
	 * @return {@code true} hvis sti og fil er opprettet eller eksisterer, ellers
	 *         {@code false}
	 */
	public static boolean createNewFile(Path file) {
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
