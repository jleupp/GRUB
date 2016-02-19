<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="globalNormal.css">
<link rel="stylesheet" type="text/css" href="globalGrub.css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gitGrub</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	
		<header id="">
			<div><IMG id="logo" src="http://uxrepo.com/static/icon-sets/mfg-labs/svg/github-circled-alt.svg"><span class="lightgrey">Grub</span></div>
		</header>
			<div id="">
				<div id="">
					<div class="center" id="restName"><h1>${Menu.restaurant.name} </h1></div>

						<div class="center">
							<form action="createorder.do" method="POST">
							<input type="hidden" value="${Menu.menuId}" name = "orderinfo">
							<c:forEach var="section" items="${Menu.menuSections}">
								<h2 class="center">${section.section}</h2>
								<c:forEach var="item" items="${Menu.items}">
									<c:choose>
										<c:when test="${item.section.section.equals(section.section)}">
										<div class="showItem"><input type="checkbox" name="orderinfo" value="${item.id}">&nbsp;${item.name} <fmt:setLocale value="en_US"/>
										<fmt:formatNumber value="${item.price}" type="currency"/>
										<br><div style="border:0px solid;" class="showDescription">${item.description}</div></div>
										</c:when>
										
									</c:choose>
								</c:forEach>
									
							</c:forEach>
	<div class="center" id="inputOrder"><input type="submit" value="Order Now" id="submitOrder"></div>
							</form><br>
						</div><br><br>
					</div>
				</div>
			
	
	<!--<div><p></p></div>
	<div class="center"id="returnLink"><a href="index.html">Return to Login</a></div>
	</div><p>here ${Menu.restaurant}</p>
	<div><iframe width="300px" id="displayPageMap" src="https://www.google.com/maps/embed/v1/place?q=${contact.address} }+
				${contact.stName}+${contact.city}+${contact.state}+${contact.zip}
				&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU"></iframe></div>-->
</body>
</html>