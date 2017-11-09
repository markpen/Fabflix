package Search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.sql.*;
import AppData.*;
import DataBase.*;
/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//ArrayList<Movie> movies = new ArrayList<Movie>();
		String from = request.getParameter("from");
		
		if(from.equals("GeneralSearch")) {
			GeneralSearch search = new GeneralSearch(request);
			ArrayList<Movie> movies = search.getMovieList();
			request.setAttribute("movieList", movies);
			request.getRequestDispatcher("Movies.jsp").forward(request, response);
		}
		if(from.equals("Movies") || from.equals("Star")) {
			MovieIDSearch search = new MovieIDSearch(request);
			ArrayList<Movie> movies = search.getFullMovies();
			request.setAttribute("movie", movies);
			request.getRequestDispatcher("Movie.jsp").forward(request, response);
		}
		if(from.equals("Genres")) {
			GetGenres search = new GetGenres(request);
			ArrayList<Genre> genres = search.getGenres();
			request.setAttribute("genres", genres);
			request.getRequestDispatcher("Genres.jsp").forward(request, response);
		}
		if(from.equals("GenreList")) {
			GenreSearch search = new GenreSearch(request);
			ArrayList<Movie> movies = search.getMovies();
			request.setAttribute("movieList", movies);
			request.getRequestDispatcher("Movies.jsp").forward(request, response);
		}
		if(from.equals("Stars")) {
			StarIDSearch search = new StarIDSearch(request);
			ArrayList<Star> stars = search.getStar();
			request.setAttribute("stars", stars);
			request.getRequestDispatcher("Star.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
