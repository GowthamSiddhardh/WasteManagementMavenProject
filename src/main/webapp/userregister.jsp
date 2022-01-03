<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
width:30px;
display:inline-block;
text-align:center;
}
</style>
</head>
<body style="border:10px solid black; text-align: center; width:300px; margin:auto;">
  <h1>User Register</h1>
  <form action="UserRegisterController">
   EmailId:<input type="email" name="emailid" autofocus required><br>
   Name:<input type="text" name="name" required><br>
   PassWord:<input type="password" name="password" required><br>
   Address:<input type="text" name="address" required><br>
   MobileNumber:<input type="number" name="mobilenumber" required><br>
   <input type="submit" value="register" required>
  </form>
</body>
</html>