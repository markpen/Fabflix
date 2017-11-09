package CartManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AppData.*;
import Search.*;
import java.util.*;
/**
 * Servlet implementation class CartManager
 */
@WebServlet("/CartManager")
public class CartManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		Cart cart = (Cart)request.getSession().getAttribute("Cart");
		if(cart == null) cart = new Cart();
		
		MovieIDSearch search = new MovieIDSearch(request.getParameter("movieID"));
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies = search.getSimpleMovies();
		
		if(action.equals("add")) {
			for(Movie m : movies) {
				//System.out.println("here");
				//System.out.println(m.getTitle());
				cart.addMovie(m);
			}
		}
		if(action.equals("drop")) {
			for(Movie m : movies) {
				cart.removeMovie(m);
			}
		}
		//System.out.println("herea");
		request.getSession().setAttribute("Cart", cart);
		
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
