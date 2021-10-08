<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit List</title>
</head>
<body>
<form action="editEmployeeListDetailsServlet" method="post">
<input type="hidden" name="id" value="${listToEdit.id}">
List Name: <input type="text" name="listName" value="${listToEdit.listName}"> <br />

List Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
		   <input type="text" name="day" placeholder="dd" size="4" value="${day}">
		   <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
		   
Employee Name: <input type="text" name="employeeName" value="${listToEdit.employee.employeeName}"> <br />

Available Employees: <br />

<select name="allEmployeesToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
  <option value="${currentitem.id}">${currentitem.employer} | ${curentitem.firstName} ${currentitem.lastName} | ${currentitem.yearsEmployeed}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Edit List and Employees">
</form>
<a href="index.html">Home - Add new</a>
</body>
</html>