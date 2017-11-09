package AppData;

import java.util.*;

public class Star {
	private int id = 0;
	private String first_name = null;
	private String last_name = null;
	private String dob = null;
	private String photo_url = null;
	private ArrayList<SampleMovie> movies = null;
	
	public Star(int Sid, String Sfirst_name, String Slast_name, String Sdob, String Sphoto_url) {
		id = Sid;
		first_name = Sfirst_name;
		last_name = Slast_name;
		dob = Sdob;
		photo_url = Sphoto_url;
		movies = new ArrayList<SampleMovie>();
	}
	
	public void setID(int starID) {
		id = starID;
	}
	public int getID() {
		return id;
	}
	
	public void setName(String first, String last) {
		first_name = first;
		last_name = last;
	}
	public String getName() {
		return first_name + " " + last_name;
	}
	public String getFirstname() {
		return first_name;
	}
	public String getLastname() {
		return last_name;
	}
	
	//dob
	public void setDob(String stardob) {
		dob = stardob;
	}
	public String getDob() {
		return dob;
	}
	
	public void setPhoto(String url) {
		photo_url = url;
	}
	public String getPhoto() {
		return photo_url;
	}
	
	public void addMovie(SampleMovie starMovie) {
		movies.add(starMovie);
	}
	public void addMovies(ArrayList<SampleMovie> starMovies) {
		movies.addAll(starMovies);
	}
	public ArrayList<SampleMovie> getMovies() {
		return movies;
	}
}
