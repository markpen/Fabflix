package AppData;


public class SampleMovie {
	protected int id;
	protected String title;
	protected int year;
	protected String director;
	protected String banner_url;
	protected String trailer_url;
	protected double price;

	
	public SampleMovie() {
		id = 0;
		title = null;
		year = 0 ;
		director = null;
		banner_url = null;
		trailer_url = null;
		price = 0.0;
		
	}
	public SampleMovie(int Mid, String Mtitle, int Myear, String Mdirector, String Mbanner_url, String Mtrailer_url) {
		id = Mid;
		title = Mtitle;
		year = Myear;
		director = Mdirector;
		banner_url = Mbanner_url;
		trailer_url = Mtrailer_url;
		price = 0.0;
		
	}
	
	
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
