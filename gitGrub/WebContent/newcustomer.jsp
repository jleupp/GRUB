<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
		<meta charset="UTF-8">
		<title>git Grub</title>
		<link rel="stylesheet" href="css/normalize.css">
		<link rel="stylesheet" href="css/main.css">
	</head>
	<body>
		<div id="container">
			<header id="grubHeader"> <!-- prev HLheader -->
				<h1>git Grub</h1>
				<h1>${message}</h1> 
			</header>
			<div id="loginboxOutter">
				<div id="loginboxInner">
					<div id="sectionheader"><h1 class="sectionheader">Create Account</h1></div>
					<form action="createuser.do" method="POST">
						<p>Enter email address to make user name</p>
						<input class="textBox" size="28" type="text" placeholder="user name " name="user_name" /><br>
						<p>Enter a case-sensitive password</p>
						<input class="textBox" size="28" type="password" placeholder="password" name="password" /><br>
						<p>Enter Your Phone Number</p>
						<input class="textBox" size="15" type="text" placeholder="(555)555-5555" name="phone" /><br>
						<p>Enter Your Birthday</p>
						<input class="textBox" size="11" type="text" placeholder="YYYY-MM-DD" name="birth" /><br>
						<!-- <input class="textBox" size="28" type="text" placeholder="Restaurant name" name="restaurant" /><br> -->
						<input class="submit" type="submit" value="Create Account" />
					</form>
				</div>
			</div>
			<!-- <div id="loginboxOutter">
				<div id="loginboxInner">
					<div id="sectionheader"><h1 class="sectionheader">Customer Log in</h1></div>
					<form action="setCustomerLoginCredentials.do" method="POST">
						<input class="textBox" size="28" type="text" placeholder="user name " name="user_name" /><br>
						<input class="textBox" size="28" type="password" placeholder="password" name="password" /><br>
						<input class="submit" type="submit" value="Log In" />
					</form>
				</div>
			</div> -->
		</div>
	</body>
</html>