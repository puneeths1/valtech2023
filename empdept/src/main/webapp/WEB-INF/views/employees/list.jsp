<%@page import="com.assignment.empdept.models.DepartmentModels"%>
<%@page import="com.assignment.empdept.models.EmployeeModels"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of All Employees</title>

<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
	rel="stylesheet">

</head>
<body class="bg-gray-100">
	<h1 class="text-3xl font-bold mb-8" align="center">List of Employees</h1>
	<%
	List<EmployeeModels> employees = (List<EmployeeModels>) request.getAttribute("employees");
	%>
	<%
	DepartmentModels departmentModels = (DepartmentModels) request.getAttribute("departments");
	%>
	<table class="min-w-full bg-white border border-gray-300">
		<!-- Department Table Header -->
		<thead>
			<tr>
				<th class="py-2 px-4 border-b">Department_ID</th>
				<th class="py-2 px-4 border-b">Department_Name</th>
				<th class="py-2 px-4 border-b">Department_Location</th>
			</tr>
		</thead>
		<%
		request.setAttribute("department", departmentModels);
		%>
		<tbody>
			<tr align="center">
				<td class="py-2 px-4 border-b">${department.id}</td>
				<td class="py-2 px-4 border-b">${department.dname}</td>
				<td class="py-2 px-4 border-b">${department.dlocation}</td>
			</tr>
		</tbody>
	</table>

	
	
		<div colspan="2" align="center">
			<form action="list" method="post" >
				<input type="submit" name="submit" value="First" class="bg-gray-500 text-white py-2 px-4 rounded"> 
				<input type="submit" name="submit" value="Previous" class="bg-gray-500 text-white py-2 px-4 rounded"> 
				<input type="submit" name="submit" value="Next" class="bg-gray-500 text-white py-2 px-4 rounded"> 
				<input type="submit" name="submit" value="Last" class="bg-gray-500 text-white py-2 px-4 rounded">
			</form>
		</div>
	
	</table>
	<table class="mt-8 min-w-full bg-white border border-gray-300">
		<!-- Employee Table Header -->
		<thead>
			<tr>
				<th class="py-2 px-4 border-b">Employee_ID</th>
				<th class="py-2 px-4 border-b">Employee_Name</th>
				<th class="py-2 px-4 border-b">Age</th>
				<th class="py-2 px-4 border-b">Experience</th>
				<th class="py-2 px-4 border-b">Seniority</th>
				<th class="py-2 px-4 border-b">Salary</th>
				<th class="py-2 px-4 border-b">Department_ID</th>
				<th class="py-2 px-4 border-b">Actions</th>
			</tr>
		</thead>
		<%
		for (EmployeeModels employee : employees) {
			request.setAttribute("employee", employee);
		%>
		<tbody>
			<tr align="center">
				<td class="py-2 px-4 border-b">${employee.id}</td>
				<td class="py-2 px-4 border-b">${employee.name}</td>
				<td class="py-2 px-4 border-b">${employee.age}</td>
				<td class="py-2 px-4 border-b">${employee.experience}</td>
				<td class="py-2 px-4 border-b">${employee.seniority}</td>
				<td class="py-2 px-4 border-b">${employee.salary}</td>
				<td class="py-2 px-4 border-b">${employee.department.id}</td>
				<td class="py-2 px-4 border-b"><a
					href="delete?id=${employee.id}" class="text-red-500">Delete</a> <a
					href="edit?id=${employee.id}" class="text-blue-500 ml-2">Edit</a></td>
			</tr>
		</tbody>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="8" class="text-right py-4 px-4">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add New Employee"
							class="bg-blue-500 text-white py-2 px-4 rounded">			
					</form>
					
				</td>
				
			</tr>
		</tfoot>
	</table>
</body>
</html>