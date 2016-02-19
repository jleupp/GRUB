<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="globalNormal.css">
<link rel="stylesheet" type="text/css" href="globalGrub.css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Home Page</title>
</head>
<body><div><IMG id="logo" src="http://uxrepo.com/static/icon-sets/mfg-labs/svg/github-circled-alt.svg"><span class="lightgrey">Grub</span></div>
<div class="center"><h3>This is the Customer Dashboard Bitches</h3>
<div style="border:0px solid green;" id="leftContent">
<p><a href="logout.do"><button class="inputOrder">logout</button></a></p>
<p><a href="browse.do"><button class="inputOrder">browse restaurants</button></a></p>
<p><a href="deactivate.do"><button class="inputOrder">delete account</button></a></p>
<p><a href="activeorder.do"><button class="inputOrder">active orders</button></a></p></div>

<div style="border:0px solid red;" id="rightContent">
<p>show order info here</p>
<%-- <c:choose> --%>
<%-- <c:when test="${is empty Order}"> --%>
<!-- <p>hello world</p> -->
<%-- </c:when> --%>
<%-- </c:choose> --%>
</div>



<!--a href="logout.do"><button>logout</button></a>
<a href="browse.do"><button>browse restaurants</button></a>  -->
</div>
</body>
</html>