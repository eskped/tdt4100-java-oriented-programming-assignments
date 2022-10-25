package w10.garbage;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Med denne klassen viser vi litt forskjellige løkkestrukturer og tidsbruk og
 * minnebruk i forhold til å lage objekter under veis i en løkke.
 * 
 * Det er også tatt med informasjon om minnet før og etter, men som du vil se er
 * det litt sånn i hytt og pine, pga garbage collection (GC) som kjøres når det
 * er nødvendig/tid/resurser ledig/osv, en komplisert prosess som tar hensyn til
 * mange faktorer. Det er feks ikke nødvendigvis det beste å ha mest mulig minne
 * tilgjengelig til enhver tid, men bare til en viss grad. Mao er GC også
 * avhengig av hvor mye minne som er tilgjengelig på maskinen.
 * 
 * Merk at når en skal kjøre slike tester så er alltid minimum første runde,
 * gjerne flere alt etter som hva du skal måle, en/flere oppvarmingsrunde(r).
 * Det er som med alt annet her i verden det krever litt å komme i gang.
 * 
 * @author steinlt
 *
 */
public class GC {
	private final int ITERATIONS = 10000000; // 10M

	/**
	 * Her benytter vi ingen referanse i det hele tatt, vi bare oppretter objekter i
	 * løkken
	 */
	private void noRefLoopEx() {
		Instant start = Instant.now();

		long memBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < ITERATIONS; i++) {
			new Simple("Some name", 34, new Date());
		}
		long memAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		Instant end = Instant.now();
		System.out.println("noRefLoopEx => Duration:: " + Duration.between(start, end).toMillis() + "ms, memory diff:: "
				+ (memAfter - memBefore) / 1024 + "kB");
	}

	/**
	 * Her lager vi en ny referanse i løkken for hver gang vi oppretter et objekt i
	 * løkken
	 */
	private void refInsideLoopEx() {
		Instant start = Instant.now();

		long memBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < ITERATIONS; i++) {
			Simple ref = new Simple("Some name", 34, new Date());
		}
		long memAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		Instant end = Instant.now();
		System.out.println("refInsideLoopEx => Duration:: " + Duration.between(start, end).toMillis()
				+ "ms, memory diff:: " + (memAfter - memBefore) / 1024 + "kB");
	}

	/**
	 * Her tilordner vi et objekt til en referanse som er gyldig utenfor løkken,
	 * hvert objekt som blir laget blir tilordnet samme objekt referanse
	 */
	private void refOutsideLoopEx() {
		Instant start = Instant.now();

		long memBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		Simple ref;
		for (int i = 0; i < ITERATIONS; i++) {
			ref = new Simple("Some name", 34, new Date());
		}
		long memAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		Instant end = Instant.now();
		System.out.println("refOutsideLoopEx => Duration:: " + Duration.between(start, end).toMillis()
				+ "ms, memory diff:: " + (memAfter - memBefore) / 1024 + "kB");
	}

	public static void main(String[] args) {
		GC gc = new GC();
		System.out.println("=".repeat(70));
		for (int i = 1; i <= 10; i++) {
			System.out.println("#" + i);
			System.out.println("-".repeat(70));
			gc.noRefLoopEx();
			gc.refInsideLoopEx();
			gc.refOutsideLoopEx();
			System.out.println("=".repeat(70));
		}

	}

	private static class Simple {
		private String name;
		private int age;
		private Date created;

		public Simple(String name, int age, Date created) {
			this.name = name;
			this.age = age;
			this.created = created;
		}
	}
}
