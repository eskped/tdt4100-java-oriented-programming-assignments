package w06.jokey.v0601.core;

/**
 * En enkel klasse som inneholder en vits. Selv om den er enkel så er litt av
 * poenget at vi ønsker å kapsle inn vitsen i en egen klasse. Dette gir større
 * fleksibilitet da vi ønsker å kunne ha mer funksjonalitet seinere, men vi vet
 * ennå ikke hva.
 * 
 * Nå vet vi det for nå er denne utvidet med både tittel og kategori samt en
 * identifikator for vitsen.
 * 
 * @author steinlt
 */
public class Joke implements IJokeyIdentifier {
	private final String identifier;

	/**
	 * Vi har flere globale variabler av typen streng som inneholder tittel, selve
	 * vitsen og en kategori. Vi setter den til private slik at den ikke er
	 * tilgengelig uten at en benytter getJoke() metoden.
	 */
	private String title, body, category;

	/**
	 * En vits og en identifikator
	 * 
	 * @param jokeyIdentifier en identifikator som unikt identifiserer vitsen
	 * @param body            selve vitsen eller null/blank
	 * @throws IllegalArgumentException hvis jokeyIdentifier er null eller blank
	 */
	public Joke(String jokeyIdentifier, String body) {
		this(jokeyIdentifier, null, body, null);
	}

	/**
	 * En vits med en tittel, vitsen og en identifikator
	 * 
	 * @param jokeyIdentifier en identifikator som unikt identifiserer vitsen
	 * @param title           tittel for vitsen eller null/blank
	 * @param body            selve vitsen eller null/blank
	 * @throws IllegalArgumentException hvis jokeyIdentifier er null eller blank
	 */
	public Joke(String jokeyIdentifier, String title, String body) {
		this(jokeyIdentifier, title, body, null);
	}

	/**
	 * En vits med en tittel, vitsen, kategori og en identifikator
	 * 
	 * @param jokeyIdentifier en identifikator som unikt identifiserer vitsen
	 * @param title           tittel for vitsen eller null/blank
	 * @param body            selve vitsen eller null/blank
	 * @param category        kategori for vitsen eller null/blank
	 * @throws IllegalArgumentException hvis jokeyIdentifier er null eller blank
	 */
	public Joke(String jokeyIdentifier, String title, String body, String category) {
		if (jokeyIdentifier == null || jokeyIdentifier.isBlank())
			throw new IllegalArgumentException("jokeyIdentifier kan ikke være null eller blank");

		this.identifier = jokeyIdentifier;
		this.title = title;
		this.body = body;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	/**
	 * Returnerer selve vitsen
	 */
	@Override
	public String toString() {
		return getBody();
	}

	@Override
	public IJokeyIdentifier getIdentifier() {
		/*
		 * Siden dette er en implementasjon av IJokeyIdentifier kan vi returnere seg
		 * selv.
		 */
		return this;
	}

	@Override
	public String getIdentifierAsString() {
		return identifier;
	}

	@Override
	public boolean sameIdentifier(IJokeyIdentifier otherIdentifier) {
		return JokeyIdentifierHelper.equals(this, otherIdentifier);
	}
}
