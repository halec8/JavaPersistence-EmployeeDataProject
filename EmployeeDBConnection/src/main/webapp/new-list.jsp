<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<form action="createNewListServlet" method="post">
List Name: <input type="text" name = "listName"><br />
List Date: <input type="text" name="month" placeholder="mm" size="4">
		   <input type="text" name="day" placeholder="dd" size="4">,
		   <input type="text" name="year" placeholder="yyyy" size="4">
Employee Name: <Input type="text" name="employeeName"><br />


Available Employees: <br />
<select name="allEmployeesToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitems">
 <option value = "${currentitem.id}">${currentitem.employer} | ${currentitem.employeeFirstName} ${currentitem.employeeLastName} | ${currentitem.yearsEmployed }</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create List and Add Employees">
</form>
<a href="index.html">Add new Employees</a>
</body>
</html>