<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>git Grub</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<table>
		<c:forEach var="details" items="${Order.orderDetails}">
			<h2>Current order status is ${Order.status}</h2>
			<TR>
				<TH ALIGN="center">Quantity</TH>
				<TH>Item</TH>
				<TH>Price</TH>
			</TR>
			<TR> 
			<input type="checkbox" name="orderinfo" value="	<TD>${details.quantity}</TD>
				<TD>${details.menuItem.name}</TD>
				<TD>${details.menuItem.price}</TD>">
			</TR>
		</c:forEach>
	</table>