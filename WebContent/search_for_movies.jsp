<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search for Movies</title>
</head>
<body>
<%
	final String dbdriver = "com.mysql.jdbc.Driver";
	final String dbuser = "testuser";
	final String dbpassword = "password";
	final String dburl = "jdbc:mysql:///moviedb?autoReconnect=true&useSSL=false";
	
	Connection connect = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	

 	 try{
		Class.forName(dbdriver).newInstance();
		connect = DriverManager.getConnection(dburl, dbuser, dbpassword);
		String sql = "select title, director from movies where year = 2000";
		pstmt = connect.prepareStatement(sql);
		res = pstmt.executeQuery();
		
		while(res.next()) {
			String MVname = res.getString(1);
			String Dname = res.getString(2);
			%>
			<p> <%=MVname%> <%=Dname %></p>
			<%
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	
%>
</body>
</html>