package w04.lib;

/*
 * Se w03.Ansatt for kommentarer i koden, da de er fjernet her
 */
public class Ansatt {
	private final int INTET_KONTOR = -1;
	private final int VENSTRE_NABO_INDEX = 0;
	private final int HOYRE_NABO_INDEX = 1;

	// denne er satt til private for  illustrere forskjellen p synlighetsmodifikatorer fra HovedProgram-klassen 
	private String fornavn = "";
	// denne er satt til protected for  illustrere forskjellen p synlighetsmodifikatorer fra HovedProgram-klassen i w03 vs w04
	// hva er forskjellen? Hvorfor fungerer eks i w03 mens ikke i w04?
	protected String etternavn = "";

	private int kontor = INTET_KONTOR;
	
	private Ansatt[] naboer;

	public Ansatt() { 
		this(null, null, -1);
	}

	public Ansatt(String fornavn) {
		this(fornavn, null, -1);
	}

	public Ansatt(String fornavn, String etternavn) {
		this(fornavn, etternavn, -1);
	}

	public Ansatt(String fornavn, String etternavn, int kontor) {
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
		}
	}

	public boolean harKontorplass() {
		return getKontor() != INTET_KONTOR;
	}
	
	public Ansatt[] getNaboer() {
		return naboer;
	}

	public Ansatt getVenstreNabo() {
		return getNabo(VENSTRE_NABO_INDEX);
	}

	public Ansatt getHoyreNabo() {
		return getNabo(HOYRE_NABO_INDEX);
	}

	public void setNaboer(Ansatt venstreNabo, Ansatt hoyreNabo) {
		setNabo(VENSTRE_NABO_INDEX, venstreNabo);
		setNabo(HOYRE_NABO_INDEX, hoyreNabo);
	}

	public void setVenstreNabo(Ansatt nabo) {
		setNabo(VENSTRE_NABO_INDEX, nabo);
	}
	
	public void setHoyreNabo(Ansatt nabo) {
		setNabo(HOYRE_NABO_INDEX, nabo);
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

		if (naboer != null) {
			if (getVenstreNabo() != null) {
				sb.append(", har ");
				sb.append(getVenstreNabo().getNavn());
				sb.append(" som venstre nabo");
			}
			if (getHoyreNabo() != null) {
				sb.append(", har ");
				sb.append(getHoyreNabo().getNavn());
				sb.append(" som hyre nabo");
			}
		}

		if (naboer == null || (getVenstreNabo() == null && getHoyreNabo() == null)) {
			sb.append(", har ikke satt noen naboer");
		}
		
		return sb.toString();
	}
	
	private Ansatt getNabo(int index) {
		return ((naboer != null) ? naboer[index] : null);
	}

	private void setNabo(int index, Ansatt nabo) {
		if (naboer == null) {
			naboer = new Ansatt[2];
		}
		
		naboer[index] = nabo;
	}
}
