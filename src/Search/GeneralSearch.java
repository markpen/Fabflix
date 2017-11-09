package Search;

import AppData.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import DataBase.*;

public class GeneralSearch {
	private String ID = null;
	private String title = null;
	private String year = null;
	private String director = null;
	private String lastName = null;
	private String firstName = null;
	
	private ArrayList<Movie> movies = null;
	
	GeneralSearch(HttpServletRequest request) {
		if(request.getParameter("ID") != null)			ID = request.getParameter("ID");
		if(request.getParameter("title") != null) 		title = request.getParameter("title");
		if(request.getParameter("year") != null) 		year = request.getParameter("year");
		if(request.getParameter("director") != null) 	director = request.getParameter("director");
		if(request.getParameter("lastName") != null) 	lastName = request.getParameter("lastName");
		if(request.getParameter("firstName") != null) 	firstName = request.getParameter("firstName");
		movies = new ArrayList<Movie>();
		
		
	}
	
	public ArrayList<Movie> getMovieList() {
		getMovies();
		return movies;
	}
	
	private void getMovies() {
		ResultSet res = null;
		
		String condition = " where 1 = 1";
		if(ID != null && !ID.isEmpty())					condition += (" and movies.id = " + ID);
		if(title != null && !title.isEmpty()) 			condition += (" and movies.title = '" + title + "'");
		if(year != null && !year.isEmpty()) 			condition += (" and movies.year = " + year);
		if(director != null && !director.isEmpty()) 	condition += (" and movies.director = '" + director + "'");
		if(firstName != null && !firstName.isEmpty()) 	condition += (" and stars.first_name = '" + firstName + "'");
		if(lastName != null && !lastName.isEmpty()) 	condition += (" and stars.last_name = '" + lastName + "'");
			
		String getAttribute = "select movies.id, movies.title, movies.year, movies.director, movies.banner_url,"
							+ " movies.trailer_url, stars.id, stars.first_name, stars.last_name, stars.dob, stars.photo_url"
							+ " from movies"
							+ " inner join stars_in_movies on stars_in_movies.movie_id = movies.id"
							+ " inner join stars on stars_in_movies.star_id = stars.id";
		
		try {
			//GetConnection getConnection = new GetConnection();
			//connection = getConnection.getConnection();
		
			//prepare = connection.prepareStatement(getAttribute + condition);
			//res = prepare.executeQuery();
			GetResult getResult = new GetResult();
			res = getResult.getResult(getAttribute + condition);
			
			HashMap<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
			while(res.next()) {
				Star star = new Star(res.getInt("Stars.id"), 
									 res.getString("Stars.first_name"), 
									 res.getString("Stars.last_name"),
									 res.getString("Stars.dob"), 
									 res.getString("stars.photo_url"));
				
				int movieID = res.getInt("movies.id");
				if(movieMap.containsKey(movieID)) {
					movieMap.get(movieID).addStar(star);
				}
				else {
					Movie movie = new Movie(res.getInt("movies.id"), 
											res.getString("movies.title"), 
											res.getInt("movies.year"),
											res.getString("movies.director"), 
											res.getString("movies.banner_url"), 
											res.getString("movies.trailer_url"));
					movie.addStar(star);
					movieMap.put(movieID, movie);
				}
			}
			
			
			String genreCondition = " where genres_in_movies.movie_id = ";
			String genreGetAttribute = "select genres.name, genres.id from genres inner join genres_in_movies on"
									 + " genres.id = genres_in_movies.genre_id";
			for(int m: movieMap.keySet()) {
				//System.out.println(genreGetAttribute + genreCondition + String.valueOf(movieMap.get(m).getID()));
				//prepare = connection.prepareStatement(genreGetAttribute + genreCondition + String.valueOf(movieMap.get(m).getID()));
				res = getResult.getResult(genreGetAttribute + genreCondition + String.valueOf(movieMap.get(m).getID()));
				while(res.next()) {
					Genre genre = new Genre(res.getInt("genres.id"), res.getString("genres.name"));
					movieMap.get(m).addGenre(genre);
				}
				movies.add(movieMap.get(m));
			}
			
			getResult.close();
			//getConnection.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
