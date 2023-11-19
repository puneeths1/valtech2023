<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
</head>
<body>
<h4 Style="color:red">${message}</h4>
<h1>REGISTER HERE</h1>
<form action="register" method="post">
	<label> Enter your Name</label>
	<input type="text" name="username" >
	<label>Enter Your Password</label>
	<input type="password" name="password">
	<label>Confirm Password</label>
	<input type="password" name="confirmPassword">
	<input type="submit" name="submit" value="Register">
</form>
</body>
</html>