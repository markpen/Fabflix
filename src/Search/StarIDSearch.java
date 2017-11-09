package Search;

import AppData.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import DataBase.*;

public class StarIDSearch {
	private int ID = 0;;
	private ArrayList<Star> stars = null;
	
	public StarIDSearch(HttpServletRequest request) {
		String id = request.getParameter("starID");
		ID = Integer.parseInt(id);
		stars = new ArrayList<Star>();
	}
	public StarIDSearch(String id) {
		ID = Integer.parseInt(id);
		stars = new ArrayList<Star>();
	}
	public StarIDSearch(int id) {
		ID = id;
		stars = new ArrayList<Star>();
	}
	
	public ArrayList<Star> getStar() {
		getStars();
		return stars;
	}
	
	private void getStars() {
		String condition = " where stars.id = " + String.valueOf(ID);
		String getAttribute = "select stars.id, stars.first_name, stars.last_name, stars.dob, stars.photo_url,"
							+ " movies.id, movies.title, movies.year, movies.director, movies.banner_url, movies.trailer_url"
							+ " from stars"
							+ " inner join stars_in_movies on stars_in_movies.star_id = stars.id"
							+ " inner join movies on movies.id = stars_in_movies.movie_id";
		//System.out.println(getAttribute + condition);
		try {
			GetResult getResult = new GetResult();
			ResultSet res = getResult.getResult(getAttribute + condition);
			
			HashMap<Integer, Star> starMap = new HashMap<Integer, Star>();
			while(res.next()) {
				int id = res.getInt("stars.id");
				SampleMovie movie = new SampleMovie(res.getInt("movies.id"),
													res.getString("movies.title"),
													res.getInt("movies.year"),
													res.getString("movies.director"),
													res.getString("movies.banner_url"),
													res.getString("movies.trailer_url"));
				
				if(starMap.containsKey(id)) {
					
					starMap.get(id).addMovie(movie);
																
				}
				else {
					Star star = new Star(res.getInt("stars.id"),
										 res.getString("stars.first_name"),
										 res.getString("stars.last_name"),
										 res.getString("stars.dob"),
										 res.getString("stars.photo_url"));
					star.addMovie(movie);
					starMap.put(id, star);
				}
			}
			for(int m : starMap.keySet()) {
				stars.add(starMap.get(m));
			}
			
			getResult.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
