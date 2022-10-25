package w08.filesandfolders;

public class FilesAndFoldersExample {
	private Folder root;

	private void runExample() {
		System.out.println("Initielle mappestruktur");
		root = new Folder("home", null);
		Folder borgeh = new Folder("borgeh", root);
		Folder hal = new Folder("hal", root);
		root.printTree();

		System.out.println(
				"\n'" + borgeh.getName() + "' i '" + hal.getName() + "'? " + (hal.contains(borgeh) ? "JA" : "NEI"));

		System.out.println("\nEndrer '" + borgeh.getName() + "' til 'kari'");
		borgeh.setName("kari");
		root.printTree();

		System.out.println(
				"\n'" + borgeh.getName() + "' i '" + hal.getName() + "'? " + (hal.contains(borgeh) ? "JA" : "NEI"));

		System.out.println("\nSkal flytte '" + borgeh.getName() + "' til '" + hal.getName() + "'");
		borgeh.move(hal);
		borgeh.printTree();

		System.out.println(
				"\n'" + borgeh.getName() + "' i '" + hal.getName() + "'? " + (hal.contains(borgeh) ? "JA" : "NEI"));

		new File("tmpfil.txt", root);
		new File("egenfil.txt", borgeh);
		File egenfil2 = new File("egenfil2.txt", borgeh);
		new File("tvillingfil.txt", borgeh);
		new File("tvillingfil.txt", hal);

		System.out.println("\nLagt til noen filer");
		root.printTree();

		System.out.println("\nFlytter '" + egenfil2.getName() + "' til '" + root.getName() + "'");
		egenfil2.move(root);
		root.printTree();

		System.out.println("\nFinn første (mappe) 'hal': " + root.findFirst("hal"));
		System.out.println("Finn første (fil) 'egenfil.txt': " + root.findFirst("egenfil.txt"));

		// legger til en ny mappe som heter kari i rota. Hva skje
		Folder kari = new Folder("kari", root);
		root.printTree();

		// hmm, er det en feil her? Ser du den? Skal vi fikse den?
		System.out.println("\nFinn alle (mapper) 'kari': " + root.findAll("kari"));
		System.out.println("Finn alle (filer) 'tvillingfil.txt': " + root.findAll("tvillingfil.txt"));

//		// etter en eventuelt fiks av feilen over...
//		// hva skjer om vi flytter 'kari' til 'hal', som allerede har en mappe som heter
//		// 'kari'?
//		kari.move(hal);
//		System.out.println("\nFinn alle (mapper) 'kari': " + root.findAll("kari"));
//		// Hva er problemet? Hva er dine forslag til å fikse denne? Et lite hint er at
//		// dette er en litt større jobb og som også bør gjelde for filer.

//		// Videre, hva hvis?
//		// kari.add(kari);
//		// System.out.println("\nFinn alle (mapper) 'kari': " + root.findAll("kari"));
//		// Som du ser er det flere problemer, men mer at dette er ikke ment å være en fullverdig implementasjon
	}

	public static void main(String[] args) {
		new FilesAndFoldersExample().runExample();
	}
}
