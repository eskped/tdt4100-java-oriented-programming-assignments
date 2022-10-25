package of13.kode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class SaveHandlerTest {
	
	private Game game;
	private SaveHandler saveHandler = new SaveHandler();
	
	@Test
	public void testLoad() {
		Game savedNewGame = game;
		try {
			savedNewGame = saveHandler.load("test-save");
		} catch (FileNotFoundException e) {
			fail("Could not load from file");
		}
		assertEquals(game.toString(), savedNewGame.toString());
		assertFalse(game.isGameOver());
	}
	
	
	@Test
	public void testLoadNonExsistingFile() {
		assertThrows(
				FileNotFoundException.class, 
				() -> game = saveHandler.load("foo")
		);
	}
	
	@Test
	public void testSave() {
		try {
			saveHandler.save("test-save-new", game);

		} catch (FileNotFoundException e) {
			fail("Coulsd not save file");
		}
		
		byte[] testFile = null, newFile = null;
		try {
			testFile = Files.readAllBytes(Path.of(SaveHandler.getFilePath("test-save")));
		} catch (IOException e) {
			fail("COuld not load file");
		}
		assertNotNull(testFile);
		assertNotNull(newFile);
		assertTrue(Arrays.equals(testFile, newFile));
	}
	
	@AfterAll
	static void tearDown() {
		File newTestSaveFile = new File(SaveHandler.getFilePath("test-save-new"));
		newTestSaveFile.delete();
	}
	
}
