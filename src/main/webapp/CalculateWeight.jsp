<%@page import="java.sql.ResultSet"%>
<%@page import="com.cleaningmanagement.daoimpl.RequestDAOImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WeightCalculation</title>
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
h1{
    text-align: center;
    color: red;
    font-weight: bold;}
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
 
    <%
   // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String location=(String)session.getAttribute("location");
    Date fromdate=(Date)(session.getAttribute("fromdate"));
    Date todate=(Date)(session.getAttribute("todate"));
    if(location!=null)
    {
    RequestDAOImpl requestdao=new RequestDAOImpl();
	ResultSet rs=requestdao.CalculateAmount(location, fromdate, todate);
	if(rs.next()){
    %>
    
      <h1>Weight:<%=rs.getInt(1)%>Kg</h1>
    
   <%}%>
   <%}%> 
   
<div class="loginContent">
  <form action="CalculateWeight" method="post">
  <h1>CalculateWeight</h1>
  
  <label for="fromdate"><strong>FromDate</strong></label>
  <input type="date" name="fromdate" id="fromdate" required ><br><br>
  
  <label for="todate"><strong>ToDate</strong></label>
  <input type="date" name="todate" id="todate" required ><br><br>
  
  <label for="location"><strong>Location</strong></label>
  <input type="type" name="location" id="location" pattern="[a-zA-Z]+" title="invalid location" required ><br><br>
  <div class="formBtn">
  <input type="submit" value="Calculate">
 </div>
 </div>
  </form>
  <script>
  var today = new Date();
  var dd = today.getDate()-7;
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();
  if(dd<10){
    dd='0'+dd
  } 
  if(mm<10){
    mm='0'+mm
  } 

  today = yyyy+'-'+mm+'-'+dd;
  
  document.getElementById("fromdate").setAttribute("min", today);
  document.getElementById("todate").setAttribute("min", today);
  today = new Date();
  dd = today.getDate();
  mm = today.getMonth() +1;
  yyyy = today.getFullYear();
   if(dd<10){
	    dd='0'+dd
	} 
   if(mm<10){
	    mm='0'+mm
	} 

  today = yyyy+'-'+mm+'-'+dd;
  document.getElementById("fromdate").setAttribute("max", today);
  document.getElementById("todate").setAttribute("max", today);
  </script>
</body>
</html>