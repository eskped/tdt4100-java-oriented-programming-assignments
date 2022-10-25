package w09.casting;

/**
 * Her demonstrerer vi casting. Benytt PlantUML for å få en grafisk fremstilling
 * av hierarkiet som blir benyttet.
 * 
 * @author steinlt
 *
 */
public class CastingExample {
	public void primitiveCastingExample() {
		long l = 38;
		System.out.println("Originalt tall " + l);
		System.out.println("Kaste long til float " + (float) l);
		System.out.println("Kaste long til double " + (double) l);
		System.out.println("Kaste long til int " + (int) l);
		System.out.println("Kaste long til char (ASCII-tegn) " + (char) l);
		System.out.println("Kaste long til byte " + (byte) l);
		System.out.println("Kaste long til short " + (short) l);
		System.out.println("Kaste long til double for så tilbake til long " + (long) (double) l);

//		double d = 38.7654d;
//		System.out.println("\nOriginalt flyttall " + d);
//		System.out.println("Kaste double til float " + (float) d);
//		System.out.println("Kaste double til int " + (int) d);
//		System.out.println("Kaste double til long " + (long) d);
//		System.out.println("Kaste double til char (ASCII-tegn) " + (char) d);
//		System.out.println("Kaste double til byte " + (byte) d);
//		System.out.println("Kaste double til short " + (short) d);
//		System.out.println("Kaste double til long for så tilbake til double " + (double) (long) d + " Upsk!!! Mistet vi noe?");
	}

	public void referenceCastingExample() {
		// Rovdyr er superklassen til Katt og Hund
		Object rovdyr = new Rovdyr();
		// Har superklasse Rovdyr og subklasse Pusur
		Object katt = new Katt();
		// Har superklasse Katt og implementerer Fiksjon
		Object pusur = new Pusur();
		// Har superklasse Rovdyr og subklasse Lassie
		Object hund = new Hund();
		// Har superklasse Hund og implementerer Fiksjon
		Object lassie = new Lassie();

		System.out.println("## KLASSEHIERARKI ##");
		System.out.println(rovdyr);
		System.out.println(katt);
		System.out.println(hund);
		System.out.println(pusur);
		System.out.println(lassie);

		// vi kan sjekke om vi kan kaste ved å benytte instanceof
//		System.out.println("\n## ROVDYR ##");
//		System.out.println("Kan vi kaste 'rovdyr' oppover til Object? " + (rovdyr instanceof Object));
//		System.out.println("Kan vi kaste 'rovdyr' nedover til Katt? " + (rovdyr instanceof Katt));
//		System.out.println("Kan vi kaste 'rovdyr' nedover til Hund? " + (rovdyr instanceof Hund));

//		System.out.println("\n## KATT ##");
//		System.out.println("Kan vi kaste 'katt' oppover til Object? " + (katt instanceof Object));
//		System.out.println("Kan vi kaste 'katt' oppover til Rovdyr? " + (katt instanceof Rovdyr));
//		System.out.println("Kan vi kaste 'katt' nedover til Pusur? " + (katt instanceof Pusur));
//		System.out.println("Kan vi kaste 'katt' til Fiksjon? " + (katt instanceof Fiksjon));
//		System.out.println("Hvis vi først kaster 'katt' oppover til Rovdyr kan vi så kaste den ned igjen til Katt? " + (((Rovdyr) katt) instanceof Katt));
//		System.out.println("Hvis vi først kaster 'katt' oppover til Rovdyr kan vi så kaste den ned til Hund? " + (((Rovdyr) katt) instanceof Hund));
//
//		System.out.println("\n## HUND ##");
//		System.out.println("Kan vi kaste 'hund' oppover til Object? " + (hund instanceof Object));
//		System.out.println("Kan vi kaste 'hund' oppover til Rovdyr? " + (hund instanceof Rovdyr));
//		System.out.println("Kan vi kaste 'hund' nedover til Lassie? " + (hund instanceof Lassie));
//		System.out.println("Kan vi kaste 'hund' til Fiksjon? " + (hund instanceof Fiksjon));
//		System.out.println("Hvis vi først kaster 'hund' oppover til Rovdyr kan vi så kaste den ned igjen til Hund? " + (((Rovdyr) hund) instanceof Hund));
//		System.out.println("Hvis vi først kaster 'hund' oppover til Rovdyr kan vi så kaste den ned til Katt? " + (((Rovdyr) hund) instanceof Katt));

//		System.out.println("\n## KASTING ##");
//		Object obj = new Object();
//		printFakta(obj);
	}

	public void printFakta(Object obj) {
		if (obj instanceof Rovdyr)
			System.out.println("Rovdyr => " + ((Rovdyr) obj).faktaOmRovdyr());
		else
			System.err.println("Ikke Rovdyr");

		if (obj instanceof Hund)
			System.out.println("Hund => " + ((Hund) obj).faktaOmHund());
		else
			System.err.println("Ikke Hund");

		if (obj instanceof Katt)
			System.out.println("Katt => " + ((Katt) obj).faktaOmKatt());
		else
			System.err.println("Ikke Katt");

		if (obj instanceof Lassie)
			System.out.println("Lassie => " + ((Lassie) obj).faktaOmLassie());
		else
			System.err.println("Ikke Lassie");

		if (obj instanceof Pusur)
			System.out.println("Pusur => " + ((Pusur) obj).faktaOmPusur());
		else
			System.err.println("Ikke Pusur");

		if (obj instanceof Fiksjon)
			System.out.println("Fiksjon => " + ((Fiksjon) obj).faktaOmFiksjon());
		else
			System.err.println("Ikke Fiksjon");
	}

	public static void main(String[] args) {
		(new CastingExample()).primitiveCastingExample();
	}
}
