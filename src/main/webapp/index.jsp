<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style>
body {
    background-image: url(images/background.jpg);
    margin: 0px;
    background-size: cover;
    overflow-y:hidden; 
    
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
    justify-content: space-between;
}
.formBtn input {
    margin: 4px 4px;
    width: auto !important;
    padding: 10px 25px !important;
    background: black !important;
    color: white;
    font-weight: bold;
}
#title{
text-align: center;
color:white;
background-color: black;
}
</style>
</head>
<body>
		<h1 id="title">Waste Management System</h1>
<div class="loginContent">

   
	<form action="AdminController" method="post">
		<h1>Login</h1>
	    <label for="emailid"><strong>Email Id</strong></label>
		<input type="email" name="emailid" id="emailid" title="must follow the email format" autofocus required>
	    <label for="password"><strong>Password</strong></label>
	    <input type="password" id="password" name="password" pattern="[a-zA-z0-9&@#$_]{8,15}" title="8 or more characters may includes(&@#$_)" required>
	    <%
		String error=(String)session.getAttribute("invalid"); 
		if(error!=null){
		%>
		
		<p><%=error %></p>
		<%session.removeAttribute("invalid"); %>
		<%}%>
		
		<%String inactive=(String)session.getAttribute("inactive");
		if(inactive!=null)
		{%>
		<p><%=inactive %></p>
		<%session.removeAttribute("inactive"); %>
		<%} %>
	
	    <div class="formBtn">
		    <input type="submit" value="login"> 
		    <a href="userregister.jsp"><input type="button" value="Register"></a>
	    </div>
	
	</form>
	
	
	</div>
</body>
</html>