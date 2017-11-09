package DataBase;

import java.sql.*;

public class GetConnection {
	private String dbdriver;
	private String dburl;
	private String dbuser;
	private String password;
	private Connection connection;
	
	public GetConnection() throws Exception{
		dbdriver = "com.mysql.jdbc.Driver";
		dburl = "jdbc:mysql:///moviedb?autoReconnect=true&useSSL=false";
		dbuser = "testuser";
		password = "password";
		
		try {
			Class.forName(dbdriver); 
			this.connection = DriverManager.getConnection(dburl,dbuser, password);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close() throws Exception {
		if(this.connection != null) {
			try {
				this.connection.close();
			} catch(Exception e) {
				throw e;
			}
		}
	}
	
}
