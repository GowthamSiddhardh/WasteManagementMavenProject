<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body style="border:10px solid black; text-align: center; width:300px; margin:auto;">
<h1>Add Employee</h1>
<form action="EmployeeController" >
Email id:<input type="email" name="emailid" autofocus required><br><br>
Name:<input type="text" name="name" required><br><br>
PassWord:<input type="password" name="password" required><br><br>
Location:<input type="text" name="location" required><br><br>
<input type="submit" value="add">
</form>
</body>
</html>