<%@page import="com.cleaningmanagement.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.cleaningmanagement.daoimpl.EmployeeDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddedListEmployee</title>
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
table.center {
  margin-left: auto; 
  margin-right: auto;
}
table{
width:100%
}
table tr:nth-child(even) {
    background: #0000001a;
}
</style>
</head>
<body>
<h1>Employee Details</h1>
  <table class="center">
  <tr>
    <th>EmployeeId</th>
    <th>EmailId</th>
    <th>Name</th>
    <th>Password</th>
    <th>Location</th>
    <th>Status</th>
    
  </tr>
  <% 
     
    EmployeeDAOImpl employee=new EmployeeDAOImpl();

	 List<Employee> list=employee.showEmployee();
	for (int j = 0; j < list.size(); j++) {
		Employee emp=list.get(j);
		int empId= employee.findEmpId(emp);
		
  %>
  <tr>
    <td><%=empId%></td>
    <td><%=emp.getEmpEmail() %></td>
    <td><%=emp.getEmpName() %></td>
    <td><%=emp.getEmpPassWord() %></td>
    <td><%=emp.getLocation() %></td>
    <td><%=emp.getStatus() %></td>
    
    
   </tr>
   <%}%>
     
    
  </table>
  

</body>
</html>