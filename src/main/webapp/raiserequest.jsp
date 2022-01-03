
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RaiseRequest</title>
<style>
table,tr,td,th{
border:1px solid black;
border-collapse:collapse;

}
</style>
</head>
<body style="border:10px solid black; text-align: center; width:300px; margin:auto;">
 <h1>Raise The Request</h1>
 <form action="RasieRequestController">
  Category:<input type="text" name="category"><br>
  Location:<input type="text" name="location"><br>
  <input type="submit" name=RaiseRequest">

 
 </form>
</body>
</html>