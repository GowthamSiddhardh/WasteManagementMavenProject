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
  width:100%;
}
button{
   color:blue;
   border:none;
   
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
</style>
</head>
<body>
<div class="header">
 <div class="headerMenu">
 	<a href="employee.jsp"><button><b>Add Employee</b></button></a>
	  <a href="category.jsp"><button><b>Add Category</b></button></a>
	  <a href="listemployee.jsp"><button><b>updateEmployeeStatus</b></button></a>
	  <a href="viewrequest.jsp"><button><b>updateRequestStatus</b></button></a>
	  <a href="CalculateWeight.jsp"><button><b>CalculateWeight</b></button></a>
 </div>
</div>
  <h1>Employee Details</h1>
  <table class="center">
  <tr>
    <th>EmployeeId</th>
    <th>EmailId</th>
    <th>Name</th>
    <th>Password</th>
    <th>Location</th>
    <th>Status</th>
    <th>UpdateStatus</th>
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
    <td><a href="ChangeStatus.jsp?email=<%=emp.getEmpEmail() %>&status=<%=emp.getStatus() %>"><button>UpdateStatus</button></a></td>
   </tr>
   <%}%>
     
    
  </table>
  
  
</body>
</html>