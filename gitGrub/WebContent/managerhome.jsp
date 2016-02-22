<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="globalNormal.css">
<link rel="stylesheet" type="text/css" href="globalGrub.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager Home Page</title>
</head>

<body><div><IMG id="logo" src="http://uxrepo.com/static/icon-sets/mfg-labs/svg/github-circled-alt.svg"><span class="lightgrey">Grub</span></div>
<div class="center"><h3>This is the Manager Dashboard <3</h3>
<div style="border:0px solid green;" id="leftContent">
<p><a href="logout.do"><button class="inputOrder">logout</button></a></p>
<p><a href="AddRestaurant.do"><button class="inputOrder">add restaurants</button></a></p>
<p><a href="EditRestaurant.do"><button class="inputOrder">edit restaurants</button></a></p>
<p><a href="restaurantorders.do"><button class="inputOrder">view orders</button></a></p>
</div>
<div style="border:0px solid red;" id="rightContent">
<p>show order info here</p>
<h1>${EmptyString}</h1>
</div>
</div>






<!--
<a href="logout.do">Logout</a><br/>
<a href="AddRestaurant.do">Add Restaurants</a> <br/>
<a href="EditRestaurant.do">Edit Restaurants</a>
<a href="restaurantorders.do">View Orders</a>
 ${EmptyString}   -->
</body>
</html>