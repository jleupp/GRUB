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
			<TR>
				<TH ALIGN="center">Order Id</TH>
				<TH>Order Date</TH>
				<TH>Customer Email</TH>
				<TH>Customer Phone</TH>
			</TR>
			<h2>Orders Submitted</h2>
		<c:forEach var="order" items="${submittedOrders}">
			
			<TR>
			<TD>${order.orderId}</TD>
			<TD>${order.dateOrdered}</TD><TD>${order.customer.email}</TD><TD>${order.customer.phone}</TD>
				<%-- <TD>${details.menuItem.name}</TD>
				<TD>${details.menuItem.price}</TD>"> --%>
			<td><form action ="deliver.do" method="post">
			<input type="hidden" value=${order.orderId} name="orderid" />
			<input type="submit" value="Deliver Order" /></form></td>
			</TR>
		</c:forEach>
	</table>
	<a href="managerhome.do">Manager's Dashboard</a><br>
	<a href="logout.do">Logout</a>
</body>