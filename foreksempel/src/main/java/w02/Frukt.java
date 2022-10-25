package w02;

/*
 * Et fruktobjekt har to egenskaper: En type, og et antall. 
 */
public class Frukt {
	double antall;
	String type;

	public Frukt(String type, double antall) {
		this.antall = antall;
		this.type = type;
	}

	// Termen 'settere og gettere' blir dere kjent med. Vi b�r ikke hente ut
	// informasjon rett fra objekter
	// I stedet b�r vi sp�rre etter dem. Som her.
	public String getType() {
		return type;
	}

	// Og her.
	public double getAntall() {
		return antall;
	}

	// Denne main-metoden kj�res dersom en velger run av Fruk.
	// Kj�r Smoothie-klassen, og se at main-metoden i Frukt aldri vil kj�res!
	public static void main(String[] args) {
		Frukt f1 = new Frukt("Appelsin", 2);
		Frukt f2 = new Frukt("Banan", 1);

		System.out.println("Skrive ut objektreferanser:"); // For � slippe � skrive alt det her: skriv sys, og s�
															// trykker du p� kontroll-mellomrom.
		// F�lgende to utskrifter ser ikke helt bra ut. Det skrives ut hvilket objekt
		// hver variabel er.
		// Legg merke til at begge er uke2.Frukt. Kj�r programmet en gang til, og se at
		// tegnene etter @ endrer seg.
		System.out.println(f1);
		System.out.println(f2);

		System.out.println("Skrive ut objektinnhold.");
		// For � se det faktisk inneholdet av objektene m� vi sp�rre etter dem:
		System.out.println(f1.getType() + " : " + f1.getAntall());
		System.out.println(f2.getType() + " : " + f2.getAntall());
	}
}
