<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instagram Login</title>
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
            border-radius: 5px;
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
        .forgot-password {
            text-align: left;
            margin-top: 10px;
        }
        .signup-link {
            text-decoration: none;
            color: #125688;
        }
        .facebook-button {
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
        .facebook-icon {
            width: 20px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="login-container">
    <img src="https://clipart.info/images/ccovers/1522452762Instagram-logo-png-text.png"
         style="width:200px;height:auto;margin-bottom:20px;">

    <form action="InstagramLoginResults.jsp" method="post">
        <label for="username">Username or Email:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" value="Log In">
    </form>
    <p class="error-message">
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null && password != null) {
                if (username.length() < 4 && password.length() < 8) {
                    out.println("Error: Username and password must be at least 4 and 8 characters long, respectively.");
                } else if (username.length() < 4) {
                    out.println("Error: Username must be at least 4 characters long.");
                } else if (password.length() < 8) {
                    out.println("Error: Password must be at least 8 characters long.");
                }
            }
        %>
    </p>
    <a class="forgot-password" href="#">Forgot Password?</a>
    <button class="facebook-button">
        <img class="facebook-icon" src="https://icon-library.com/images/official-facebook-logo-icon/official-facebook-logo-icon-20.jpg" alt="Facebook Icon"> Log In with Facebook
    </button>
    <div class="signup-link">
        <p>Don't have an account? <a href="#" class="signup-link">Sign up</a></p>
    </div>
</div>
</body>
</html>
