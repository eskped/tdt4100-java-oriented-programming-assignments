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
			 * Det som gj�res her er litt spesielt og ikke pensum. Det benyttes et bibliotek
			 * som lar oss lese en json fil og putte dataene i WockaJoke objekter. WockaJoke
			 * er en s�klat indre klasse og beskrevet lengre ned i koden.
			 */
			JsonFileReaderHelper<WockaJoke[]> jsonReader = new JsonFileReaderHelper<WockaJoke[]>();
			WockaJoke[] wockaJokes = jsonReader.readFrom(path, "wocka-filtered.json", WockaJoke[].class);

			/*
			 * Fra n� av er det mer vanlig kode, ved at den tar innholdet i et objekt og
			 * flytter over til et annet.
			 */
			for (int i = 0; i < wockaJokes.length; i++) {
				WockaJoke wockaJoke = wockaJokes[i];
				Joke joke = new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, wockaJoke.getId()),
						wockaJoke.getTitle(), wockaJoke.getBody(), wockaJoke.getCategory());
				addJoke(joke);
			}
		} catch (Exception e) {
			System.err.println("JokesWockaFileRepository feilet da den pr�vde � benytte '" + path
					+ "wocka-filtered.json'. Se til at denne finnes eventuelt sett riktig sti i JokesWockaFileRepository-klassen.");
			throw e;
		}
	}

	/**
	 * Viderekommende og ikke ene del av pensum. Bare aksepter at vi f�r inn data
	 * fra en fil som er i json format og at dette blir konvertert over til v�rt
	 * format som er representert i Joke-klassen.
	 * 
	 * Dette er en spesialklasse som benyttes for � importere data i jsonformat.
	 * Problemet er at wocka vitsene har et format som ikke matcher helt v�rt eget,
	 * de benytter id, title, body og category og alle er strenger. N�r Jackson-json
	 * biblioteket konverterer fra json til et objekt forventer den � finne en
	 * metode med samme navn som de nevnt over. Vi m� derfor gj�re en konvertering
	 * og og ha et midlertidig format som vist i klassen under.
	 * 
	 * Generelt n�r en forventer automatisk mapping av json n�kler m� en passe p� at
	 * de skrives helt likt som n�kklene, men med getter/setter notasjon. For noen
	 * libs kan en typisk legge til ekstra beskrivelser for mapping hvis feks n�kkel
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
