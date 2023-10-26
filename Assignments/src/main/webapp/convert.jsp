<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Number System Converter</title> 
<style>
    .convert-bg {
        background-color: #f0f0f0;
    }
    .convert-container {
        text-align: center;
        margin: 20px auto;
        width: 60%;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .title {
        font-size: 24px;
        color: #333;
    }
    .label {
        font-weight: bold;
        color: #333;
    }
    .form-control {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        background-color: #0077b6;
        color: #fff;
        text-decoration: none;
        border: none;
        border-radius: 5px;
        margin-top: 20px;
        cursor: pointer;
    }
    .btn:hover {
        background-color: #005a8b;
    }
</style>
</head> 
<body class="convert-bg"> 
 <div class="container convert-container"> 
  <h1 class="title">Number System Converter</h1> 
  <form action="NumberSystemServlet" method="post"> 
   <div class="form-group"> 
    <label for="system" class="label">Number System:</label> 
    <select id="system" name="system" class="form-control"> 
     <option value="hex">Hexadecimal</option> 
     <option value="dec">Decimal</option> 
     <option value="bin">Binary</option> 
     <option value="oct">Octal</option> 
     <option value="pow2">hecto</option> 
     <option value="pow6">mega</option> 
     <option value="pow9">giga</option> 
     <option value="pow12">tera</option> 
     <option value="pow-6">micro</option> 
     <option value="pow-9">nano</option> 
    </select> 
   </div> 
   <div class="form-group"> 
    <label for="input1" class="label">Input 1:</label> 
    <input type="text" id="input1" name="input1" class="form-control"><br> 
   </div> 
   <div class="form-group"> 
    <label for="input2" class="label">Input 2:</label> 
    <input type="text" id="input2" name="input2" class="form-control"><br> 
   </div> 
   <button type="submit" class="btn btn-primary">Convert</button> 
  </form> 
 </div> 
</body> 
</html>
