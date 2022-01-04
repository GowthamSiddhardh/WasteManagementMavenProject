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
<style type="text/css">
table,tr,th,td{
border:1px solid black;
border-collapse:collapse;

}
<style>
table,tr,td,td
</style>
</head>
<body>
 <%  Employee employee=(Employee)session.getAttribute("CurrentEmployee");
     EmployeeDAOImpl employeedao=new EmployeeDAOImpl();
     ResultSet rs=employeedao.findEmployeeRequest(employee);
 %>
   <table>
		<tr>
			<th>RequestID</th>
			<th>UserId</th>
			<th>Category</th>
			<th>Location</th>
			<th>Weight</th>
			<th>Amount</th>
			<th>EmployeeId</th>
			<th>RequestDate</th>
		</tr>

		<%while(rs.next()) {%>
		<tr>
			<td><%= rs.getInt(1) %></td>
			<td><%= rs.getInt(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %><td>
			<td><%= rs.getInt(5) %></td>
			<td><%= rs.getInt(6) %></td>
			<td><%= rs.getInt(7) %></td>
			<td><%= rs.getDate(8) %></td>
		</tr>
		
		<% } %>
	</table>

</body>
</html>