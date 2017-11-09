<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "AppData.*" %>
<%@ page import = "java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie</title>
</head>
<body>
<%
	ArrayList<Movie> movies = (ArrayList<Movie>)request.getAttribute("movie");
	for(Movie m : movies) {
		ArrayList<Star> s;
		s = m.getStars();
		ArrayList<Genre> g;
		g = m.getGenres();
		%>
	<h2><a href = "Search?from=movies&movieID=<%=m.getID()%>"> <%=m.getTitle()%></a>  </h2>
		<%
		for(Star ss : s) {
			%>
			<p><a href = "Search?starID=<%=ss.getID()%>&from=Stars"><%=ss.getName()%></a> </p>
			<%
		}
		for(Genre gg : g) {
			%>
			<p><%=gg.getGenre()%> </p>
			<%
		}
}

%>
<p>${ID}</p>
</body>
</html>