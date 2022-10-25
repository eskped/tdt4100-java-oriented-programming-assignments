package w09.jokey.v0902.core.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class AppPropertiesManager {
	private final String APP_PROPS_FILE_NAME = System.getProperty("user.home") + System.getProperty("file.separator")
			+ "jokey.props";
	private Properties appProps = new Properties();

	/*
	 * Siden vi benytter singleton-pattern og getInstance() for � f� den ene
	 * instansen av denne klassen m� vi begrense tilgang til konstruk�ren, dette
	 * gj�r vi ved � sette den til private.
	 */
	private AppPropertiesManager() {
		try (FileInputStream fis = new FileInputStream(APP_PROPS_FILE_NAME)) {
			appProps.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(APP_PROPS_FILE_NAME + " ble ikke funnet, benytter standardoppsett");
		} catch (Exception e) {
			// det er ikke s� n�ye om det blir en exception, men vi kan skrive en
			// feilmelding
			e.printStackTrace();
		}
	}

	/**
	 * Her bruker vi et s�kalt Singleton Pattern
	 * (https://en.wikipedia.org/wiki/Singleton_pattern) for � sikre at vi bare f�r
	 * en instans av en klasse. Det finnes mange ulike patterns, men det � lage en
	 * helper-klasse er ganske vanlig da den er b�de thread-safe (sikker med tanke
	 * p� flertr�dkj�ring) samt at den ikke lastest f�r det faktisk blir gjort en
	 * foresp�rsel (mao vi sparer eventuelt minne hvis den ikke skulle bli kj�rt).
	 * 
	 * @author steinlt
	 *
	 */
	private static class SingletonHelper {
		private static final AppPropertiesManager INSTANCE = new AppPropertiesManager();
	}

	/**
	 * Returnerer en instans av PropertiesManager.
	 * 
	 * @return instansen av PropertiesManager
	 */
	public static AppPropertiesManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	/**
	 * S�ker etter en property med gitt n�kkel.
	 * 
	 * @param key n�kkelen til den propertien som s�kes
	 * @return verdien til n�kkelen, ev. {@code null} hvis n�kkelen ikke ble funnet
	 * @see #getProperty(String, String)
	 */
	public String getProperty(String key) {
		return getProperty(key, null);
	}

	/**
	 * S�ker etter en property med gitt n�kkel.
	 * 
	 * @param key          n�kkelen til den propertien som s�kes
	 * @param defaultValue en standsrdverdi som blir returnert hvis n�kkelen ikke
	 *                     ble funnet
	 * @return verdien til n�kkelen, ev. standardverdien hvis n�kkelen ikke ble
	 *         funnet
	 * @see java.util.Properties#getProperty(String, String)
	 */
	public String getProperty(String key, String defaultValue) {
		if (key != null)
			key = key.trim().toLowerCase();
		return appProps.getProperty(key, defaultValue);
	}

	/**
	 * Setter en verdi for en property med gitt n�kkel.
	 * 
	 * @param key   n�kkelen til verdien som skal settes
	 * @param value verdien til n�kkelen
	 * @see java.util.Properties#setProperty(String, String)
	 */
	public void setProperty(String key, String value) {
		if (key != null) {
			key = key.trim().toLowerCase();
			appProps.setProperty(key, value);
			// vi "autoflusher"
			flush();
		}
	}

	/**
	 * Skriver tilstanden av appProps til fil.
	 */
	private void flush() {
		try {
			File file = new File(APP_PROPS_FILE_NAME);
			// denne lager en ny fil, men kun hvis den ikke finnes
			file.createNewFile();
			try (FileOutputStream fos = new FileOutputStream(file)) {
				appProps.store(fos, "Jokey application properties");
			}
		} catch (Exception e) {
			// i tilfellet her er det ikke kritisk hvis den feiler, slik at vi skriver bare
			// ut en feilmelding
			e.printStackTrace();
		}
	}

	/*
	 * Noen hjelpemetoder
	 */
	/**
	 * Henter en property og konverterer den til {@code boolean}.
	 * 
	 * @param key n�kkelen til verdien som skal hentes
	 * @return {@code true}/{@code false} hvis den er funnet, hvis ikke
	 *         {@code false}
	 */
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getProperty(key));
	}

	/**
	 * Henter en property og konverterer den til {@code int}.
	 * 
	 * @param key n�kkelen til verdien som skal hentes
	 * @return verdien hvis den er funnet, hvis ikke {@code defaultValue}
	 */
	public int getInt(String key, int defaultValue) {
		try {
			return Integer.parseInt(getProperty(key));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Henter en property og konverterer den til {@code float}
	 * 
	 * @param key n�kkelen til verdien som skal hentes
	 * @return verdien hvis den er funnet, hvis ikke {@code defaultValue}
	 */
	public float getFloat(String key, float defaultValue) {
		try {
			return Float.parseFloat(getProperty(key));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Lagrer en liste med verdier
	 * 
	 * @param key       n�kkelen til verdien som skal lagres
	 * @param valueList den listen med verdier som �nskes lagret
	 * @param divider   et tegn som benyttes til � skille av tekststrengene
	 */
	public void setPropertyList(String key, ArrayList<String> valueList, char divider) {
		if (key != null && valueList != null) {
			key = key.trim().toLowerCase();

			StringBuilder sb = new StringBuilder();
			for (String str : valueList) {
				sb.append(str);
				sb.append(divider);
			}
			appProps.setProperty(key, sb.toString());
			// vi "autoflusher"
			flush();
		}
	}

	/**
	 * Henter en property og konverterer den til en liste med strenger
	 * 
	 * @param key     n�kkelen til verdien som skal hentes
	 * @param divider et tegn som benyttes til � skille av tekststrengene
	 * @return en liste med verdier hvis den er funnet, hvis ikke {@code null}
	 */
	public ArrayList<String> getList(String key, char divider) {
		String strList = getProperty(key);
		if (strList != null) {
			String[] items = strList.split("[" + divider + "]+");
			return new ArrayList<>(Arrays.asList(items));
		}

		return null;
	}
}
