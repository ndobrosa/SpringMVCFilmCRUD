<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>

	<c:choose>
		<c:when test="${not empty film}">     
			<ul>
				<li>Film ID: ${film.id}</li>
				<li>Title: ${film.title}</li>
				<li>Release year: ${film.release_year}</li>
				<li>Rating: ${film.rating}</li>
				<li>Description: ${film.description}</li>
				<li>Category: ${film.category}</li>
				<li>Actors: </li> 
					<ul>
        				<c:forEach items="${film.actors}" var="actor">
  			  				<li>${actor}</li>
						</c:forEach>
					</ul>
			</ul>
			<h3>More Options</h3>
			<form action="editFilm.do" method="GET">
				<input type="hidden" name="id" value="${film.id }"/>
				<input type="submit" value="Edit Film" />
			</form>
			<br>
			<form action="deleteFilm.do" method="GET">
				<input type="hidden" name="id" value="${film.id }"/>
				<input type="submit" value="Delete Film" />
			</form>
			<br>
		</c:when>

		<c:when test="${not empty films}">
			<c:forEach items="${films }" var="f">
				<ul>
					<li>Film ID: ${f.id}</li>
					<li>Title: ${f.title}</li>
					<li>Release year: ${f.release_year}</li>
					<li>Rating: ${f.rating}</li>
					<li>Description: ${f.description}</li>
				</ul>
				<h3>More Options</h3>
				<form action="editFilm.do" method="GET">
					<input type="hidden" name="id" value="${f.id }"/>
					<input type="submit" value="Edit Film" />
				</form>
				<br>
				<form action="deleteFilm.do" method="GET">
					<input type="hidden" name="id" value="${f.id }" />
					<input type="submit" value="Delete Film" />
				</form>
				<br>
					<hr>
			</c:forEach>

		</c:when>
		<c:when test="${filmFailed }"> Adding Film failed.
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<form action="index.do" method="GET">
		<input type="submit" value="Main Menu" />
	</form>
	<br>

</body>
</html>