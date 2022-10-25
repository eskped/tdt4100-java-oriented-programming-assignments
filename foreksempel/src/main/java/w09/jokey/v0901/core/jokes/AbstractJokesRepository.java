package w09.jokey.v0901.core.jokes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import w09.jokey.v0901.core.IJokeyIdentifier;
import w09.jokey.v0901.core.JokeyIdentifierHelper;

public abstract class AbstractJokesRepository implements IJokesRepository {
	private final String name, description, credits, legalDisclaimer, url;

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
	//private Joke[] jokes = new Joke[];

	private ArrayList<Joke> jokes = new ArrayList<Joke>();
	
	public AbstractJokesRepository(String name, String description, String credits, String legalDisclaimer, String url) {
		this.name = name;
		this.description = description;
		this.credits = credits;
		this.legalDisclaimer = legalDisclaimer;
		this.url = url;
	}
	
	/**
	 * Legger til en ny vits. Siden vi legger til en vits her via en metode har vi
	 * god innkapsling og kan endre på listens form seinere hvis vi ønsker det, feks
	 * å gå over til en set, sortert list, eller hva det måtte være.
	 * 
	 * @param joke vitsen som skal legges til
	 * @return {@code true} hvis den blir lagt til, hvis ikke returneres {@code false}
	 */
	boolean addJoke(Joke joke) {
		return jokes.add(joke);
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

	/*
	 * Jokes-relaterte metoder
	 */
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
	
	/*
	 * Identitets-relaterte metoder
	 */
	@Override
	public IJokeyIdentifier getIdentifier() {
		return this;
	}

	@Override
	public boolean sameIdentifier(IJokeyIdentifier otherIdentifier) {
		return JokeyIdentifierHelper.equals(this, otherIdentifier);
	}
}
