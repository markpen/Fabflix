<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "AppData.*" %>
<%@ page import = "java.util.*" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
</head>
<body>

<%
	//System.out.println("here");
	ArrayList<Movie> movies = (ArrayList<Movie>)request.getAttribute("movieList");
	for(Movie m : movies) {
		ArrayList<Star> s;
		s = m.getStars();
		//request.setAttribute("movie", m);
		ArrayList<Genre> g;
		g = m.getGenres();
		%>
	<h2><a href = "Search?from=Movies&movieID=<%=m.getID()%>"> <%=m.getTitle()%></a> </h2> <h4><a href = "CartManager?action=add&movieID=<%=m.getID()%>"> add </a></h4>
	<p><h2>Director: <%=m.getDirector() %></h2> </p>
	<p><h2>Stars:</h2></p>
		<%
		for(Star ss : s) {
			%>
			<%=ss.getName()%>
			<%
		}
		%>
		<h3>Genres:</h3>
		<%
		for(Genre gg :g) {
			%>
			<%=gg.getGenre()%>
			<%
		}
	}

%>

</body>
</html>