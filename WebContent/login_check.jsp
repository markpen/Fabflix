<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login check page</title>
</head>
<body>
	<%
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
	String lastName = null;
	//System.out.println(email + userpassword);
	try {
		Class.forName(dbdrive);
		connection = DriverManager.getConnection(dburl, user, password);
		String checkUser = "select last_name from customers where password='" + userpassword + "' and email='" + email + "'";
		prepare = connection.prepareStatement(checkUser);
		res = prepare.executeQuery();
		if(res.next()) {
			lastName = res.getString(1);
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
	
	if(check_in) {
%>
		<jsp:forward page = "login_success.jsp">
			<jsp:param name = "uname" value = "<%=lastName%>"/>
		</jsp:forward>
	<% 
	}

	else {
		%>
		<jsp:forward page = "login_failure.html"/>
		<%
	}
	%>
</body>
</html>