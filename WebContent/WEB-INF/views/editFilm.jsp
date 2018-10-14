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
        <li>Length: ${film.length } minutes</li>
        <li>Category: ${film.category }</li>
        <li>Media condition: ${film.media_condition }</li>
        <li>Actors: </li> 
        	<ul>
       			 <c:forEach items="${film.actors}" var="actor">
  			  	 <li>${actor}</li>
				</c:forEach>
			</ul> 
      </ul>
      
      <br>
		<h3>Enter the changes You would like to make</h3>
	<form action="editFilmInfo.do" method="POST">
		<input type="hidden" name="id" value="${film.id }"/>
		
		<label for="editFilm">Title:</label>
		<input type="text" name="title" value="${film.title}"/> <br>
		
		<label for="editFilm">Release year:</label>
		<input type="number" name="year" value="${film.release_year}"/> <br>
		
<!-- 		<label for="editFilm">Rating:</label>
		G <input type="radio" name="rating" value="G" />
		PG <input type="radio" name="rating" value="PG" /> 
		PG13 <input type="radio" name="rating" value="PG13" />
		R <input type="radio" name="rating" value="R" />
		NC17 <input type="radio" name="rating" value="NC17" />
		<br> -->
		
		<label for="editFilm">Rating:</label>
		<select name="rating">
  			<option value="G">G</option>
 			<option value="PG">PG</option>
  			<option value="PG13">PG13</option>
 			 <option value="R">R</option>
 			 <option value="NC17">NC17</option>
		</select>
		
		<br>
		
		<label for="editFilm">Description:</label>
		<input type="text" name="description" value="${film.description}"/> <br>
		
<%-- 		<label for="editFilm">Language ID:</label>
		<input type="number" name="language_id" value="${film.language_id}"/> <br> --%>
		<label for="editFilm">Language (ID):</label>
		<select name="language_id" type="number">
  			<option value="1">English (1)</option>
 			<option value="2">Italian (2)</option>
  			<option value="3">Japanese (3)</option>
 			<option value="4">Mandarin (4)</option>
 			<option value="5">French (5)</option>
 			<option value="6">German ()</option>
		</select>
		
		<br>
		
		<%-- <label for="editFilm">Rental Duration:</label>
		<input type="text" name="duration" value="${film.rental_duration}"/> <br>
		 --%>
		<label for="editFilm">Rental rate:</label>
		<input type="number" step="any" name="rate" value="${film.rental_rate}"/> <br>
		
		<label for="editFilm">Length:</label>
		<input type="text" name="length" value="${film.length}"/> <br>
		
<%-- 		<label for="editFilm">Category:</label>
		<input type="text" name="category" value="${film.category}"/> <br> --%>
		
		<label for="editFilm">Category:</label>
		<select name="category">
  			<option value="Action">Action</option>
 			<option value="Animation">Animation</option>
  			<option value="Children">Children</option>
 			<option value="Classics">Classics</option>
  			<option value="Comedy">Comedy</option>
 			<option value="Documentary">Documentary</option>
  			<option value="Drama">Drama</option>
 			<option value="Family">Family</option>
			<option value="Foreign">Foreign</option>
			<option value="Games">Games</option>
			<option value="Horror">Horror</option>
			<option value="Music">Music</option>
			<option value="New">New</option>
			<option value="Sci-Fi">Sci-Fi</option>
			<option value="Sports">Sports</option>
			<option value="Travel">Travel</option>
		</select>
	    <br>
		
		<label for="editFilm">Special Features:</label>
<%-- 		<input type="text" name="features" value="${film.special_features}"/> <br> --%>
				<br>
				<input type="checkbox" id="Trailers" name="features" value="Trailers"> <label
                for="Trailers">Trailers</label><br>
                <input type="checkbox" id="Commentaries" name="features" value="Commentaries"> <label
                for="Commentaries">Commentaries</label><br> 
                <input type="checkbox" id="Deleted Scenes" name="features" value="Deleted Scenes"> <label
                for="Deleted Scenes">Deleted Scenes</label><br> 
                <input type="checkbox" id="Behind the Scenes" name="features" value="Behind the Scenes"> <label
                for="Behind the Scenes">Behind the Scenes</label><br> 
                                
<%-- 		<label for="editFilm">Media condition:</label>
		<input type="text" name="media" value="${film.media_condition}"/> <br> --%>
		
		<label for="editFilm">Media Condition:</label>
		<select name="media">
  			<option value="New">New</option>
 			<option value="Used">Used</option>
  			<option value="Damaged">Damaged</option>
 			<option value="Lost">Lost</option>
 			<option value="NA">Not Applicable</option>
		</select>
		 			 <br>
		
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