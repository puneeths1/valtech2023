
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department and Employee Information</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #222;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #333;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h1 {
            color: #007bff;
            text-align: center;
        }
        .info-box {
            background-color: #444;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 20px;
            padding: 15px;
        }
        .button-container {
            text-align: center;
        }
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            margin-bottom: 5px;
        }
        .department-list {
            list-style: none;
            padding: 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .department-list li {
            width: 30%;
            background-color: #555;
            border: 1px solid #007bff;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
            text-align: center;
        }
        .employee-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .employee-table th, .employee-table td {
            border: 1px solid #007bff;
            padding: 8px;
            text-align: left;
        }
        .employee-table th {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Department and Employee Information</h1>

        <div class="info-box">
            <c:if test="${not empty currentDepartment}">
                <h2>Department: ${currentDepartment.dname}</h2>
            </c:if>

            <c:if test="${not empty employeeByDepartment}">
                <h2>Employees in Current Department</h2>
                <table class="employee-table">
                    <tr>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Age</th>
                    </tr>
                    
                        <tr>
                            <td>${employeeByDepartment.eid}</td>
                            <td>${employeeByDepartment.name}</td>
                            <td>${employeeByDepartment.age}</td>
                        </tr>
                 
                </table>
            </c:if>
        </div>

        <h2>All Departments</h2>
        <ul class="department-list">
            <c:if test="${not empty departments}">
                <c:forEach items="${departments}" var="department">
                    <li>
                        <a href="DepartmentEmployeeServlet?deptId=${department.did}&action=none">
                            ${department.dname}
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</body>
</html>


