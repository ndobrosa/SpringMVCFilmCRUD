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
		<label for="searchID">Enter an ID:</label> 
		<input type="text" name="searchID" />
		<input type="submit" value="search by id" />
	</form>

	<form action="searchByKeyword.do" method="GET">
		<label for="searchKeyword">Enter a key:</label>
		<input type="text" name="searchKeyword" />
		<input type="submit" value="search by keyword" />
	</form>

	<form action="addFilm.do" method="GET">
		<label for="title">Enter a title:</label>
		<input type="text" name="addFilm" />
		<label for="description">Enter a Description:</label>
		<input type="text" name="addFilm" />
		<label for="release_year">Enter a Release Year:</label>
		<input type="text" name="addFilm" />
		<label for="language_id">Enter a language ID:</label>
		<input type="text" name="addFilm" />
		<label for="length">Enter a Length:</label>
		<input type="text" name="addFilm" />
		<label for="special_features">Enter Special Features:</label>
		<input type="text" name="addFilm" />
		
		
		stmt.setString(1, newFilm.getTitle());
			stmt.setString(2, newFilm.getDescription());
			stmt.setInt(3, newFilm.getRelease_year());
			stmt.setInt(4, newFilm.getLanguage_id());
			stmt.setString(5, newFilm.getLength());
			stmt.setString(6, newFilm.getSpecial_features());
		
		<input type="text" name="addFilm" />
		<input type="submit" value="add new film" />
	</form>


</body>
</html>