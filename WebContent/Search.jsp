<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search movies</title>
</head>
<body>
	<center>
		<h1> Find your favorite movies</h1>
		<form name = "searchmovie" action = "Search" method = "get">
		<table>
		<tr>
		<td>Title</td>
		<td><input type = "text" name = "title" ></td>
		</tr>
		<tr>
		<td>Year</td>
		<td><input type = "text" name = "year" ></td>
		</tr>
		<tr>
		<td>Director</td>
		<td><input type = "text" name = "director" ></td>
		</tr>
		<tr>
		<td>Star</td>
		<td><input type = "text" name = "firstName" placeholder = "First Name"></td>
		<td><input type = "text" name = "lastName" placeholder = "Last Name"></td>
		</tr>
		<tr>
		<td>Submit<input type = "hidden" name = "from" value = "GeneralSearch" />
		<input type = "hidden" name = "order" value = "title" /></td>
		<td><input type = "submit" name = "submit" ></td>
		</tr>
		</table>
		
		
		</form>
	</center>
</body>
</html>