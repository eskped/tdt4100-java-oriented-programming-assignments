package w09.jokey.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Beskrivelse kommer...
 * 
 * Denne er uansett ikke pensum, for viderekommende og spesielt interesserte.
 * 
 * @author steinlt
 *
 * @param <T>
 */
public class JsonFileReaderHelper<T> {
	/**
	 * 
	 * @param path
	 * @param filename
	 * @param valueType
	 * @return
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException
	 */
	public T readFrom(String path, String filename, Class<T> valueType) throws IOException, JsonGenerationException,
			JsonMappingException, SecurityException, FileNotFoundException, IllegalArgumentException {
		if (path == null || path.isBlank())
			throw new IllegalArgumentException("path kan ikke være null eller blank");
		if (filename == null || filename.isBlank())
			throw new IllegalArgumentException("filename kan ikke være null eller blank");

		InputStream fis = new FileInputStream(
				path + (path.endsWith(System.getProperty("file.separator")) ? "" : System.getProperty("file.separator"))
						+ filename);
		T retVal = (new ObjectMapper()).readValue(fis, valueType);
		fis.close();
		return retVal;
	}

	/**
	 * 
	 * @param filename
	 * @param valueType
	 * @return
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws SecurityException
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException
	 */
	public T readFromUserDir(String filename, Class<T> valueType) throws IOException, JsonGenerationException,
			JsonMappingException, SecurityException, FileNotFoundException, IllegalArgumentException {
		return readFrom(System.getProperty("user.dir"), filename, valueType);
	}
}
