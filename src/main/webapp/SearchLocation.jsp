<%@page import="com.cleaningmanagement.model.Request"%>
<%@page import="java.util.List"%>
<%@page import="com.cleaningmanagement.daoimpl.RequestDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  
}
th, td {
  padding: 15px;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
  width:100%
}
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
h1
{ 
  text-align:center;
  color:red;
}
</style>
</head>
<body>
<h1>RequestDetails</h1>
 <table class="center">
  
  <tr>
    <th>RequestId</th>
    <th>UserName</th>
    <th>EmployeeName</th>
    <th>Category</th>
    <th>Location</th>
    <th>RequestStatus</th>
    <th>EmpoyeeStatus</th>
    <th>RequestDate</th>
    <th>Update</th>
    
  </tr>
  <%  
      List<Request> searchreq=(List<Request>)session.getAttribute("list");
      for(int i=0;i<searchreq.size();i++)
      {
    	  Request req=searchreq.get(i);
      
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
     
     <td><a href="UpdateRequestStatus.jsp?Rid=<%=req.getRequestId() %>"><button>UpdateStatus</button></a></td>
     
    </tr> 
  <%} %>
 </table>
</body>
</html>