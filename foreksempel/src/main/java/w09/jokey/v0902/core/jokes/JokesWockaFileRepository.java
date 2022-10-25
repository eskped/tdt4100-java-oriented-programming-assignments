package w09.jokey.v0902.core.jokes;

import w09.jokey.lib.JsonFileReaderHelper;
import w09.jokey.v0902.core.JokeyIdentifierHelper;

/**
 * 
 * @author steinlt
 *
 */
public class JokesWockaFileRepository extends AbstractJokesRepository {
	private final String IDENTIFIER_NAMESPACE = "joke_wocka";
	private final String IDENTIFIER = "wocka_repository";

	public JokesWockaFileRepository() throws Exception {
		super("WOCKA", "A dataset of English plaintext jokes.", "Pungas, Taivo", null,
				"https://github.com/taivop/joke-dataset");
		populateJokesList();
	}

	private void populateJokesList() throws Exception {
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
				addJoke(joke);
			}
		} catch (Exception e) {
			System.err.println("JokesWockaFileRepository feilet da den prøvde å benytte '" + path
					+ "wocka-filtered.json'. Se til at denne finnes eventuelt sett riktig sti i JokesWockaFileRepository-klassen.");
			throw e;
		}
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

	@Override
	public String getIdentifierAsString() {
		return IDENTIFIER;
	}
}
