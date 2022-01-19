<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="ISO-8859-1">
<title>CategoryDetails</title>
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
<form action="CategoryController" method = "post">
<h1>Category Details</h1>
<label for="weight"><b>Weight</b></label>
<input type="text" name="weight" id="weight" pattern="[0-9]+" title="weight should be in positive value" required autofocus><br><br>

<label for="category"><b>Category</b></label>
<input type="text" name="category" id="category" pattern="[a-zA-Z]+" title="it should not contain numbers" required><br><br>

<label for="amount"><b>Amount</b></label>
<input type="text" name="amount" id="amount" pattern="[0-9]+" title="amount should be in positive value" required><br><br>
<div class="formBtn">
<input type="submit" value="Add">
</div>
</form>
</div>
</body>
</html>