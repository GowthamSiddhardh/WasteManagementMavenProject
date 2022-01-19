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
  width:100%;
  margin-top:40px
}
table tr:nth-child(even) {
    background: #0000001a;
}
.headerMenu a button {
    border: none;
    padding: 10px;
    background: black;
    color: white;
    margin: 0px 20px;
    border-radius: 3px;
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
</style>
</head>
<body>
<div class="header">
   <div class="headerMenu">
  <a href="listcategory.jsp"><button><b>AvailableCategories</b></button></a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  <a href="rechargewallet.jsp"><button><b>RechargeWallet</b></button></a>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
  <a href="deleterequest.jsp"><button><b>DeleteRequest</b></button></a>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
 </div>
</div>
<%

if(session.getAttribute("deleterequest") != null ){%>
	<h1>Successfully Deleted!!</h1>
	<h2>Amount Refunded to your Wallet</h2>
	<%session.removeAttribute("deleterequest"); %>
<% }
%>
<%!User user;
ResultSet rs;
%>
<% 
  user=(User)session.getAttribute("CurrentUser");
 UserDAOImpl userdao = new UserDAOImpl();
  rs= userdao.userBill(user);
 %>
 
 <table class="center">
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
			<td><a href="Deleteserv?rid=<%=rs.getString(2)%>&cat=<%=rs.getString(3)%>&loc=<%=rs.getString(8)%>&amount=<%=rs.getInt(5) %>"><button>Delete</button></a></td>
		</tr>
		<% } %>
</table>
</body>
</html>