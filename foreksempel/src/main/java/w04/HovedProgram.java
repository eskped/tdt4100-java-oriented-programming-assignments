package w04;

import w03.ConsoleProgram;
import w04.lib.*;

/*
 * I denne klassen er det lagt til ekstra mange kommentarer for � gi en slags
 * oppsummering av forelesninger s� langt, samt noen generelle tips.
 */

public class HovedProgram extends ConsoleProgram {
	public void runEx1() {
		println("Eksempel #1", true, true);
		println("F�rst s� lager vi to ansatt-objekter og skriver dem ut til konsollet");
		println();

		// pr�v � endre til � benytte klassen AnsattV2 i stedet. Endrer dette noe?
		// Merk at Ansatt benyttes flere steder.
		Ansatt a1 = new Ansatt();

		/*
		 * Legg merke til at i Ansatt-klassen s� er fornavn variablen satt til private
		 * og dermed ikke tilgjengelig fra denne klassen. N�r satt til private er den
		 * kun tilgjengelig via den klassen den er definert.
		 */
		// a1.fornavn = "Hei";
		/*
		 * Legg merke til at i Ansatt-klassen s� er etternavn variablen satt til
		 * protected. I w03 pakken var den tilgjengelig for denne klassen da
		 * Ansatt-klassen var i samme pakke som HovedProgram-klassen, men n� er
		 * Ansatt-klassen flyttet til en annen pakke 'lib' og dermed ikke lengre
		 * tilgjengelig fra denne klassen. N�r den er satt til protected er den kun
		 * tilgjengelig for klasser som befinner seg i samme pakke, som var tilfellet i
		 * w03.
		 */
		// a1.etternavn = "Hei";

		a1.setNavn("Hallvard", "Tr�tteberg");
		a1.setKontor(115);
		// pr�v � endre til � benytte klassen AnsattV2 i stedet. Endrer dette noe?
		// Merk at Ansatt benyttes flere steder.
		Ansatt a2 = new Ansatt();
		a2.setNavn("Trond", "Aalberg");
		a2.setKontor(-213);
		println(" > " + a1.getNavn() + " sitter p� " + a1.getKontor());
		println(" > " + a2.getNavn() + " sitter p� " + a2.getKontor());

		println();
		println("Hva hvis vi n� setter a2 til � referere til a1 og setter a2.setFornavn(\"Trond\")?", true, false);
		println();

		a2 = a1;
		a2.setFornavn("Trond");

		String[] strengerTilUtskrift = { " > " + a1.getNavn() + " sitter p� " + a1.getKontor(),
				" > " + a2.getNavn() + " sitter p� " + a2.getKontor() };
		println(strengerTilUtskrift);

		println();
		println("Hva skjedde? Ble dette det resultatet du forventet?");
		printDivider(true);
	}

	public void runEx2() {
		println("Eksempel #2", true, true);
		println("F�rst s� lager vi tre ansatt-objekter og setter naboskap");
		println();

		// pr�v � endre til � benytte klassen AnsattV2 i stedet. Endrer dette noe?
		// Merk at Ansatt benyttes flere steder.
		Ansatt a1 = new Ansatt("Jon Atle", "Gulla", 234);
		Ansatt a2 = new Ansatt("Hallvard", "Tr�tteberg", 235);
		Ansatt a3 = new Ansatt("John", "Krogstie", 236);

		a1.setHoyreNabo(a2);
		a2.setNaboer(a1, a3);
		a3.setVenstreNabo(a2);

		println(" > " + a1.toString());
		println(" > " + a2.toString());
		println(" > " + a3.toString());

		println();
		println("Ble dette resultatet som du forventet?");
		printDivider(true);
	}

	public static void main(String[] args) {
		HovedProgram hp = new HovedProgram();
		hp.runEx1();
		hp.runEx2();
	}
}
