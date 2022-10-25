package w03;

import java.util.Iterator;
import java.util.List;

/**
 * Oppgave: Objekter som konstrueres med to heltall. Objektet skal så kunne bli
 * spurt om summen av tallene gjennom metoden pluss(), mens gang() skal
 * returnere de to tallene ganget med hverandre.
 * 
 * @author borgeha
 *
 */
public class Regne {
	// De to tallene:
	int a, b;

	// Konstruktøren - som definert over.
	public Regne(int aa, int b) {
		super();
		a = aa;
		this.b = b;
	}

	public int gang() {
		return a * b;
	}

	public int pluss() {
		return a + b;
	}

	public static void main(String[] args) {
		// Her lager vi et objekt som settes i en viss tilstand. Da blir pluss og gang
		// det samme hver gang, en kan ikke endre tilstanden heller.
		System.out.println("Første objekt");
		Regne r = new Regne(3, 5);
		System.out.println(String.format("Tallene er a=%d og b=%d", r.a, r.b));
		System.out.println(String.format("Gang:\t%d*%d=%d", r.a, r.b, r.gang()));
		System.out.println(String.format("Pluss:\t%d+%d=%d", r.a, r.b, r.pluss()));

		// legger til en blank linje for å lette utskrift
		System.out.println();

		System.out.println("Andre objekt");
		Regne r2 = new Regne(4, 6);
		// la oss gjøre det litt enklere enn sist
		r2.prettyPrint(r2.gang(), r2.pluss());

		// Ytterligere utvidelse etter forelesningsslutt. Se under for kommentarer
		System.out.println("Endre a og b i første objekt:");
		r.setA(6);
		r.setB(7);
		// hvorfor ikke gjøre det ennå enklere enn sist :)
		r.prettyPrint();
		
		// hva med?
		System.out.println("Endre a og b i første objekt (direkte):");
		r.a = 7;
		r.b = 6;
		// Fungerer ikke dette bra da eller?
		// Når kan en gjøre det, eventuelt når kan en ikke? Eller skal en aldri gjøre det?		
		r.prettyPrint();

		// Metoder for å beregne pluss og gang, der verdiene blir med som parametre:
		System.out.println("a og b er parametre:");
		System.out.println(r.gang(3, 4));
		System.out.println(r.pluss(3, 4));

		// Hvis jeg gjør en metode static, da er den en metode som kalles på KLASSEN
		// og ikke hvert enkelt OBJEKT. Da trenger en ikke lage et objekt for å bruke
		// den:
		System.out.println("Ingen objekter, men virker allikevel: " + Regne.pluss(7, 8));
		
		// legger til en blank linje for å lette utskrift
		System.out.println();
		
		// test av liste med tall som plusses
		List<Integer> tall = List.of(-1, 8, 4, 5, 9);
		System.out.println("Legger i sammen en liste med tall");
		System.out.println("Sum:\t" + Regne.pluss(tall));
	}

	public void prettyPrint(int gangVerdi, int plussVerdi) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Tallene er a=%d og b=%d\n", a, b));
		sb.append(String.format("Gang:\t%d*%d=%d\n", a, b, gangVerdi));
		sb.append(String.format("Pluss:\t%d+%d=%d", a, b, plussVerdi));
		sb.append('\n');
		System.out.println(sb.toString());
	}

	public void prettyPrint() {
		prettyPrint(gang(), pluss());
	}

	/*
	 * Under forelesning laget jeg aldri noen metode som kunne endre på tilstanden
	 * til disse objektene. De ville for alltid ha den samme tilstanden, men kunne
	 * fremdeles brukes til å få frem verdiene av pluss og gang.
	 * 
	 * Hvis en skulle tenkt annerledes, og heller tenkt på et objekt som kunne
	 * brukes til ulike verdier for a og b, da kunne en implementert følgende
	 * metoder:
	 */

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	/*
	 * Alternativt kunne en ha laget en metode der en tok inn de to verdiene en
	 * ville for a og b, og egentlig aldri brukt de interne a og b. Vi hadde ikke
	 * trengt å ha dem der. Vi hadde aldri brydd oss om tilstanden til objektene,
	 * men bare brukt objektene for utregningsmetodene de hadde.
	 */

	public static int pluss(int a, int b) {
		return a + b;
	}

	public int gang(int a, int b) {
		return a * b;
	}
	
	public static int pluss(List<Integer> tall) {
		int retVal = 0;
		for (Iterator<Integer> iterator = tall.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			retVal += integer.intValue();			
		}
		return retVal;
	}
}
