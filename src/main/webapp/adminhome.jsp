<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    background-image: url('images/background1.jpg');
    height: 100vh;
    margin: 0px;
    display: flex;
    align-items: center;
    justify-content: center;
}
.headerMenu a button {
    border: none;
    padding: 10px;
    background: black;
    color: white;
    margin: 0px 20px;
    border-radius: 3px;
}
button{
   color:blue;
   background-color:lightyellow;
}
h1{
 text-align:center;
 color:red;
 
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
</style>
</head>
<body>
<div class="header">
 <h1>Welcome</h1>
 <div class="headerMenu">
 	<a href="employee.jsp"><button><b>AddEmployee</b></button></a>
	  <a href="category.jsp"><button><b>AddCategory</b></button></a>
	  <a href="listemployee.jsp"><button><b>UpdateEmployeeStatus</b></button></a>
	  <a href="viewrequest.jsp"><button><b>UpdateRequestStatus</b></button></a>
	  <a href="CalculateWeight.jsp"><button><b>CalculateWeight</b></button></a>
 </div>
</div>
</body>
</html>