package w04.lib;

/*
 * Se w03.Ansatt for kommentarer i koden, da de er fjernet her
 */
public class AnsattV2 {
	private final int INTET_KONTOR = -1;

	// denne er satt til private for å illustrere forskjellen på
	// synlighetsmodifikatorer fra HovedProgram-klassen
	private String fornavn = "";
	// denne er satt til protected for å illustrere forskjellen på
	// synlighetsmodifikatorer fra HovedProgram-klassen i w03 vs w04
	// hva er forskjellen? Hvorfor fungerer eks i w03 mens ikke i w04?
	protected String etternavn = "";

	private int kontor = INTET_KONTOR;

	/*
	 * I Ansatt benyttet vi en tabell med lengde 2 for å holde styr på venstre og
	 * høyre naboer (private Ansatt[] naboer). Her har vi byttet ut den interne
	 * representasjonen med to enkle variabler av denne klassen, henholdsvis
	 * naboVenstre og naboHoyre. Siden dette er en internrepresentasjon og den var
	 * godt innkapslet med synlighetmodifikator satt til private har vi mulighet til
	 * å endre på denne interne representasjonen UTEN at dette får noen påvirkning
	 * for andre klasser som benytter denne klassen. For å vise forkjellene må du
	 * dessverre endre Ansatt til Ansattv2 i HovedProgram (i et virkelig tilfelle
	 * ville ikke det vært nødvendig da alt ville fungert som før tross denne
	 * interne endringen). Dette er et veldig viktig moment med innkapsling.
	 */
	private AnsattV2 naboVenstre;
	private AnsattV2 naboHoyre;

	public AnsattV2() {
		this(null, null, -1);
	}

	public AnsattV2(String fornavn) {
		this(fornavn, null, -1);
	}

	public AnsattV2(String fornavn, String etternavn) {
		this(fornavn, etternavn, -1);
	}

	public AnsattV2(String fornavn, String etternavn, int kontor) {
		setNavn(fornavn, etternavn);
		setKontor(kontor);
	}

	public String getNavn() {
		return String.format("%s %s", fornavn, etternavn).trim();
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn == null ? "" : fornavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = ((etternavn == null) ? "" : etternavn);
	}

	public void setNavn(String fornavn, String etternavn) {
		setFornavn(fornavn);
		setEtternavn(etternavn);
	}

	public int getKontor() {
		return kontor;
	}

	public void setKontor(int kontor) {
		if (kontor > INTET_KONTOR) {
			this.kontor = kontor;
		} else {
			this.kontor = INTET_KONTOR;
			//throw new IllegalArgumentException("Kontornummer må være mer enn eller like -1");
		}
	}

	public boolean harKontorplass() {
		return getKontor() != INTET_KONTOR;
	}

	public AnsattV2[] getNaboer() {
		AnsattV2[] aArr = new AnsattV2[2];
		aArr[0] = getVenstreNabo();
		aArr[1] = getHoyreNabo();
		return aArr;
	}

	public AnsattV2 getVenstreNabo() {
		return naboVenstre;
	}

	public AnsattV2 getHoyreNabo() {
		return naboHoyre;
	}

	public void setNaboer(AnsattV2 venstreNabo, AnsattV2 hoyreNabo) {
		setVenstreNabo(venstreNabo);
		setHoyreNabo(hoyreNabo);
	}

	public void setVenstreNabo(AnsattV2 nabo) {
		naboVenstre = nabo;
	}

	public void setHoyreNabo(AnsattV2 nabo) {
		naboHoyre = nabo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getNavn());
		if (harKontorplass()) {
			sb.append(", kontornr ");
			sb.append(getKontor());
		} else {
			sb.append(", har ikke kontornr");
		}

		if (getVenstreNabo() != null) {
			sb.append(", har ");
			sb.append(getVenstreNabo().getNavn());
			sb.append(" som venstre nabo");
		}
		if (getHoyreNabo() != null) {
			sb.append(", har ");
			sb.append(getHoyreNabo().getNavn());
			sb.append(" som høyre nabo");
		}

		if ((getVenstreNabo() == null && getHoyreNabo() == null)) {
			sb.append(", har ikke satt noen naboer");
		}

		return sb.toString();
	}
}
