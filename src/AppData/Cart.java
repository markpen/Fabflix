package AppData;

import java.util.*;

public class Cart {
	private double sum;
	private HashMap<Integer, Movie> movieMap = null;
	public Cart() {
		sum = 0;
		movieMap = new HashMap<Integer, Movie>();
	}
	
	public void addMovie(Movie mymovie) {
		movieMap.put(mymovie.getID(), mymovie);
		sum += mymovie.getPrice();
	}
	
	public ArrayList<Movie> showMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		for(int id : movieMap.keySet()) {
			movies.add(movieMap.get(id));
		}
		return movies;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void clearAll() {
		movieMap.clear();
		sum = 0;
	}
	
	public void removeMovie(Movie mymovie) {
		movieMap.remove(mymovie.getID());
		sum -= mymovie.getPrice();
	}
}
