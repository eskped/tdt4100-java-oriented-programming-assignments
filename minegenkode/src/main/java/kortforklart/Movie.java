package kortforklart;

public class Movie implements Comparable<Movie> {

	private String name;
	private String genre;

	public Movie(String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + "]";
	}

	@Override
	public int compareTo(Movie o) {
		return this.getName().compareTo(o.getName());
	}

}
