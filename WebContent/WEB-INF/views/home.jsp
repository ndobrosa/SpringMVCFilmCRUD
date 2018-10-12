<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film</title>
</head>
<body>

	<form action="searchById.do" method="GET">
		<label for="searchText">Enter an Id:</label> 
		<input type="text" name="searchText" />
		<input type="submit" value="search by id" />
	</form>

	<form action="searchByKeyword.do" method="GET">
		<input type="submit" value="search by keyword" />
	</form>

	<form action="addFilm.do" method="GET">
		<input type="submit" value="add new film" />
	</form>


</body>
</html>