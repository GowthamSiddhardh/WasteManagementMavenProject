<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
<style>
body{
background-image: url('images/background1.jpg');
    margin: 0px;
}
.loginContent {
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}
.loginContent form {
    background: white;
    padding: 15px;
    text-align: left;
}
.loginContent form label {
    font-weight: bold;
}
.loginContent form h1 {
    margin: 0px 0px 20px;
    text-align: center;
}
.loginContent form input {
    width: 95%;
    border: none;
    background: aliceblue;
    padding: 10px;
    margin: 10px 0px;
}
.loginContent form {
    background: white;
    padding: 15px;
    text-align: left;
    width:25%
}
.formBtn {
    display: flex;
    justify-content: center;
}
.formBtn input {
    margin: 4px 4px;
    width: auto !important;
    padding: 10px 25px !important;
    background: black !important;
    color: white;
    font-weight: bold;
}
h1{
    text-align: center;
    color: red;
    font-weight: bold;}
</style>
</head>
<body>
<% String EmailId=(String)session.getAttribute("email");
if(EmailId!=null){
%>
<h1><%=EmailId %></h1>
<%session.removeAttribute("email"); %>
<%} %>

<div class="loginContent">
  <form action="UserRegisterController" method="post">
   <h1>User Register</h1>
   <label for="emailid"><strong>Email Id</strong></label>
   <input type="email" name="emailid" id="emailid"  autofocus required>
   <label for="name"><strong>Name</strong></label>
   <input type="text" name="name" id="name" pattern="[a-zA-Z.]+" title="the name should be in the format of (a-zA-Z.) " required><br>
   <label for="password"><strong>Password</strong></label>
   <input type="password" name="password" id="password" pattern="[a-zA-z0-9&@#$_]{8,15}" title="8 or more characters may includes(&@#$_)" required>
   <label for="address"><strong>Address</strong></label>
   <input type="text" name="address" id="address"  required>
   <label for="number"><strong>Number</strong></label>
   <input type="text" name="mobilenumber" id="number" pattern="[0-9]{10}" title="must have 10digits" required>
   	<div class="formBtn">
   	<input type="submit" value="register">
  	</div>
  </form>
 </div>
</body>
</html>