<%@page import="java.sql.ResultSet"%>
<%@page import="com.cleaningmanagement.daoimpl.UserDAOImpl"%>
<%@page import="com.cleaningmanagement.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteRequest</title>
<style type="text/css">
table,tr,th,td{
border:1px solid black;
border-collapse:collapse;

}
</head>
<body>
<%!User user;
ResultSet rs;
%>
<% 
  user=(User)session.getAttribute("CurrentUser");
 UserDAOImpl userdao = new UserDAOImpl();
  rs= userdao.userBill(user);
 %>
 <table>
		<tr>
			<th>RequestID</th>
			<th>UserId</th>
			<th>Category</th>
			<th>Weight</th>
			<th>Amount</th>
			<th>EmployeeId</th>
			<th>RequestDate</th>
			<th>Location</th>
			<th>Delete</th>
		</tr>
		   <%while(rs.next()) {%>
        <tr>
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getInt(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getInt(4) %></td>
			<td><%=rs.getInt(5) %></td>
			<td><%=rs.getInt(6) %></td>
			<td><%=rs.getDate(7) %></td>
			<td><%=rs.getString(8) %></td>
			<td><a href="Deleteserv?rid=<%=rs.getString(2)%>&cat=<%=rs.getString(3)%>&loc=<%=rs.getString(8)%>&amount=<%=rs.getInt(5) %>">Delete</a></td>
		</tr>
		<% } %>
</body>
</html>