<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
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
.headerMenu a button {
    border: none;
    padding: 10px;
    background: black;
    color: white;
}

.headerMenu {
    display: flex;
    justify-content: space-around;
    background: aliceblue;
    padding: 15px;
}
.headerMenu a button {
    border: none;
    padding: 10px;
    background: black;
    color: white;
    margin: 0px 20px;
    border-radius: 3px;
}
</style>
</head>
<body>
<div class="header">
 <div class="headerMenu">
 	<a href="employee.jsp"><button><b>AddEmployee</b></button></a>
	  <a href="category.jsp"><button><b>AddCategory</b></button></a>
	  <a href="listemployee.jsp"><button><b>UpdateEmployeeStatus</b></button></a>
	  <a href="viewrequest.jsp"><button><b>UpdateRequestStatus</b></button></a>
	  <a href="CalculateWeight.jsp"><button><b>CalculateWeight</b></button></a>
 </div>
</div>
<div class="loginContent">

<form action="EmployeeController" method ="post">
<h1>Add Employee</h1>
<label for="emailid"><b>Email Id:</b></label>
<input type="email" name="emailid" id="emailid" autofocus required><br><br>

<label for="name"><b>Name:</b></label>
<input type="text" name="name" id="name" pattern="[a-zA-Z]+" title="name should be in letters" required><br><br>

<label for="password"><b>Password:</b></label>
<input type="password" name="password" id="password" pattern ="[a-zA-z0-9&@#$_]{8,15}" title="8 or more charecters may includes(&@#$_)" required><br><br>

<label for="location"><b>Location:</b></label>
<input type="text" name="location" id="location" pattern="[a-zA-Z]+" title="location should be in letters" required><br><br>
<div class="formBtn">
<input type="submit" value="Add">
</div>
</form>
</div>
</body>
</html>