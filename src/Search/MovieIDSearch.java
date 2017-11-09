package Search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import AppData.*;
import DataBase.*;


public class MovieIDSearch {
	private String ID = null;
	private ArrayList<Movie> movies = null;
	
	
	public MovieIDSearch(HttpServletRequest request) {
		if(request.getParameter("movieID") != null) ID = request.getParameter("movieID");
		movies = new ArrayList<Movie>();
	}
	
	public MovieIDSearch(int id) {
		ID = String.valueOf(id);
		movies = new ArrayList<Movie>();
	}
	public MovieIDSearch(String id) {
		ID = id;
		movies = new ArrayList<Movie>();
	}
	
	public ArrayList<Movie> getFullMovies() {
		FullMovies();
		return movies;
	}
	
	private void FullMovies() {
		String condition = " where movies.id = " + ID; 
		String getAttribute = "select movies.id, movies.title, movies.year, movies.director, movies.banner_url, movies.trailer_url,"
							+ " stars.id, stars.first_name, stars.last_name, stars.dob, stars.photo_url,"
							+ " genres.id, genres.name"
							+ " from movies"
							+ " inner join stars_in_movies on stars_in_movies.movie_id = movies.id"
							+ " inner join stars on stars_in_movies.star_id = stars.id"
							+ " inner join genres_in_movies on genres_in_movies.movie_id = movies.id"
							+ " inner join genres on genres_in_movies.genre_id = genres.id";
		//movieID, starID, starID
		HashMap<Integer, HashMap<Integer, Integer>> starMap = new HashMap<Integer, HashMap<Integer, Integer>>();
		//movieID, genreID, genreID
		HashMap<Integer, HashMap<Integer, Integer>> genreMap = new HashMap<Integer, HashMap<Integer, Integer>>();
		HashMap<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
		try {
			//System.out.println(getAttribute + condition); 
			GetResult getResult = new GetResult();
			ResultSet res = getResult.getResult(getAttribute + condition);
			//System.out.println("get the results");
			while(res.next()) {
				Star star = new Star(res.getInt("Stars.id"), 
						 			 res.getString("Stars.first_name"), 
						 			 res.getString("Stars.last_name"),
						 			 res.getString("Stars.dob"), 
						 			 res.getString("stars.photo_url"));
				Genre genre = new Genre(res.getInt("genres.id"), res.getString("genres.name"));
				
				int movieID = res.getInt("movies.id");
				int starID = res.getInt("stars.id");
				int genreID = res.getInt("genres.id");
				//System.out.println("movieID = " + movieID + " starID = " + starID + " genreID = " + genreID);
				
				if(movieMap.containsKey(movieID)) {
					//System.out.println("find an exited movie");
					//bug here
					HashMap<Integer, Integer> temphash = starMap.get(movieID);
					//System.out.println("here");
					if(temphash.containsKey(starID))
					//System.out.println("no bug");
					
					
					if(starMap.get(movieID).containsKey(starID) == false) {
						//System.out.println("add a new star");
						movieMap.get(movieID).addStar(star);
						starMap.get(movieID).put(starID, starID);
						//System.out.println("finish adding a new star");
					}
					if(genreMap.get(movieID).containsKey(genreID) == false) {
						//System.out.println("add a new genre");
						movieMap.get(movieID).addGenre(genre);
						genreMap.get(movieID).put(genreID, genreID);
						//System.out.println("finish adding a new genre");
					}
					//System.out.println("finish updating the movie");
				}
				else {
					Movie movie = new Movie(res.getInt("movies.id"), 
											res.getString("movies.title"), 
											res.getInt("movies.year"),
											res.getString("movies.director"), 
											res.getString("movies.banner_url"), 
											res.getString("movies.trailer_url"));
					movie.addStar(star);
					movie.addGenre(genre);
					movieMap.put(movieID, movie);
					
					HashMap newstarHash = new HashMap<Integer, Integer>();
					newstarHash.put(starID, starID);
					starMap.put(movieID, newstarHash);
					
					HashMap newgenreHash = new HashMap<Integer, Integer>();
					newgenreHash.put(genreID, genreID);
					genreMap.put(movieID, newgenreHash);
				}
			}
			
			for(int m: movieMap.keySet()) {
				//System.out.println(m);
				//Movie tempmovie = movieMap.get(m);	
				movies.add(movieMap.get(m));
				//System.out.println(tempmovie.getID());
				
			}
			//System.out.println("finish geting the result");
			getResult.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Movie> getSimpleMovies() {
		SimpleSearch();
		return movies;
	}
	private void SimpleSearch() {
		String condition = " where movies.id = " + ID;
		String getAttribute = "select movies.id, movies.title, movies.director, movies.year, movies.banner_url, movies.trailer_url"
							+ " from movies";
		try {
			GetResult getResult = new GetResult();
			ResultSet res = getResult.getResult(getAttribute + condition);
			while(res.next()) {
				Movie movie = new Movie(res.getInt("movies.id"),
										res.getString("movies.title"),
										res.getInt("movies.year"),
										res.getString("movies.director"),
										res.getString("movies.banner_url"),
										res.getString("movies.trailer_url"));
				movies.add(movie);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
