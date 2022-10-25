package egneProgrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import kortforklart.Movie;


public class StreamSorting {
	
	private static ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1));
	
	static List<String> listOfLanguages = Arrays.asList(new String[] { "Python", "C++", "Java", "PHP" });
	
	
	public static void main(String[] args) {
		sortNumbers();
		sortNumbersDesending();
		sortAlphabetic();
		sortReversedAlphabetic();
		sortObjectsOnName();
		sortObjectsOnGenreAndName();
	}
	
	private static void sortNumbers() {
		System.out.println(">Sorterer til ny arraylist i stigende rekkefølge");
		ints = ints.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(ints);
		
	}
	
	private static void sortNumbersDesending() {
		System.out.println("\n>Sorterer til ny arraylist i reversert stigende rekkefølge");
		ints = ints.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(ints);
	}
	
	private static void sortAlphabetic() {
		System.out.println("\n>Sorterer String etter alfabetisk rekkefølge");
		System.out.println(listOfLanguages.stream()
				.sorted().collect(Collectors.toList()));
		
	}
	
	private static void sortReversedAlphabetic() {
		System.out.println("\n>Sorterer String etter motsatt alfabetisk rekkefølge");
		System.out.println(listOfLanguages.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList()));
	}
	
	private static void sortObjectsOnName() {
		System.out.println("\n>Sorterer objekt etter navn i alfabetisk rekkefølge");
		System.out.println(getListOfMovies().stream()
				.sorted((M1,M2) -> M1.getName().compareTo(M2.getName()))
				.collect(Collectors.toList()));
	}
	
	private static void sortObjectsOnNameReversed() {
		System.out.println("\n>Sorterer objekt etter navn på motsatt alfabetisk rekkefølge");
		System.out.println(getListOfMovies().stream()
				.sorted((M1,M2) -> M2.getName().compareTo(M1.getName()))
				.collect(Collectors.toList()));

	}
	
	private static void sortObjectsOnGenreAndName() {
		System.out.println("\n>Sorterer objekt etter navn på sjanger og navn på film i alfabetisk rekkefølge");
		System.out.println(getListOfMovies().stream()
				.sorted(Comparator.comparing(Movie::getGenre).thenComparing(Movie::getName))
				.collect(Collectors.toList()));
	}
	

	
	
	public static List<Movie> getListOfMovies() {
		List<Movie> moviesList = new ArrayList<>();

		Movie m1 = new Movie("3 idiots", "Comedy");
		Movie m2 = new Movie("Interstellar", "SciFi");
		Movie m3 = new Movie("Forest gump", "Comedy");
		Movie m4 = new Movie("Matrix", "SciFi");
		Movie m5 = new Movie("The Hangover", "Comedy");

		moviesList.add(m1);
		moviesList.add(m2);
		moviesList.add(m3);
		moviesList.add(m4);
		moviesList.add(m5);

		return moviesList;
	}
	
}
