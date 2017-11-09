
public class Star {
	private int id;
	private String first_name;
	private String last_name;
	private String dob;
	private String photo_url;
	
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
	public String getFirstname() {
		return first_name;
	}
	public String getLastname() {
		return last_name;
	}
	
	//dob
	
	public void setPhoto(String url) {
		photo_url = url;
	}
	public String getPhoto() {
		return photo_url;
	}
}
