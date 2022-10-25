package w06.jokey.v0601.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import w06.jokey.lib.JsonFileReaderHelper;

/**
 * 
 * @author steinlt
 *
 */
public class JokesWockaFileRepository implements IJokes, IJokesRepository {
	private final String IDENTIFIER_NAMESPACE = "joke_wocka";

	private String name, description, credits, legalDisclaimer, url;

	/**
	 * PlanUML tips!
	 * <p>
	 * Hvis du bruker PlantUML, vil du fort legge merke til at den ikke er så flink
	 * til å legge til relasjoner mellom klasser hvis en benytter noen classer fra
	 * collection standardbiblioteket. Men det er en måte å lure frem relasjonen
	 * slik at den vises i diagrammet. Det kan gjøres ved å lage en tilsvarende
	 * array med samme navn (feks private Joke[] jokes = new Joke[];). Begge lister
	 * må vises samtidig, dvs ikke kommentert ut. Hvis en da markere alle relaterte
	 * klasser i Project Explorer vil en se at relasjoner vises som forventet.
	 */
	// private Joke[] jokes = new Joke[];

	private ArrayList<Joke> jokes = new ArrayList<Joke>();

	/*
	 * I denne konstruktøren har vi noe nytt, vi har 'throws Exception'. Tidligere
	 * har vi ikke spesifisert det. Forskjellen er at når dette er lagt til blir
	 * brukeren av konstruktøren/metoden tvunget til å håndtere eventuelle tilfeller
	 * med enten try-catch eller bare å kaste den videre. Mens i de tilfeller at det
	 * ikke er spesifisert kan en velge om en skal håndtere det eller ei.
	 */
	public JokesWockaFileRepository() throws Exception {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\w06\\jokey\\lib\\";

		try {
			/*
			 * Det som gjøres her er litt spesielt og ikke pensum. Det benyttes et bibliotek
			 * som lar oss lese en json fil og putte dataene i WockaJoke objekter. WockaJoke
			 * er en såklat indre klasse og beskrevet lengre ned i koden.
			 */
			JsonFileReaderHelper<WockaJoke[]> jsonReader = new JsonFileReaderHelper<WockaJoke[]>();
			WockaJoke[] wockaJokes = jsonReader.readFrom(path, "wocka-filtered.json", WockaJoke[].class);

			/*
			 * Fra nå av er det mer vanlig kode, ved at den tar innholdet i et objekt og
			 * flytter over til et annet.
			 */
			for (int i = 0; i < wockaJokes.length; i++) {
				WockaJoke wockaJoke = wockaJokes[i];
				Joke joke = new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, wockaJoke.getId()),
						wockaJoke.getTitle(), wockaJoke.getBody(), wockaJoke.getCategory());
				jokes.add(joke);
			}
		} catch (Exception e) {
			System.err.println("JokesWockaFileRepository feilet da den prøvde å benytte '" + path
					+ "wocka-filtered.json'. Se til at denne finnes eventuelt sett riktig sti i JokesWockaFileRepository-klassen.");
			throw e;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public void setLegalDisclaimer(String legalDisclaimer) {
		this.legalDisclaimer = legalDisclaimer;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getCredits() {
		return credits;
	}

	@Override
	public String getLegalDisclaimer() {
		return legalDisclaimer;
	}

	@Override
	public URL getUrl() {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public int getJokesCount() {
		return jokes.size();
	}

	@Override
	public Joke getRandomJoke() {
		Random random = new Random();
		int jokeIndex = random.nextInt(jokes.size());
		return jokes.get(jokeIndex);
	}

	/**
	 * Viderekommende og ikke ene del av pensum. Bare aksepter at vi får inn data
	 * fra en fil som er i json format og at dette blir konvertert over til vårt
	 * format som er representert i Joke-klassen.
	 * 
	 * Dette er en spesialklasse som benyttes for å importere data i jsonformat.
	 * Problemet er at wocka vitsene har et format som ikke matcher helt vårt eget,
	 * de benytter id, title, body og category og alle er strenger. Når Jackson-json
	 * biblioteket konverterer fra json til et objekt forventer den å finne en
	 * metode med samme navn som de nevnt over. Vi må derfor gjøre en konvertering
	 * og og ha et midlertidig format som vist i klassen under.
	 * 
	 * Generelt når en forventer automatisk mapping av json nøkler må en passe på at
	 * de skrives helt likt som nøkklene, men med getter/setter notasjon. For noen
	 * libs kan en typisk legge til ekstra beskrivelser for mapping hvis feks nøkkel
	 * har forskjellig navn fra getter/setter.
	 * 
	 * @author steinlt
	 *
	 */
	private static class WockaJoke {
		private String body, category, id, title;

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
