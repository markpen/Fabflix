
public class Movie {
	private int id;
	private String title;
	private int year;
	private String director;
	private String banner_url;
	private String trailer_url;
	private double price;
	
	public void setID(int movieID) {
		id = movieID;
	}
	public int getID() {
		return id;
	}
	
	public void setTitle(String movieTitle) {
		title = movieTitle;
	}
	public String getTitle() {
		return title;
	}
	
	public void setYear(int movieYear) {
		year = movieYear;
	}
	public int getYear() {
		return year;
	}
	
	public void setDirect(String movieDirector) {
		director = movieDirector;
	}
	public String getDirector() {
		return director;
	}
	
	public void setBanner_url(String movieBanner_url) {
		banner_url = movieBanner_url;
	}
	public String getBanner_url() {
		return banner_url;
	}
	
	public void setTrailer_url(String movieTrailer_url) {
		trailer_url = movieTrailer_url;
	}
	public String getTrailer() {
		return trailer_url;
	}
	
	public void setPrice(double moviePrice) {
		price = moviePrice;
	}
	public double getPrice() {
		return price;
	}
}
