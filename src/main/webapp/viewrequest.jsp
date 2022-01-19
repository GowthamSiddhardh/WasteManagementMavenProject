<%@page import="com.cleaningmanagement.model.Request"%>
<%@page import="java.util.List"%>
<%@page import="com.cleaningmanagement.daoimpl.RequestDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updateStatus</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  
}
th, td {
  padding: 15px;
}
body{
    
    background-color:lightyellow;
}

table.center {
  margin-left: auto; 
  margin-right: auto;
  width:100%
}
h1
{ 
  text-align:center;
  color:red;
}
table tr:nth-child(even) {
    background: #0000001a;
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
.serach input {
    padding: 10px;
    font-size: 15px;
    text-transform: capitalize;
    font-weight: bold;
}
.serach {
    text-align: right;
    margin-bottom: 12px;
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
   <h1>RequestDetails</h1>
   <form action="SearchController" class="serach">
<label for="search"></label>
<input type="text" name="search" id="search" placeholder="search">
<input type="submit" value="search">
</form>
<%String Status=(String)session.getAttribute("status");
if(Status!=null){
%>
<h3><%=Status %></h3>
<%session.removeAttribute("status"); %>
<%} %>
 <table class="center">
  
  <tr>
    <th>RequestId</th>
    <th>UserName</th>
    <th>EmployeeName</th>
    <th>Category</th>
    <th>Location</th>
    <th>RequestStatus</th>
    <th>EmployeeStatus</th>
    <th>RequestDate</th>
    <th>Update</th>
    
  </tr>
  <%  RequestDAOImpl requestdao=new RequestDAOImpl();
      List<Request> list=requestdao.showRequest();
      for(int i=0;i<list.size();i++)
      {
    	  Request req=list.get(i);
    
  %>
    <tr>
     <td><%=req.getRequestId() %></td>
     <td><%= req.getUser().getUserName() %></td>
     <td><%= req.getEmployee().getEmpName() %></td>
     <td><%= req.getCatogories() %></td>
     <td><%= req.getLocation() %></td>
     <td><%= req.getStatus() %></td>
     <td><%=req.getEmployeestatus() %></td>
     <td><%= req.getRequestDate() %></td>
     
     <td><a href="UpdateRequestStatus.jsp?Rid=<%=req.getRequestId() %>&empstatus=<%=req.getEmployeestatus() %>"><button>UpdateStatus</button></a></td>
     
    </tr> 
  <%} %>
 </table>
</body>
</html>