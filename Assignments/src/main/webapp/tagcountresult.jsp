<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
    <title>HTML Tag Count Results</title>
</head>
<body>
    <h1>HTML Tag Count Results</h1>
    
    <form method="post" action="TagCounterServlet" enctype="multipart/form-data">
        <input type="file" name="htmlFile" accept=".html">
        <input type="submit" value="Count Tags">
    </form>
    
    <h2>Tag Occurrences:</h2>
    <table border="1">
        <tr>
            <th>Tag Name</th>
            <th>Count</th>
        </tr>
        <c:forEach var="entry" items="${tagCount}">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
