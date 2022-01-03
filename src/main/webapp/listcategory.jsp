<%@page import="com.cleaningmanagement.model.CategoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.cleaningmanagement.daoimpl.CategoryDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CategoryDetails</title>
<style>
table,tr,td,th{
border:1px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
<h1>Category Details</h1>
<table>
 <tr>
   <th>Weight</th>
   <th>Category</th>
   <th>Amount</th>
 </tr>
 <% 
 CategoryDAOImpl CD = new CategoryDAOImpl();
	List<CategoryDetails> listdetails = CD.listdetails();
	for (int c = 0; c < listdetails.size(); c++) {
		CategoryDetails cd=listdetails.get(c);
 %>
 <tr>
   <td><%=cd.getWeightInKg() %></td>
   <td><%=cd.getCategory() %></td>
   <td><%=cd.getAmount() %></td>
 </tr>
 <%}%>
</table>
</body>
</html>