<%@page import="com.cleaningmanagement.model.Employee"%>
<%@page import="com.cleaningmanagement.daoimpl.EmployeeDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>status</title>
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
    margin: 0px 0px 7px;
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
</style>
</head>
<body>
<a href="adminhome.jsp"><button><b>HomePage</b></button></a>
<% String emailId=request.getParameter("email");
   String status=request.getParameter("status");
   session.setAttribute("emailId", emailId);
   
%>
<div class="loginContent">
<form action="UpdateEmployeeMessage" method="post">
<h1>Status</h1>
<input type="text" name="status" list="EmployeeStatus" autofocus>
<datalist id="EmployeeStatus">
            <option disabled>--select--</option>
            <option value="active">ACTIVE</option>
            <option value="inactive">INACTIVE</option>
</datalist>
<div class="formBtn">
<input type="submit" value="update">
</div>
</form>
</div>
</body>
</html>