
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ page import="com.valtech.training.pattern.checker.PatternCheckerServiceImpl" %> 
<%@ page import="com.valtech.training.rating.ui.RatingHelper" %> 
<%@ page import="com.valtech.training.mobileranking.MobileRankingService" %> 
<%@ page import="java.util.List" %> 

<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="UTF-8"> 
    <title>Mobile Checker</title> 
</head> 
<body> 
    <h1>Mobile Checker</h1>

    <form action="MobileServlets" method="post">
        Enter Mobile Number: <input type="text" name="mobile">
        <input type="submit" value="Check Mobile">
    </form>

    <c:if test="${not empty patterns || not empty rating}">
        <h2>Results:</h2>
        
        <c:if test="${not empty patterns}">
            <h3>Patterns:</h3>
            <ul>
                <c:forEach items="${patterns}" var="pattern">
                    <li>${pattern}</li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${not empty rating}">
            <h3>Rating:</h3>
            <p>${rating}</p>
        </c:if>
    </c:if>
</body> 
</html>

    