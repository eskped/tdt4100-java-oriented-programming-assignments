package w09.jokey.v0902;

/**
 * Jokey - hva er vitsen?
 * 
 * Oppstart av applikasjonen hvor det er mulig � starte opp enten
 * konsollversjonen eller versjonen som har et grafisk grensesnitt. Standard er
 * versjonen med et grafisk grensesnitt. 
 * 
 * @author steinlt
 */
public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gj�r egentlig? Hint, se p�
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	/**
	 * Applikasjonens tittel
	 */
	private final String TITLE = "Jokey - hva er vitsen?";

	/**
	 * Jokey applikasjonen.
	 * 
	 * @param args parametre som kan sendes inn ved oppstart. Parametrene skilles av
	 *             ved mellomrom, f.eks. {@code Jokey username=steinlt console}.
	 *             Gyldige parametre er {@code username=[brukernavn]} og
	 *             {@code console}. For {@code username=[brukernavn]} er
	 *             [brukernavn] �nsket brukernavn. Hvis brukernavnet ikke finnes
	 *             opprettes brukeren. For {@code console} vil konsollutgaven av
	 *             applikasjonen bli kj�rt.
	 */
	public static void main(String[] args) {
		String username = null;
		boolean console = false;

		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				String arg = args[i];
				if (arg.trim().toLowerCase().startsWith("username=")) {
					username = arg.substring(arg.indexOf("=") + 1);
				} else if (arg.equals("console")) {
					console = true;
				}
			}
		}

		try {
			// lager en instans, kun for � f� tittel og versjon (prim�rt) fra denne
			// instansen
			Jokey jokey = new Jokey();
			if (console) {
				System.out.println("Starter konsollversjon av Jokey");
				JokeyConsole.launch(username, jokey.TITLE, jokey.VERSION);
			} else {
				System.out.println("Starter appversjon av Jokey");
				JokeyApp.launch(username, jokey.TITLE, jokey.VERSION);
			}
		} catch (Exception e) {
			System.err.println("Beklager, men det oppstod en fatal feil!");
			e.printStackTrace();
		} finally {
			/*
			 * TIPS! Legg til en finally hvis du har behov for � "rydde opp" etter at en
			 * kode er kj�rt. Merk at finally kj�res uavhengig av om det oppst�r en
			 * Exception eller ei.
			 */
		}
	}
}
