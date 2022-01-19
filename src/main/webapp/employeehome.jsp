<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeHome</title>
</head>
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
h1.text-center {
    text-align: center;
    color: white;
    margin:0px;
    margin-top:21px
}
.loginContent a {
    color: white;
    font-size: 37px;
    text-decoration: none;
    background: black;
    padding: 16px;
    border-radius: 3px;
}
</style>
<body>
 <form>
 <h1 class="text-center">Welcome</h1>
  <div class="loginContent">
  <a href="showemployeesrequest.jsp"><b>ShowRequest</b></a>
  </div>
  
  
 </form>
</body>
</html>