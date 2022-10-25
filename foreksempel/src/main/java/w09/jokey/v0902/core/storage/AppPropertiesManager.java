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
	 * Siden vi benytter singleton-pattern og getInstance() for å få den ene
	 * instansen av denne klassen må vi begrense tilgang til konstrukøren, dette
	 * gjør vi ved å sette den til private.
	 */
	private AppPropertiesManager() {
		try (FileInputStream fis = new FileInputStream(APP_PROPS_FILE_NAME)) {
			appProps.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(APP_PROPS_FILE_NAME + " ble ikke funnet, benytter standardoppsett");
		} catch (Exception e) {
			// det er ikke så nøye om det blir en exception, men vi kan skrive en
			// feilmelding
			e.printStackTrace();
		}
	}

	/**
	 * Her bruker vi et såkalt Singleton Pattern
	 * (https://en.wikipedia.org/wiki/Singleton_pattern) for å sikre at vi bare får
	 * en instans av en klasse. Det finnes mange ulike patterns, men det å lage en
	 * helper-klasse er ganske vanlig da den er både thread-safe (sikker med tanke
	 * på flertrådkjøring) samt at den ikke lastest før det faktisk blir gjort en
	 * forespørsel (mao vi sparer eventuelt minne hvis den ikke skulle bli kjørt).
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
	 * Søker etter en property med gitt nøkkel.
	 * 
	 * @param key nøkkelen til den propertien som søkes
	 * @return verdien til nøkkelen, ev. {@code null} hvis nøkkelen ikke ble funnet
	 * @see #getProperty(String, String)
	 */
	public String getProperty(String key) {
		return getProperty(key, null);
	}

	/**
	 * Søker etter en property med gitt nøkkel.
	 * 
	 * @param key          nøkkelen til den propertien som søkes
	 * @param defaultValue en standsrdverdi som blir returnert hvis nøkkelen ikke
	 *                     ble funnet
	 * @return verdien til nøkkelen, ev. standardverdien hvis nøkkelen ikke ble
	 *         funnet
	 * @see java.util.Properties#getProperty(String, String)
	 */
	public String getProperty(String key, String defaultValue) {
		if (key != null)
			key = key.trim().toLowerCase();
		return appProps.getProperty(key, defaultValue);
	}

	/**
	 * Setter en verdi for en property med gitt nøkkel.
	 * 
	 * @param key   nøkkelen til verdien som skal settes
	 * @param value verdien til nøkkelen
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
	 * @param key nøkkelen til verdien som skal hentes
	 * @return {@code true}/{@code false} hvis den er funnet, hvis ikke
	 *         {@code false}
	 */
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getProperty(key));
	}

	/**
	 * Henter en property og konverterer den til {@code int}.
	 * 
	 * @param key nøkkelen til verdien som skal hentes
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
	 * @param key nøkkelen til verdien som skal hentes
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
	 * @param key       nøkkelen til verdien som skal lagres
	 * @param valueList den listen med verdier som ønskes lagret
	 * @param divider   et tegn som benyttes til å skille av tekststrengene
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
	 * @param key     nøkkelen til verdien som skal hentes
	 * @param divider et tegn som benyttes til å skille av tekststrengene
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
