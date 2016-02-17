<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Restaurants</title>
</head>
<body>
<a href="index.html">Go Home</a><br/>
<a href="logout.do">Logout</a><br/>

<h2> Restaurants:</h2>
	<form action="GetAllRestaurants.do" method="POST">
	<c:forEach var="restaurant" items="${restaurants}">
			<p> ${restaurant.name} # ${restaurant.address}</p>

		</c:forEach>
		</form>
	<br />
</body>
</html>