<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-900 text-white">
    <form action="login" method="post" class="w-1/3 mx-auto mt-8 p-8 bg-gradient-to-r from-purple-800 to-blue-800 shadow-lg rounded-md">
    <h1 class="text-3xl font-bold mb-4">Login</h1>
    <div class="mb-4">
        NAME: <input class="w-full px-3 py-2 border border-gray-500 rounded bg-gray-700 text-white" name="name" type="text" placeholder="Enter your Name"/><br />
        </div>
    <div class="mb-4">    
    PASSWORD: <input class="w-full px-3 py-2 border border-gray-500 rounded bg-gray-700 text-white" name="pass" type="password" placeholder="Enter your pasword" />
    </div><br />
        <input class="w-full bg-yellow-500 text-white font-semibold px-4 py-2 rounded hover:bg-yellow-600" name="submit" type="submit" value="Login" />
    </form>
</body>
</html>
