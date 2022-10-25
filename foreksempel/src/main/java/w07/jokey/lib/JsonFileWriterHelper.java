package w07.jokey.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Beskrivelse kommer...
 * 
 * Denne er uansett ikke pensum, for viderekommende og spesielt interesserte. 
 * @author steinlt
 *
 * @param <T>
 */
public class JsonFileWriterHelper<T> {
	/**
	 * 
	 * @param path
	 * @param filename
	 * @param content
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException
	 */
	public void writeTo(String path, String filename, T content) throws IOException, JsonGenerationException,
			JsonMappingException, SecurityException, FileNotFoundException, IllegalArgumentException {
		if (path == null || path.isBlank())
			throw new IllegalArgumentException("path kan ikke være null eller blank");
		if (filename == null || filename.isBlank())
			throw new IllegalArgumentException("filename kan ikke være null eller blank");
		if (content == null || path.isBlank())
			throw new IllegalArgumentException("content kan ikke være null");

		FileOutputStream fos = new FileOutputStream(path + (path.endsWith("\\") ? "" : "\\") + filename);
		(new ObjectMapper()).writeValue(fos, content);
		fos.close();
	}

	/**
	 * 
	 * @param filename
	 * @param content
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException
	 */
	public void writeToUserDir(String filename, T content) throws IOException, JsonGenerationException,
			JsonMappingException, SecurityException, FileNotFoundException, IllegalArgumentException {
		writeTo(System.getProperty("user.dir"), filename, content);
	}
}
