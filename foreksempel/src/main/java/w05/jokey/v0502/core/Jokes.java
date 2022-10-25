package w05.jokey.v0502.core;

import java.util.ArrayList;

/**
 * Dette er den f�rste utgaven av Jokes, som har en liste med vitser hardkodet i
 * minnet. I en seinere utgave vil vi legge til mulighet for flere kilder. Hvordan
 * tenker du det kan gj�res slik at en siden kan velge hvilken kilde en vil hente
 * vitser i fra?
 * 
 * @author steinlt
 *
 */
/*
 * Denne metoden er litt uheldig ved at den som benytter denne m� vite litt av
 * den indre strukturen til denne klassen. Videre s� har det v�rt et problem at
 * vi ikke har hatt noen god m�te � identifisere de ulike vitsene, dette er n�
 * fikset ved egne identifikatorer for denne applikasjonen. Dette har vi laget
 * ved hjelp av Interfaces/grensesnitt (se IJokeyIdentifier og Joke som
 * implementerer denne).
 * 
 * Dette medf�rere litt endringer, ved at hver vits m� ha en identifikator (se
 * Jokes konstrukt�ren under for endringer). Disse identifikatorene kan benyttes
 * for ulike form�l slik som i UserData klassen.
 */
public class Jokes {
	private final String IDENTIFIER_NAMESPACE = "joke_memory";

	/**
	 * PlanUML tips!
	 * <p>
	 * Hvis du bruker PlantUML, vil du fort legge merke til at den ikke er s� flink
	 * til � legge til relasjoner mellom klasser hvis en benytter noen classer fra
	 * collection standardbiblioteket. Men det er en m�te � lure frem relasjonen
	 * slik at den vises i diagrammet. Det kan gj�res ved � lage en tilsvarende
	 * array med samme navn (feks private Joke[] jokes = new Joke[];). Begge lister
	 * m� vises samtidig, dvs ikke kommentert ut. Hvis en da markere alle relaterte
	 * klasser i Project Explorer vil en se at relasjoner vises som forventet.
	 */
	// private Joke[] jokes = new Joke[];

	private ArrayList<Joke> jokes = new ArrayList<Joke>();

	public Jokes() {
		jokes.add(new Joke("Katta med slips!", JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke(
				"Hund med slips! Dette er nok en helt elendig vits, men hva gj�r en vits til en vits egentlig?",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("N� begynner dette � bli pinlig egentlig, for dette er ikke noen vits...",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("Hva er vitsen? Ha, den var jo egentlig ikke s� dum og litt dobbel? Men er det en vits?",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("Flere som gleder seg til vi skal bytte til en annen kilde for vitser?",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("Dette begynner egentlig � minne om pappavitser? Tomme for innhold og uten mening...",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("Kanskje dette bare er en pappavits-generator? Uff da...",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
		jokes.add(new Joke("Slapp av, redningen kommer i rundt uke 6(?)",
				JokeyIdentifierHelper.create(IDENTIFIER_NAMESPACE)));
	}

	/**
	 * Hente et objekt med en vits.
	 * 
	 * @param jokeIndex Et tall fra og med 1 og til og med
	 *                  <code>getJokesCount()</code>
	 * @return Hvis identifikatoren finnes s� returneres et vitse-objekt
	 * @throws IndexOutOfBoundsException (fra List sin JavaDoc) if the index is out
	 *                                   of range
	 *                                   ({@code index < 0 || index >= size()})
	 */
	public Joke getJokeAt(int jokeIndex) {
		/*
		 * N� har vi endret denne til ikke � gj�re noen sjekk p� forh�nd, dermed kan
		 * jokeIndex vare utenfor omr�de for indekser for jokes-listen, det vil da
		 * kastes en IndexOutOfBoundsException som det forventes at den som kaller denne
		 * metoden eventuelt fanger for videre behandling.
		 */
		return jokes.get(jokeIndex);
	}

	/**
	 * En metode som gir oss antallet vitser tilgjengelig.
	 * 
	 * @return Antallet vitser tilgjengelig
	 */
	public int getJokesCount() {
		// Her returenere vi rette og slette antallet vitser som er tilgjengelig.
		return jokes.size();
	}
}
