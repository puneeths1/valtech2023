<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .error-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            text-align: center;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #dc3545;
        }

        h2 {
            color: #333;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <div class="error-container">
            <h1>Error</h1>
            <h2><%=exception.getMessage() %></h2>
        </div>
    </div>
</body>

</html>
