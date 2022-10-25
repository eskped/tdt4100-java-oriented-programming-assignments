package w02.jokey.v0201;

/**
 * Her har vi laget en helt enkel klasse med noen globale variabler som
 * inneholder vitsene. Disse globale variablene er tilgjengelig når en lager en
 * instans av klassen Jokey i main metoden. 
 * 
 * @author steinlt
 */
public class Jokey {
	String title = "Jokey - hva er vitsen?";

	String joke0 = "Katta med slips!";
	String joke1 = "Hund med slips! Dette er nok en helt elendig vits, men hva gjør en vits til en vits egentlig?";
	String joke2 = "Nå begynner dette å bli pinlig egentlig, for dette er ikke noen vits...";
	String joke3 = "Hva er vitsen? Ha, den var jo egentlig ikke så dum og litt dobbel? Men er det en vits?";
	String joke4 = "Flere som gleder seg til vi skal bytte til en annen kilde for vitser?";
	String joke5 = "Dette begynner egentlig å minne om pappavitser? Tomme for innhold og uten mening...";
	String joke6 = "Kanskje dette bare er en pappavits-generator? Uff da...";
	String joke7 = "Slapp av, redningen kommer i rundt uke 6(?)";

	/**
	 * Dette er en metode som har en spesiell syntaks. Denne metode kan kalles fra
	 * "utsiden" av denne klassen. Hvis en klasse har denne metoden kan kjøremiljøet
	 * kjøre denne metoden, og mao starte dette programmet.
	 */
	public static void main(String[] args) {
		Jokey jokey = new Jokey();

		System.out.println(jokey.title.toUpperCase());
		System.out.println("Dette er vår første utgave av Jokey");
		System.out.println();
		System.out.println("Dagens vits:");
		/*
		 * Her ber vi om en vits, men vi må sette hvilken vits vi ønsker å vise. Dette
		 * er ikke ideelt, men det funker for nå.
		 */
		System.out.println("\"" + jokey.joke1 + "\"");
	}
}
