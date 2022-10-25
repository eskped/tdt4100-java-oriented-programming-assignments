package w03;

/*
 * I denne klassen er det lagt til ekstra mange kommentarer for å gi en slags
 * oppsummering av forelesninger så langt, samt noen generelle tips.
 */

import java.util.Iterator;
import java.util.List;

public class ConsoleProgram {
	/*
	 * Her er noen hjelpemetoder for utskift til konsollet som kan være
	 * hensiktsmessig for et typisk konsollprogram.
	 */

	/*
	 * TIPS! Legg merke til hvordan jeg har prøvs å gjenbruke så mye av koden som
	 * mulig med den hensikt å duplisere kodebiter minst mulig. Dette kan typisk
	 * kreve litt trening men det kommer etter hvert :)
	 */

	/*
	 * Dette er "hoved"-metoden/funksjonen som alle de andre benytter.
	 */
	public void println(String txt) {
		System.out.println(txt);
	}

	/*
	 * Blank linje.
	 */
	public void println() {
		println("");
	}

	/*
	 * En skiller som kan gjøre det enklere å skille på ulike utskrifter til konsollet.
	 */
	public void printDivider(boolean tykkLinje) {
		if (tykkLinje) {
			println("================================================================================================");
		}
		else {
			println("------------------------------------------------------------------------------------------------");
		}
	}

	public void println(String txt, boolean medSkiller, boolean tykkLinje) {
		if (medSkiller) {
			printDivider(tykkLinje);
			println(txt);
			printDivider(tykkLinje);
		} else {
			println(txt);
		}
	}

	public void println(List<String> txts, boolean withDividers, boolean tykkLinje) {
		if (txts != null) {
			for (Iterator<String> iterator = txts.iterator(); iterator.hasNext();) {
				String txt = iterator.next();
				println(txt, withDividers, tykkLinje);
			}
		}
	}

	public void println(List<String> txts) {
		println(txts, false, false);
	}

	public void println(String[] txts, boolean withDividers, boolean tykkLinje) {
		if (txts != null) {
			for (int i = 0; i < txts.length; i++) {
				println(txts[i], withDividers, tykkLinje);
			}
		}
	}

	public void println(String[] txts) {
		println(txts, false, false);
	}
}
