<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Results</title>
<style>
    /* Add your own styles here */
</style>
</head>
<body>
    <h1>Login Results</h1>
    <%-- Display greeting with username parameter --%>
    <p>Hi <%= request.getParameter("username") %> how are you doing...</p>
</body>
</html>