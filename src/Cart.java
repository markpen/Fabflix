
import java.util.ArrayList;

public class Cart {
	private double sum;
	private ArrayList<Movie> movies;
	Cart() {
		sum = 0;
	}
	
	public void addMovie(Movie mymovie) {
		movies.add(mymovie);
		sum += mymovie.getPrice();
	}
	
	public ArrayList<Movie> showMovie() {
		return movies;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void clearAll() {
		movies.clear();
		sum = 0;
	}
	
	public void removeMovie(Movie mymovie) {
		if(movies.remove(mymovie)) {
			sum -= mymovie.getPrice();
		}
	}
}
