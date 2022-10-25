package w03;



	/*
	 * I denne klassen er det lagt til ekstra mange kommentarer for � gi en slags
	 * oppsummering av forelesninger s� langt, samt noen generelle tips.
	 */

	/*
	 * Her deklarerer vi en klassen med klassenavnet Ansatt i pakken w03. Det er kun en 
	 * klasse i w03 som kan hete Ansatt.
	 */
	public class Ansatt {
		/*
		 * Merk at vanlig praksis for kodeoppbygging er � deklarere globale variabler
		 * tidlig i klassedeklarasjonen.
		 */

		/*
		 * INTET_KONTOR er en konstant, dvs at den ikke kan endres underveis. At det er
		 * en konstant ser vi p� to m�ter, f�rst og fremst ved at vi har final, men ogs�
		 * ved at vi benytter standard kodekonvensjonen som sier at konstanter skal v�re
		 * store bokstaver og ord delt opp med _
		 */
		
		private final int INTET_KONTOR = -1;
		private final int VENSTRE_NABO_INDEX = 0;
		private final int HOYRE_NABO_INDEX = 1;

		/*
		 * Standardverdi for String hvis den ikke er satt eksplisitt er null, men i
		 * dette tilfellet setter vi den til "" som vil si en tom streng.
		 */
		// denne er satt til private for � illustrere forskjellen p� synlighetsmodifikatorer fra HovedProgram-klassen 
		private String fornavn = "";
		// denne er satt til protected for � illustrere forskjellen p� synlighetsmodifikatorer fra HovedProgram-klassen 
		protected String etternavn = "";

		/*
		 * Standardverdi for int hvis den ikke er satt eksplisitt er 0, men vi setter
		 * den til INTET_KONTOR i dette tilfellet med den antagelsen at det ikke er noen
		 * ansatte som har kontor i kjelleren, det f�r da v�re grenser... ;)
		 */
		private int kontor = INTET_KONTOR;
		
		/*
		 * Liste med naboer
		 */
		private Ansatt[] naboer;

		/*
		 * En tom konstrukt�r er standard hvis ingen konstrukt�r er deklarert for en
		 * klasse. I tilfeller hvor vi har flere konstrukt�rer m� en eksplisitt
		 * deklarere en tom konstrukt�r hvis klassen skal tillate bruken av en tom
		 * konstrukt�r.
		 */
		public Ansatt() {
			/*
			 * Selv om denne er tom s� kaller denne konstrukt�ren egentlig sin superklasse
			 * (forelder) som er Object klassen. Alle klasser i Java er underklasser av
			 * klassen Object, dette er rot-klassen.
			 */
			// Fra Object-klasse-dokumentasjonen.
			// Den kan du for�vrig finne ved � markere super() og trykke F3 (Windows)
			/*
			 * Class Object is the root of the class hierarchy. Every class has Object as a
			 * superclass. All objects, including arrays, implement the methods of this
			 * class.
			 */
			/*
			 * Dette er egentlig et un�dvendig kall da den kj�res uansett. Typiske tilfeller
			 * hvor en benytter super() er hvis superklassen har flere konstrukt�rer og en
			 * �nsker � kalle en spesiell variant (med parametre) av denne og ikke
			 * standardvarianten.
			 */
			super();
		}

		/*
		 * Ved � ha flere konstrukt�rer �ker vi fleksibiliteten for bruken av
		 * Ansatt-klassen. Flere konstrukt�rer er mulig da de har forskjellige
		 * parametre, men merk at det er antallet og rekkef�lgen av datatypene til
		 * parametrene som avgj�r forskjellen.
		 */

		/*
		 * Merk at siden vi har en konstrukt�ren "Ansatt(String fornavn)" kan vi ikke
		 * legge til en annen konstrukt�r for etternavn som "Ansatt(String etternavn)"
		 * da begge har samme antall parametre (1) og like datatyper (String).
		 */
		public Ansatt(String fornavn) {
			// vi utelater super() i dette tilfellet da det ikke er n�dvendig
			setFornavn(fornavn);
		}

		/*
		 * Men for denne konstrukt�ren legger vil til en ny parameter og det er lov...
		 */
		public Ansatt(String fornavn, String etternavn) {
			setNavn(fornavn, etternavn);
		}

		public Ansatt(String fornavn, String etternavn, int kontor) {
			setNavn(fornavn, etternavn);
			setKontor(kontor);
		}

		public String getNavn() {
			/*
			 * her benytter vi string format for � sette sammen tre strenger vi kunne ha
			 * gjort det samme ved � skrive
			 */
			// return (fornavn + " " + etternavn).trim();
			/*
			 * vi benytter trim() til � fjerne eventuelle blanke mellomrom
			 */
			// OPPGAVE? Hva skjer hvis fornavn og/eller etternavn ikke er satt?
			return String.format("%s %s", fornavn, etternavn).trim();
		}

		public String getFornavn() {
			/*
			 * ikke behove for � benytte this.fornavn da det er ingen lokal variabel med
			 * samme variabelnavn
			 */
			return fornavn;
		}

		public String getEtternavn() {
			return etternavn;
		}

		public void setFornavn(String fornavn) {
			/*
			 * TIPS! Dette er en fullt lovelig m�te � skrive dette utrykket p�, men den er
			 * ikke s� lesbar
			 */
			this.fornavn = fornavn == null ? "" : fornavn;
		}

		public void setEtternavn(String etternavn) {
			/*
			 * TIPS! Dette er en bedre og mer lesbar m�te � skrive tilsvarende kode som for
			 * setFornavn
			 */
			this.etternavn = ((etternavn == null) ? "" : etternavn);
		}

		public void setNavn(String fornavn, String etternavn) {
			// her kan vi like godt benytte de metodene vi har
			setFornavn(fornavn);
			setEtternavn(etternavn);
		}

		public int getKontor() {
			return kontor;
		}

		public void setKontor(int kontor) {
			/*
			 * bruker this.kontor for � ref til global variabel mens kontor er lokal
			 * variabel. I tillegg legger vi inn en liten sjekk for � vise fordelen med � ha
			 * en setter metode
			 */
			/*
			 * TIPS! For lesbarhet b�r du alltid ha med {} for if, for, ol, da det �ket
			 * lesbarheten, selvom det for tillefellet under er fullt mulig � utelate {}
			 */
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
		
		/*
		 * Her viser vi override av toString metoden fra Object klassen
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append(getNavn());
			if (harKontorplass()) {
				sb.append(", kontornr ");
				sb.append(getKontor());
			}
			else {
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
					sb.append(" som h�yre nabo");
				}			
			}
			// hvorfor sjekk av om naboerlisten og dens verdier er null? Er det behov for det? 
			if (naboer == null || (getVenstreNabo() == null && getHoyreNabo() == null)) {
				sb.append(", har ikke satt noen naboer");
			}		
			return sb.toString();
		}
		
		// dette er et par privat hjelpefunksjoner 
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


