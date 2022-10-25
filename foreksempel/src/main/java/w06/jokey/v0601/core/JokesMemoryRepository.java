package w06.jokey.v0601.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Dette er den første utgaven av Jokes, som har en liste med vitser hardkodet i
 * minnet. I en seinere utgave vil vi legge til mulighet for flere kilder.
 * Hvordan tenker du det kan gjøres slik at en siden kan velge hvilken kilde en
 * vil hente vitser i fra?
 * 
 * @author steinlt
 *
 */
public class JokesMemoryRepository implements IJokes, IJokesRepository {
	private final String IDENTIFIER_NAMESPACE = "joke_memory";

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

	public JokesMemoryRepository() {
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "1"),
				"Katta med slips!"));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "2"),
				"Hund med slips! Dette er nok en helt elendig vits, men hva gjør en vits til en vits egentlig?"));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "3"),
				"Nå begynner dette å bli pinlig egentlig, for dette er ikke noen vits..."));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "4"),
				"Hva er vitsen? Ha, den var jo egentlig ikke så dum og litt dobbel? Men er det en vits?"));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "5"),
				"Flere som gleder seg til vi skal bytte til en annen kilde for vitser?"));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "6"),
				"Dette begynner egentlig å minne om pappavitser? Tomme for innhold og uten mening..."));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "7"),
				"Kanskje dette bare er en pappavits-generator? Uff da..."));
		jokes.add(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "8"),
				"Slapp av, redningen kommer i rundt uke 6(?)"));
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
}
