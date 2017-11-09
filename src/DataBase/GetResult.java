package DataBase;

import java.sql.*;

public class GetResult {
	private String dbdriver = "com.mysql.jdbc.Driver";
	private String dburl = "jdbc:mysql:///moviedb?autoReconnect=true&useSSL=false";
	private String dbuser = "testuser";
	private String password = "password";
	private Connection connection = null;
	private ResultSet res = null;
	private PreparedStatement prepare = null;
	
	public GetResult() throws Exception {
		try {
			Class.forName(dbdriver); 
			this.connection = DriverManager.getConnection(dburl,dbuser, password);
			//System.out.println(sqlStatement);
		} catch (Exception e) {
			throw e;
		}
	}
	public GetResult(String sqlStatement) throws Exception {
		try {
			Class.forName(dbdriver); 
			this.connection = DriverManager.getConnection(dburl,dbuser, password);
			prepare = connection.prepareStatement(sqlStatement);
			res = prepare.executeQuery();
			//System.out.println(sqlStatement);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ResultSet getResult(String sqlStatement) throws Exception {
		try {
			prepare = connection.prepareStatement(sqlStatement);
			res = prepare.executeQuery();
		} catch (Exception e) {
			throw e;
		}
		return res;
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
