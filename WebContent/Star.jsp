<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "AppData.*" %>
<%@ page import = "java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Star</title>
</head>
<body>
<%
	ArrayList<Star> stars = (ArrayList<Star>)request.getAttribute("stars");
	for(Star s : stars) {
		%>
		<h2> <%=s.getName() %></h2>
		
		<%
		for(SampleMovie m : s.getMovies()) {
			%>
			<p><a href = "Search?from=Star&movieID=<%=m.getID()%>"> <%=m.getTitle() %></a></p>
			<%
		}
	}

%>
</body>
</html>