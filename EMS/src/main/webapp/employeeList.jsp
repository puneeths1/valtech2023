<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: purple">
			<div>
				<p class="navbar-brand"> Employee Management Application </p>
			</div>
			
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employee</h3>
			<hr>
			<div class="container text-right">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
			</div>
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Emp_ID</th>
						<th>Emp_Name</th>
						<th>Age</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>Salary</th>
						<th>Dept_ID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="Employee" items="${getAllEmployees}">

						<tr>
							<td><c:out value="${Employee.eid}" /></td>
							<td><c:out value="${Employee.name}" /></td>
							<td><c:out value="${Employee.age}" /></td>
							<td><c:out value="${Employee.experience}" /></td>
							<td><c:out value="${Employee.seniority}" /></td>
							<td><c:out value="${Employee.salary}" /></td>
							<td><c:out value="${Employee.did}" /></td>
							<td><a href="edit?eid=<c:out value='${Employee.eid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?eid=<c:out value='${Employee.eid}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="show?eid=<c:out value='${Employee.eid}' />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>