<%@page import="com.cleaningmanagement.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.cleaningmanagement.daoimpl.EmployeeDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListEmployee</title>
<style type="text/css">
table,tr,th,td{
border:1px solid black;
border-collapse:collapse;

}
</style>
</head>
<body>
  <h1>Employee Details</h1>
  <table>
  <tr>
    <th>EmployeeId</th>
    <th>EmployeeEmailId</th>
    <th>EmployeeName</th>
    <th>EmployeePassword</th>
    <th>EmployeeLocation</th>
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
   </tr>
   <%}%>
     
    
  </table>
  
  
</body>
</html>