package w03;

/*
 * I denne klassen er det lagt til ekstra mange kommentarer for å gi en slags
 * oppsummering av forelesninger så langt, samt noen generelle tips.
 */

public class HovedProgram extends ConsoleProgram {
	public void runEx1() {
		println("Eksempel #1", true, true);
		println("Først så lager vi to ansatt-objekter og skriver dem ut til konsollet");
		println();
		
		Ansatt a1 = new Ansatt();
		
		/* 
		 * Legg merke til at i Ansatt-klassen så er fornavn variablen satt til private og dermed ikke tilgjengelig fra denne klassen. 
		 * Når satt til private er den kun tilgjengelig via den klassen den er definert. 
		 */
		//a1.fornavn = "Hei";
		/* 
		 * Legg merke til at i Ansatt-klassen så er etternavn variablen satt til protected og dermed tilgjengelig fra denne klassen. 
		 * Når satt til protected er den kun tilgjengelig for klasser som befinner seg i samme pakke, i dette tilfellet w03.
		 * Det vil bli mer om synlighetsmodifikatorer i en seinere forelesning. 
		 */
		a1.etternavn = "Hei";
		// men "hei" blir overskrevet her
		a1.setNavn("Hallvard", "Trætteberg");
		a1.setKontor(115);
		Ansatt a2 = new Ansatt();
		a2.setNavn("Trond", "Aalberg");
		a2.setKontor(213);
		println(" > " + a1.getNavn() + " sitter på " + a1.getKontor());
		println(" > " + a2.getNavn() + " sitter på " + a2.getKontor());	
		
		/*
		 * Strengen under har vi \". \ betyr escape og brukes i tekststrenger for å vise
		 * kompilatoren at vi ønsker å sette inn et spesialtegn som i dette tilfellet er "
		 */
		/*
		 * OPPGAVE? Prøv å fjerne \ og se hva som skjer.
		 */
		println();
		println("Hva hvis vi nå setter a2 til å referere til a1 og setter a2.setFornavn(\"Trond\")?", true, false);
		println();
		
		a2 = a1;
		a2.setFornavn("Trond");
		// denne er litt sånn viderekommende, men for dem som er interessert
		String[] strengerTilUtskrift = { " > " + a1.getNavn() + " sitter på " + a1.getKontor(),
				" > " + a2.getNavn() + " sitter på " + a2.getKontor() };
		println(strengerTilUtskrift);
		
		println();
		println("Hva skjedde? Ble dette det resultatet du forventet?");
		printDivider(true);
	}
	
	public void runEx2() {
		println("Eksempel #2", true, true);
		println("Først så lager vi tre ansatt-objekter og setter naboskap");
		println();
		
		// først oppretter vi objektene
		Ansatt a1 = new Ansatt("Jon Atle", "Gulla", 234);
		Ansatt a2 = new Ansatt("Hallvard", "Trætteberg", 235);
		Ansatt a3 = new Ansatt("John", "Krogstie", 236);
		
		// nå kan vi sette naboskap siden vi nå har objektreferanser
		a1.setHoyreNabo(a2);
		a2.setNaboer(a1, a3);
		a3.setVenstreNabo(a2);
		
		// så kan vi skrive ut litt tilstander
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
