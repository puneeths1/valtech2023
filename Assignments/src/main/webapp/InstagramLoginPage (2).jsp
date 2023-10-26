<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
        body {
            background-color: #fafafa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            text-align: center;
            background-color: #ffffff;
            border: 1px solid #e1e1e1;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 350px;
        }
        h1 {
            font-family: 'Billabong', cursive;
            color: #125688;
            font-size: 2.5em;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #e1e1e1;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #125688;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 15px;
        }
        p.error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="login-container">
	<img src="C:\Users\Puneeth.S\Downloads\Instagram_logo.png" alt="Instgram Logo" style="width:100px;height:auto;margin-bottom:20px;">
    <h1>Login Page</h1>
    <form action="InstagramLoginResults.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    </div>
    <%-- Check for errors and display appropriate message --%>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            if (username.length() < 4 && password.length() < 8) {
                out.println("<p>Error: Username and password must be at least 4 and 8 characters long, respectively.</p>");
            } else if (username.length() < 4) {
                out.println("<p>Error: Username must be at least 4 characters long.</p>");
            } else if (password.length() < 8) {
                out.println("<p>Error: Password must be at least 8 characters long.</p>");
            } else {
                // Forward to loginResults.jsp with username parameter
                request.setAttribute("username", username);
                request.getRequestDispatcher("InstagramLoginResults.jsp").forward(request, response);
            }
        }
    %>
</body>
</html>