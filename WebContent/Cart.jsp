<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "AppData.*" %>
<%@ page import = "java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>

<%
	Cart cart = (Cart)request.getSession().getAttribute("Cart");
	if(cart == null) System.out.println("its null");
	//ArrayList<Movie> movies = cart.showMovie();
	for(Movie m : cart.showMovies()) {
		%>
		<p><%=m.getTitle() %> <a href = "CartManager?action=drop&movieID=<%=m.getID()%>"> remove </a>
		<%
	}

%>

</body>
</html>