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

	<a href="browse.jsp">Browse other menus</a>

		<p>${Order.status}</p>
	<table>
				<h2>Your Order is ${Order.status}</h2>
		<c:forEach var="details" items="${Order.orderDetails}">
			<tr>
			</tr>
			<TR>
				<TH ALIGN="center">Quantity</TH>
				<TH>Item</TH>
				<TH>Price</TH>
			</TR>
			<TR>
				<TD><form action="quantity.do" method="POST">
						<input type="number" name="quantity" value="${details.quantity}">
						<input type="submit" value="Submit" />
					</form></TD>
				<TD>${details.menuItem.name}</TD>
				<TD>${details.menuItem.price}</TD>
			</TR>
		</c:forEach>
	</table>

	<h2>Thank you for ordering from ${Order.orderDetails.get(0).menuItem.menu.restaurant.name}!</h2>

	<%--<form action="quantity.do" method="POST">
    <input type="number" name="quantity" value= "${details.quantity}">
    <input type="submit" value="Submit" />
    </form>
									

		<c:forEach var="details" items="${Order.orderDetails}">
		
<h2 class= "order"> Quantity: 									Item:											Price:  </h2>

    <form action="quantity.do" method="POST">
    <input type="number" name="quantity" value= "${details.quantity}">
    <input type="submit" value="Submit" />
    </form>
${details.menuItem} 							${details.menuItem.price}	
		
=	 </c:forEach>  --%>



</body>
</html>