<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Conversion Result</title> 
<style>
    .container {
        text-align: center;
        margin: 20px auto;
        width: 60%;
    }
    .title {
        font-size: 24px;
        color: #333;
    }
    .result-text {
        font-size: 18px;
        color: #0077b6;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        background-color: #f4a261;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        margin-top: 20px;
    }
    .btn:hover {
        background-color: #e76f51;
    }
</style>
</head> 
<body> 
<div class="container result-container"> 
        <h1 class="title">Result</h1> 
        <p class="result-text">The result is: <%= request.getAttribute("result") %></p> 
        <a href="convert.jsp" class="btn btn-secondary">Go Back</a> 
    </div> 
</body> 
</html>
