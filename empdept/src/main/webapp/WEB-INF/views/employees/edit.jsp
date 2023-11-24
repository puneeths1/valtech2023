<%@page import="com.assignment.empdept.models.EmployeeModels"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

form {
	max-width: 600px;
	margin: 20px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

td {
	padding: 10px;
	border-bottom: 1px solid #ddd;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	margin-bottom: 10px;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

input[type="submit"], input[type="button"] {
	margin-right: 10px;
}

input[type="button"] {
	background-color: #ccc;
	color: #333;
}
</style>
</head>
<body>
	<%
	EmployeeModels employees = (EmployeeModels) request.getAttribute("employees");
	%>
	<form method="post" action="save?id=<%=employees.getId()%>">
		<table>
			<tr>
				<td>Employee_ID</td>
				<td><input type="text" disabled="disabled" name="id"
					value="<%=employees.getId()%>" /></td>
			</tr>
			<!-- Include other form fields as needed -->
			<tr>
				<td>Employee_Name</td>
				<td><input type="text" name="name"
					value="<%=employees.getName()%>" /></td>
			</tr>
			<!-- Add styling for other form fields -->
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"
					value="<%=employees.getAge()%>" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience"
					value="<%=employees.getExperience()%>" /></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority"
					value="<%=employees.getSeniority()%>" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"
					value="<%=employees.getSalary()%>" /></td>
			</tr>
			<tr>
				<td>Department_ID</td>
				<td><input type="text" name="department"
					value="<%=employees.getDepartment().getId()%>" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Create" /> <input type="button" name="cancel"
					value="Cancel" onclick="window.history.back();" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
