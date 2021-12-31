<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body style="border:10px solid black; text-align: center; width:300px; margin:auto;">
<h1>Login</h1>
<form action="AdminController">
Email Id:<input type="text" name="emailid" autofocus required><br><br>
PassWord:<input type="password" name="password" required><br><br>
<input type="submit" value="login">&nbsp;
<input type="reset" value="Reset">
</form>
</body>
</html>