package w08.overloading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Ved overloading/overlasting er det mulig å ha samme metodenavn, men med
 * forskjellige parametre. Det som er avgjørende er at alle metodenes signaturer
 * er unike for samme klasse. En metodes signatur består av metodenavnet og dens
 * parametre. En metode med samme metodenavn MÅ ha parametre med datatyper i
 * forskjellig rekkefølge. Det er altså IKKE tilstrekke at navnene på
 * parametrene og deres rekkefølge er forkjellig for metoder med samme navn.
 * Siden metodens signatur ikke inkluderer eventuelle returnerte datatyper kan
 * metoder med samme metodenavn returnere forskjellige datatyper der hvor det er
 * naturlig.
 * 
 * @author steinlt
 *
 */
public class OverloadingExample {
	/*
	 * Her følger to eksempler på overlasting.
	 */
	private String convertToString(int value) {
		return String.format("%d", value);
	}

	private String convertToString(float value) {
		return String.format("%d", value);
	}

	/*
	 * Her følger to eksempler på overlasting hvor også metodene returnere
	 * forskjellige datatyper.
	 */
	private ArrayList<String> reverseContent(ArrayList<String> arr) {
		if (arr != null)
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) != null) {
					String revStr = "";
					for (int j = arr.get(i).length() - 1; j >= 0 ; j--)
						revStr += arr.get(i).charAt(j);
					arr.set(i, revStr);
				}
			}

		return arr;
	}
	
	private String[] reverseContent(String[] arr) {
		if (arr != null)
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null) {
					String revStr = "";
					for (int j = arr[i].length() - 1; j >= 0 ; j--)
						revStr += arr[i].charAt(j);
					arr[i] = revStr;
				}
			}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println("OverloadingExample");

		String[] arr = { "item1", "item2", "item3", "item4" };
		ArrayList<String> arrLst = new ArrayList<String>(Arrays.asList(arr));

		OverloadingExample ex = new OverloadingExample();
		System.out.println("\nFør endring av lister".toUpperCase());
		System.out.println("Verdier i arr:");
		OverloadingExample.print(arr);
		System.out.println("Verdier i arrLst:");
		OverloadingExample.print(arrLst);

		System.out.println("\nEtter endring av lister".toUpperCase());
		System.out.println("Verdier i arr:");
		OverloadingExample.print(ex.reverseContent(arr));
		System.out.println("Verdier i arrLst:");
		OverloadingExample.print(ex.reverseContent(arrLst));
	}

	private static void print(String[] arr) {
		if (arr != null)
			OverloadingExample.print(Arrays.asList(arr));
	}

	private static void print(List<String> arr) {
		if (arr != null) {
			String toPrint = "";
			for (Iterator<String> iterator = arr.iterator(); iterator.hasNext();)
				toPrint += String.format("\"%s\"%s", iterator.next(), (iterator.hasNext() ? ", " : ""));
			System.out.println(toPrint);
		}
	}
}
