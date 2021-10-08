<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<form action="editEmployeeServlet" method="post">
Company: <input type="text" name="company" value="${employeeToEdit.employer }">
First Name: <input type="text" name="firstName" value="${employeeToEdit.employeeFirstName }">
Last Name: <input type="text" name="lastName" value="${employeeToEdit.employeeLastName }">
Tenure: <input type="text" name="yearsWorked" value="${employeeToEdit.yearsEmployed }">
<input type="hidden" name="id" value="${employeeToEdit.employeeID }">
<input type="submit" value="Save Edited Employee">
</form>
</body>
</html>