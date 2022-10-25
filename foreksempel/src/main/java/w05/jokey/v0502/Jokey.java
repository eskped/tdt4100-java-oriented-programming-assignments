package w05.jokey.v0502;

/**
 * I tidligere har vi returnert stort sett true/false for å indikere feil. For
 * konstruktører er dette en dårlig strategi. I denne utgaven forbedrer vi koden
 * ved å innfører vi throw/catch av Exceptions.
 * <p>
 * Vi har gjort endring i Jokes.main(...), Jokes.printlnJokeAt(...) og
 * Joke.getJokeAt(...). Er det flere plasser det burde vært gjort forbedringer?
 * Hva tenker du? Forslag til forbedringer kommer i neste utgave.
 * 
 * @author steinlt
 */
public class Jokey {
	/**
	 * Denne er litt for viderekommende. Hva er den det gjør egentlig? Hint, se på
	 * formatet for package.
	 */
	private final String VERSION = this.getClass().getPackageName()
			.substring(this.getClass().getPackageName().lastIndexOf('.') + 1);

	private final String TITLE = "Jokey - hva er vitsen?";

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
			// lager en instans, kun for å få tittel og versjon
			Jokey jokey = new Jokey();
			if (console) {
				System.out.println("Starter konsollversjon av Jokey");
				JokeyConsole.launch(username, jokey.TITLE, jokey.VERSION);
			}else {
				System.out.println("Starter appversjon av Jokey");
				JokeyApp.launch(username, jokey.TITLE, jokey.VERSION);
			}
		} catch (Exception e) {
			System.err.println("Det oppstod en fatal feil!");
			e.printStackTrace();
		} finally {
			/*
			 * TIPS! Legg til en finally hvis du har behov for å "rydde opp" etter at en
			 * kode er kjørt. Merk at finally kjøres uavhengig av om det opstår en Exception
			 * eller ei.
			 */
		}
	}
}
