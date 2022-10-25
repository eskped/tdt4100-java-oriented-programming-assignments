package w12.myprog;

public class MyProg {
	public static void main(String[] args) {
		System.out.println("-=".repeat(30));
		System.out.println("ORIGINAL");
		System.out.println("=-".repeat(30));
		
		var cycling = new w12.myprog.orig.Cycling();
		System.out.println("## SYKLING ##");
		System.out.println(cycling.toString());
		System.out.println(String.format("Distanse totalt: %.0fkm", cycling.calculateTotalDistance()));
		try {
			System.out.println("Skriver til fil: " + cycling.writeToFile());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println();

		var brewing = new w12.myprog.orig.Brewing();
		System.out.println("## BRYGGING ##");
		System.out.println(brewing.toString());
		System.out.println(String.format("Liter totalt: %.1fl", brewing.getLiters()));
		try {
			System.out.println("Skriver til fil: " + brewing.write());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-=".repeat(30));
		System.out.println("ARV");
		System.out.println("=-".repeat(30));

		var cycling2 = new w12.myprog.arv.Cycling();
		System.out.println("## SYKLING ##");
		System.out.println(cycling2.toString());
		System.out.println(String.format("Distanse totalt: %.0fkm", cycling2.calculateTotalDistance()));
		try {
			System.out.println("Skriver til fil: " + cycling2.writeToFile());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println();

		var brewing2 = new w12.myprog.arv.Brewing();
		System.out.println("## BRYGGING ##");
		System.out.println(brewing2.toString());
		System.out.println(String.format("Liter totalt: %.1fl", brewing2.getLiters()));
		try {
			System.out.println("Skriver til fil: " + brewing2.write());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-=".repeat(30));
		System.out.println("DELEGERING");
		System.out.println("=-".repeat(30));

		var cycling3 = new w12.myprog.delegering.Cycling();
		System.out.println("## SYKLING ##");
		System.out.println(cycling3.toString());
		System.out.println(String.format("Distanse totalt: %.0fkm", cycling3.calculateTotalDistance()));
		try {
			System.out.println("Skriver til fil: " + cycling3.writeToFile());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println();

		var brewing3 = new w12.myprog.delegering.Brewing();
		System.out.println("## BRYGGING ##");
		System.out.println(brewing3.toString());
		System.out.println(String.format("Liter totalt: %.1fl", brewing3.getLiters()));
		try {
			System.out.println("Skriver til fil: " + brewing3.write());			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
