
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private HttpSession session;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		final String dbdrive = "com.mysql.jdbc.Driver";
		final String dburl = "jdbc:mysql:///moviedb?autoReconnect=true&useSSL=false";
		final String user = "testuser";
		final String password = "password";
		
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
			Class.forName(dbdrive);
			connection = DriverManager.getConnection(dburl, user, password);
			String checkUser = "select last_name from customers where password='" + userpassword + "' and email='" + email + "'";
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
}
