<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items ="${requestScope.allData}" var="currentemployee">
<tr>
	<td><input type="radio" name="id" value="${currentemployee.employeeID }"> </td>
	<td>Employer: ${currentemployee.employer }</td>
	<td>Name: ${currentemployee.employeeFirstName }</td>
	<td>${currentemployee.employeeLastName }</td>
	<td>Tenure: ${currentemployee.yearsEmployed } years</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit" name="doThisToEmployee">
<input type="submit" value="Delete" name="doThisToEmployee">
<input type="submit" value="Add" name="doThisToEmployee">
</form>
</body>
</html>