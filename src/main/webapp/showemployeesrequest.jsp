<%@page import="java.sql.ResultSet"%>
<%@page import="com.cleaningmanagement.daoimpl.EmployeeDAOImpl"%>
<%@page import="com.cleaningmanagement.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeesRequest</title>
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
h1{
 text-align:center;
 color:red;
 
}
table {
  margin-left: auto; 
  margin-right: auto;
  width:100%
}
table tr:nth-child(even) {
    background: #0000001a;
}
td.buttonLink a {
    text-decoration: none;
    background: black;
    padding: 10px;
    color: white;
}
</style>
</head>
<body>
	<%  Employee employee=(Employee)session.getAttribute("CurrentEmployee");
     EmployeeDAOImpl employeedao=new EmployeeDAOImpl();
     ResultSet rs=employeedao.findEmployeeRequest(employee);
 %>  
    <h1>Request</h1>
	<table class="center">
		<tr>
			<td>RequestID</td>
			<td>UserId</td>
			<td>Category</td>
			<td>Location</td>
			<td>Weight</td>
			<td>Amount</td>
            <td>RequestDate</td>
            <td>EmployeeStatus</td>
            <td>UpdateStatus</td>

		</tr>

		<%while(rs.next()) {%>
		<tr>
			<td><%= rs.getInt(1) %></td>
			<td><%= rs.getInt(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
		    <td><%= rs.getInt(5) %></td>
			<td><%= rs.getInt(6) %></td>
            <td><%= rs.getDate(7) %></td>
            <td><%= rs.getString(8) %></td>
            <td class="buttonLink"><a href="ChangeEmployeeStatus.jsp?Rid=<%= rs.getInt(1) %>">UpdateStatus</a></td>
		</tr>

		<% } %>
	</table>

</body>
</html>