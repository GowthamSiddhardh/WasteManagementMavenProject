
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RaiseRequest</title>
<style>
body{
background-image: url('images/background1.jpg');
    margin: 0px;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}
/* .loginContent {
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
} */
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
h1.text-center {
    text-align: center;
    color: red;
    font-weight:bold
}
.tss{
position: absolute;
top: 10px;
left: 10px;
}
</style>
</head>
<body>
<div class="tss">
<a href="userhome.jsp"><button><b>HomePage</b></button></a>
</div>
<div class="loginContent">

  <%
	String error=(String)session.getAttribute("notfound"); 
	if(error!=null){
	%>
	
	<h1 class="text-center"><%=error %></h1>
	<%session.removeAttribute("notfound"); %>
	<%} %>
 <%
	String insufficient=(String)session.getAttribute("insufficient"); 
	if(insufficient!=null){
	%>
	
	<h1  class="text-center"><%=insufficient %></h1>
	<%} %>
 
 <%String category=request.getParameter("category"); %>
 
 <form action="RasieRequestController" method="post">
  <h1>Raise The Request</h1>
  <label for="category">Category</label>
  <input type="text" name="category" id="category"  pattern="[a-zA-Z]+" title="category should be in letters" value = <%=category %> required><br><br>
  

  <label for="location">Location</label> 
  <input type="text" name="location" id="location" pattern="[a-zA-Z]+" title="location should be in letters" required ><br><br>
 
  <div class="formBtn">
  <input type="submit" value="RaiseRequest">
  </div>
 
 </form>
</div>
</body>
</html>