<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Film</title>
</head>
<body>
<c:choose>
    <c:when test="${! empty film}">
   		 <h3>Current film info:</h3>
      <ul>
        <li>Film ID: ${film.id}</li>
		<!-- IT IS NOT ALLOWED TO CHANGE THE ID -->
        <li>Title: ${film.title}</li>
        <li>Release year: ${film.release_year}</li>
        <li>Rating: ${film.rating}</li>
        <li>Description: ${film.description}</li>
        <li>Language ID: ${film.language_id }</li>
        <li>Language: ${language_name }</li>
        <li>Rental Duration: ${rental_duration }</li>
        <li>Rental rate: ${rental_rate }</li>
        <li>Length: ${length }</li>
        <li>Category: ${category }</li>
        <li>Media condition: ${media_condition }</li>
        <li>Actors: ${actors }</li>
      </ul>
      
      <br>
		<h3>Enter the changes You would like to make</h3>
	<form action="editFilmInfo.do" method="GET">
		<label for="searchKeyword">Title:</label>
		<input type="text" name="title" /> <br>
		
		<label for="searchKeyword">Release year:</label>
		<input type="number" name="year" /> <br>
		
		<label for="searchKeyword">Rating:</label>
		<input type="text" name="rating" /> <br>
		
		<label for="searchKeyword">Description:</label>
		<input type="text" name="description" /> <br>
		
		<label for="searchKeyword">Language ID:</label>
		<input type="number" name="searchKeyword" /> <br>
		
		<label for="searchKeyword">Rental Duration:</label>
		<input type="text" name="duration" /> <br>
		
		<label for="searchKeyword">Rental rate:</label>
		<input type="number" step="any" name="rate" /> <br>
		
		<label for="searchKeyword">Length:</label>
		<input type="text" name="length" /> <br>
		
		<label for="searchKeyword">Category:</label>
		<input type="text" name="category" /> <br>
		
		<label for="searchKeyword">Media condition:</label>
		<input type="text" name="mediaCondition" /> <br>
		
<!-- 	Stretch goals, insert or delete a film actor -->
		<input type="submit" value="EditFilmInfo" /><br>
		
	</form>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
  
  
</body>
</html>