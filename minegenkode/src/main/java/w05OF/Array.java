package w05OF;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Array {
	//når den først er lagd, kan man ikke endre den
	
	int[] liste = {1,2,3,4,5};
	//denne listen vil alltid ha 5 elemtener/posisisjoner
	
	
	//noe annet vi kan bruke er ArrayList
	List<String> liste2 = new ArrayList<String>();
	//denne er dynamisk, og kan endre lengde
	//String kan btttes ut med andre kompleske variabler. Altså ikke int, men Integer
	//en annen syntaks: 
	Collection<Integer> liste3 = new ArrayList<Integer>(); //her kan man ikke bruke indekser
	
	public static void main(String[] args) {
		//Hvorfor står det static??
			//Når man skriver en metode som ikke trenger tilgang til andre metoder
			//men den kan brukes selv når man ikke har lagd et objekt, kan man bruke statiske og metoder
		//final - betyr at et objekt ikke kan endres
	}
	
}
