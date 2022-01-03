<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<style>
div{
width:30px;
display:inline-block;
text-align:center;
}
</style>
</head>
<body style="border:10px solid black; text-align: center; width:300px; margin:auto;">
<h1>Add Employee</h1>
<form action="EmployeeController" >
<div>
EmailId:<input type="email" name="emailid" autofocus required>
</div><br><br>
<div>
Name:<input type="text" name="name" required>
</div><br><br>
<div>
PassWord:<input type="password" name="password" required>
</div><br><br>
<div>
Location:<input type="text" name="location" required>
</div><br><br>
<input type="submit" value="add">
</form>
</body>
</html>