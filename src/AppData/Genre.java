package AppData;

public class Genre {
	private String genre = null;
	private int id = 0;
	
	public Genre(int Gid, String Ggenre) {
		genre = Ggenre;
		id = Gid;
	}
	
	public void setGenre(String Ggenre) {
		genre = Ggenre;
	}
	public String getGenre() {
		return genre;
	}
	
	public void setID(int Gid) {
		id = Gid;
	}
	public int getID() {
		return id;
	}
}
