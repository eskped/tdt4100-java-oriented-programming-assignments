package w09.jokey.lib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonApiReaderHelper<T> {
	/**
	 * 
	 * @param url
	 * @param valueType
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException
	 */
	public T readFrom(URL url, Class<T> valueType) throws IOException,
			JsonMappingException, IllegalArgumentException {
		if (url == null)
			throw new IllegalArgumentException("url kan ikke være null");

		return (new ObjectMapper()).readValue(url, valueType);
	}
}
