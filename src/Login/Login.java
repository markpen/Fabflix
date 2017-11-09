package Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppData.*;
import DataBase.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection connection = null;
		PreparedStatement prepare = null;
		ResultSet res = null;
		boolean check_in = false;
		
		String email = request.getParameter("emailAddress");
		String userpassword = request.getParameter("password");
		
		int id;
		String lastName = null;
		String firstName = null;
		String address = null;
		String cc_id = null;
		
		
		
		//System.out.println(email + userpassword);
		try {
			GetConnection getConnection = new GetConnection();
			connection = getConnection.getConnection();
			String checkUser = "select * from customers where password='" + userpassword + "' and email='" + email + "'";
			prepare = connection.prepareStatement(checkUser);
			res = prepare.executeQuery();
			if(res.next()) {
				id = res.getInt("id");
				firstName = res.getString("first_name");
				lastName = res.getString("last_name");
				cc_id = res.getString("cc_id");
				address = res.getString("address");
				check_in = true;
			}
			getConnection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try {
				res.close();
				prepare.close();
				connection.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		Customer customer = new Customer();
		session = request.getSession(true);
		
		if(check_in) {
			customer.setAddress(address);
			customer.setName(firstName, lastName);
			customer.setCC_ID(cc_id);
			customer.setEmail(email);
			
			session.setAttribute("Customer", customer);
			
			response.sendRedirect("Main.jsp");
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
