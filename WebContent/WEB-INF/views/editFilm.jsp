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
        <li>Language: ${film.language_name }</li>
        <li>Rental Duration: ${film.rental_duration }</li>
        <li>Rental rate: ${film.rental_rate }</li>
        <li>Length: ${film.length }</li>
        <li>Category: ${film.category }</li>
        <li>Media condition: ${film.media_condition }</li>
        <li>Actors: ${actors }</li>
      </ul>
      
      <br>
		<h3>Enter the changes You would like to make</h3>
	<form action="editFilmInfo.do" method="GET">
		<input type="hidden" name="id" value="${film.id }"/>
		
		<label for="editFilm">Title:</label>
		<input type="text" name="title" value="${film.title}"/> <br>
		
		<label for="editFilm">Release year:</label>
		<input type="number" name="year" value="${film.release_year}"/> <br>
		
		<label for="editFilm">Rating:</label>
		<input type="text" name="rating" value="${film.rating}"/> <br>
		
		<label for="editFilm">Description:</label>
		<input type="text" name="description" value="${film.description}"/> <br>
		
		<label for="editFilm">Language ID:</label>
		<input type="number" name="language_id" value="${film.language_id}"/> <br>
		
		<label for="editFilm">Rental Duration:</label>
		<input type="text" name="duration" value="${film.rental_duration}"/> <br>
		
		<label for="editFilm">Rental rate:</label>
		<input type="number" step="any" name="rate" value="${film.rental_rate}"/> <br>
		
		<label for="editFilm">Length:</label>
		<input type="text" name="length" value="${film.length}"/> <br>
		
		<label for="editFilm">Category:</label>
		<input type="text" name="category" value="${film.category}"/> <br>
		
		<label for="editFilm">Special Features:</label>
		<input type="text" name="features" value="${film.special_features}"/> <br>
		
		<label for="editFilm">Media condition:</label>
		<input type="text" name="media" value="${film.media_condition}"/> <br>
		
<!-- 	Stretch goals, insert or delete a film actor -->
		<input type="submit" value="Edit Film Info" /><br>
		
	</form>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
  
  
</body>
</html>