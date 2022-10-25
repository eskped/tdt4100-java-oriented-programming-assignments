package w09.jokey.v0902.core.jokes;

import java.net.URL;

import w09.jokey.lib.JsonApiReaderHelper;
import w09.jokey.v0902.core.JokeyIdentifierHelper;

public class JokesChuckNorrisRepository extends AbstractJokesRepository {
	private final String IDENTIFIER_NAMESPACE = "joke_chucknorris";
	private final String IDENTIFIER = "chucknorris_repository";

	public JokesChuckNorrisRepository() throws Exception {
		super("Chuck Norris", "chucknorris.io is a free JSON API for hand curated Chuck Norris facts.",
				"Chucknorris.io",
				"This website and its creators are not affiliated with Chuck Norris, any motion picture corporation, any television corporation, parent, or affiliate corporation. All motion pictures, products, and brands mentioned on this website are the respective trademarks and copyrights of their owners. All material on this website is intended for humorous entertainment (satire ) purposes only. The content on this website is not necessarily true and should not be regarded as truth.",
				"https://api.chucknorris.io/");
	}

	/*
	 * Vi overskriver denne metoden siden vi skal hente en og en fil fra et API p�
	 * nett. For de spesielt interesserte s� finner du informasjon om dette APIet
	 * her https://api.chucknorris.io/.
	 */
	@Override
	public Joke getRandomJoke() {
		try {
			/*
			 * Det som gj�res her er litt spesielt og ikke pensum. Det benyttes et bibliotek
			 * som lar oss lese en json fil og putte dataene i et ChuckNorrisJoke objekt.
			 * ChuckNorrisJoke er en s�klat indre klasse og beskrevet lengre ned i koden.
			 */
			JsonApiReaderHelper<ChuckNorrisJoke> jsonReader = new JsonApiReaderHelper<ChuckNorrisJoke>();
			ChuckNorrisJoke cnJoke = jsonReader.readFrom(new URL("https://api.chucknorris.io/jokes/random"),
					ChuckNorrisJoke.class);

			/*
			 * Fra n� av er det mer vanlig kode, ved at den tar innholdet i et objekt og
			 * flytter over til et annet.
			 */
			if (cnJoke != null) {
				String firstCategory = (cnJoke.getCategories() != null && cnJoke.getCategories().length > 0
						? cnJoke.getCategories()[0]
						: "");
				return new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, cnJoke.getId()), null,
						cnJoke.getValue(), firstCategory);
			}
		} catch (Exception e) {
			System.err.println("JokesChuckNorrisRepository feilet ved henting av en tilfeldig vits");
		}
		return null;
	}

	/*
	 * Vi overskriver ogs� denne metoden siden vi ikke vet hvor mange vitser som er
	 * tilgjengelig og derfor heller returnerer -1 som en indikator p� et utkjent
	 * antall.
	 */
	@Override
	public int getJokesCount() {
		return -1;
	}

	@Override
	public String getIdentifierAsString() {
		return IDENTIFIER;
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
	private static class ChuckNorrisJoke {
		private String created_at, icon_url, id, updated_at, url, value;
		private String[] categories;

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		public String getIcon_url() {
			return icon_url;
		}

		public void setIcon_url(String icon_url) {
			this.icon_url = icon_url;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(String updated_at) {
			this.updated_at = updated_at;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String[] getCategories() {
			return categories;
		}

		public void setCategories(String[] categories) {
			this.categories = categories;
		}
	}
}
