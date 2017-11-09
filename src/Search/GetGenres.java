package Search;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import AppData.*;
import DataBase.*;

public class GetGenres {
	private ArrayList<Genre> genres = null;
	
	public GetGenres(HttpServletRequest request) {
		String sqlStatement = "select * from genres";
		genres = new ArrayList<Genre>();		
		ResultSet res = null;
		try {
			GetResult getResult = new GetResult();
			res = getResult.getResult(sqlStatement);
			while(res.next()) {
				Genre tempGenre = new Genre(res.getInt("genres.id"), res.getString("genres.name"));
				genres.add(tempGenre);
			}
			getResult.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Genre> getGenres() {
		return genres;
	}
}
