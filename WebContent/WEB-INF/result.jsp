<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>

  <c:choose>
    <c:when test="${! empty film}">
      <ul>
        <li>Film ID: ${film.id}</li>
        <li>Title: ${film.title}</li>
        <li>Release year: ${film.release_year}</li>
        <li>Rating: ${film.rating}</li>
        <li>Description: ${film.description}</li>
      </ul>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
</body>
</html>