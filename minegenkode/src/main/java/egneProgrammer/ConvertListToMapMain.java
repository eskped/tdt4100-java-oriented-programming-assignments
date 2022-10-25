package egneProgrammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kortforklart.Movie;

public class ConvertListToMapMain {

	Movie standardMvie;

	public static void main(String[] args) {

		List<Movie> moviesList = getListOfMovies();
		
		
		Map<String, String> moviesMap = moviesList.stream()
				.collect(Collectors.toMap(m -> m.getName(), m -> m.getGenre()));
		System.out.println(moviesMap);
		
		
		Map<String, String> moviesMap2 = moviesList.stream()
				.collect(Collectors.toMap(Movie::getName, Movie::getGenre));
		System.out.println(moviesMap2);
		
		moviesList.add(new Movie("Matrix", "Comedy"));
		Map<String, String> moviesMap3 = moviesList.stream()
				.collect(Collectors.toMap(m -> m.getName(), m -> m.getGenre(), (oldValue,newValue) -> newValue));
		System.out.println(moviesMap3);
		
		
		
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
