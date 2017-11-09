package AppData;

import java.util.*;

public class Movie extends SampleMovie{
	/*
	private int id;
	private String title;
	private int year;
	private String director;
	private String banner_url;
	private String trailer_url;
	private double price;
	*/
	private ArrayList<Star> stars;
	private ArrayList<Genre> genres;
	
	public Movie() {
		id = 0;
		title = null;
		year = 0 ;
		director = null;
		banner_url = null;
		trailer_url = null;
		price = 0.0;
		stars = new ArrayList<Star>();
		genres = new ArrayList<Genre>();
	}
	public Movie(int Mid, String Mtitle, int Myear, String Mdirector, String Mbanner_url, String Mtrailer_url) {
		id = Mid;
		title = Mtitle;
		year = Myear;
		director = Mdirector;
		banner_url = Mbanner_url;
		trailer_url = Mtrailer_url;
		price = 0.0;
		stars = new ArrayList<Star>();
		genres = new ArrayList<Genre>();
	}
	
	/*
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
	*/
	public void setStars(ArrayList<Star> Mstars) {
		stars = Mstars;
	}
	public void addStar(Star star) {
		stars.add(star);
	}
	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public void addGenre(Genre genre) {
		genres.add(genre);
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}
}
