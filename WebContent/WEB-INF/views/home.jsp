<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film</title>
</head>
<body>

		<h3>Search by Film ID</h3>
	<form action="searchById.do" method="GET">
		<label for="searchID">Enter an ID:</label> 
		<input type="text" name="searchID" /> <br>
		<input type="submit" value="Search By ID" />
	</form>

		<h3>Search by Keyword</h3>
	<form action="searchByKeyword.do" method="GET">
		<label for="searchKeyword">Enter a key:</label>
		<input type="text" name="searchKeyword" /> <br>
		<input type="submit" value="Search By Keyword" /><br>
	</form>

		<h3>Add a Film</h3>
	<form action="addFilm.do" method="GET">
		<label for="title">Enter a title:</label>
		<input type="text" name="addFilm" /><br>
		<label for="description">Enter a Description:</label>
		<input type="text" name="addFilm" /><br>
		<label for="release_year">Enter a Release Year:</label>
		<input type="text" name="addFilm" /><br>
		<label for="length">Enter Film Length(minutes):</label>
		<input type="text" name="addFilm" /><br>
		<label for="special_features">Enter Special Features:</label>
		<input type="text" name="addFilm" /><br>
		<input type="submit" value="Add New Film" />
	</form>


</body>
</html>