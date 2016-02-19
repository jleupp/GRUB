<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>git Grub</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div id="container">
		<header id="hotlineHeader">
			<h1>git Grub</h1>
		</header>
			<div id="queryResultsOuter">
				<div id="queryResultsInner">
					<div id="sectionheader"><h1 class="sectionheader">All Restaurants</h1></div>
					<div id="storeList">
						<div class="subHeader"><h2>${fn:length(restList)} Restaurants in dataBase!</h2>
							<h2><a href="index.html">Return to Login</a></h2>
						</div>

						<!-- <div style="overflow-x:auto;">
							<table id="tableList">
								<tbody> -->
							<c:forEach var="restaurant" items="${restList}">
								${restaurant.name}
							<form action="menu.do" method="POST"><label>
									MENU: <select name="menuchoice">
								<c:forEach var="menu" items="${restaurant.menus}">
									<option>View Menus</option>
									<option value="${menu.restaurant.id}&&${menu.type}">${menu.type}</option>
									</select>
							</label>
								</c:forEach>
							<input type="submit" value="View Menu" />
							</form><br>
							</c:forEach>
							<!-- 	</tbody>
							</table>
						</div> -->
					</div>
				</div>
			</div>
	</div>
</body>
</html>