<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please enter your name</title>
</head>
<body>
<%String copyright = "all copyright reserved"; %>
<center>
	<form action = "my_first_response.jsp" method = "post">
		Please enter your name: <input type = "text" name = "name">
		<input type = "submit" value = "show">
	</form>
</center>
<p> copyright: <%= copyright %> </p>
</body>
</html>