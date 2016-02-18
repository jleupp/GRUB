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
					<div id="sectionheader"><h1 class="sectionheader">${Menu.restaurant.name} ${Menu.type} Menu</h1></div>
					<div id="storeList">
						
							<h2><a href="index.html">Return to Login</a></h2>
						</div>

						<!-- <div style="overflow-x:auto;">
							<table id="tableList">
								<tbody> -->
							<form action="order.do" method="POST">
							<c:forEach var="section" items="${Menu.menuSections}">
								<div class="subHeader"><h2>${section.section}</h2>
								<c:forEach var="item" items="${Menu.items}">
									<c:choose>
										<c:when test="${item.section.section.equals(section.section)}">
											${item.name}<br>
										</c:when>
										<%-- <c:otherwise>${item.section.section} ${section.section}<br></c:otherwise> --%>
									</c:choose>
								</c:forEach>
									<!-- MENU: <select name="menuchoice"> -->
							<%-- 	<c:forEach var="menu" items="${restaurant.menus}">
									<option>View Menus</option>
									<option value="${menu.restaurant.id}&&${menu.type}">${menu.type}</option>
									</select>
							
								</c:forEach> --%>
							<!-- <input type="submit" value="View Menu" /> -->
							</c:forEach>
							</form><br>
							<!-- 	</tbody>
							</table>
						</div> -->
					</div>
				</div>
			</div>
	</div>
</body>
</html>