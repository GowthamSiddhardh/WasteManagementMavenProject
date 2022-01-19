<%@page import="java.sql.ResultSet"%>
<%@page import="com.cleaningmanagement.daoimpl.UserDAOImpl"%>
<%@page import="com.cleaningmanagement.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>billPage</title>
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
</style>
</head>
<body>
<a href="userhome.jsp"><button><b>HomePage</b></button></a>
<h1>Bill</h1>
	<%!User user; %>
	<%!int Amount; %>
	
	<% 
 user=(User)session.getAttribute("CurrentUser");

 UserDAOImpl userdao = new UserDAOImpl();
 ResultSet rs = userdao.showbill(user);
  
 %>
   
	<table>
		<tr>
			
			<th>UserName</th>
			<th>Location</th>
			<th>Category</th>
			<th>Weight</th>
			<th>RequestDate</th>
			<th>Amount</th>
			
		</tr>
        
        <%if(rs.next()){ %>
         <tr>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getInt(4) %></td>
			<td><%=rs.getDate(5) %></td>
			<td><%=rs.getInt(6) %></td>
			
		</tr>
		<%Amount=rs.getInt(6); %>
		<%} %>
	</table>
	<%  
     UserDAOImpl userdao1 = new UserDAOImpl();
	boolean b1 = userdao1.updateWallet(user, Amount);
	if(b1){%>
	 <h1><%= Amount%>
		&nbsp;Successfully deducted!!
	</h1>
	  
	<%} %>
	  
</body>
</html>