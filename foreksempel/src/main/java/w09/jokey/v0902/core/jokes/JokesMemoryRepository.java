package w09.jokey.v0902.core.jokes;

import w09.jokey.v0902.core.JokeyIdentifierHelper;

/**
 * Dette er den første utgaven av Jokes, som har en liste med vitser hardkodet i
 * minnet. I en seinere utgave vil vi legge til mulighet for flere kilder.
 * Hvordan tenker du det kan gjøres slik at en siden kan velge hvilken kilde en
 * vil hente vitser i fra?
 * 
 * @author steinlt
 *
 */
public class JokesMemoryRepository extends AbstractJokesRepository {
	private final String IDENTIFIER_NAMESPACE = "joke_memory";
	private final String IDENTIFIER = "memory_repository";

	public JokesMemoryRepository() {
		super("MemJokes", "Dette er den orginale listen som vi startet med som er hardkodet i minnet.",
				"SteinLT", null, null);
		populateJokesList();
	}

	private void populateJokesList() {
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "1"), "Katta med slips!"));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "2"),
				"Hund med slips! Dette er nok en helt elendig vits, men hva gjør en vits til en vits egentlig?"));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "3"),
				"Nå begynner dette å bli pinlig egentlig, for dette er ikke noen vits..."));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "4"),
				"Hva er vitsen? Ha, den var jo egentlig ikke så dum og litt dobbel? Men er det en vits?"));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "5"),
				"Flere som gleder seg til vi skal bytte til en annen kilde for vitser?"));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "6"),
				"Dette begynner egentlig å minne om pappavitser? Tomme for innhold og uten mening..."));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "7"),
				"Kanskje dette bare er en pappavits-generator? Uff da..."));
		addJoke(new Joke(JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE, "8"),
				"Slapp av, redningen kommer i rundt uke 6(?)"));
	}

	@Override
	public String getIdentifierAsString() {
		return IDENTIFIER;
	}
}
