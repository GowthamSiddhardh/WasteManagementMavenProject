<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHomePage</title>
<style>
body {
    background-image: url('images/background1.jpg');
    height: 100vh;
    margin: 0px;
    display: flex;
    align-items: center;
    justify-content: center;
}
.headerMenu a button {
    border: none;
    padding: 10px;
    background: black;
    color: white;
    margin: 0px 20px;
    border-radius: 3px;
}
button{
   color:blue;
   background-color:lightyellow;
}
h1{
 text-align:center;
 color:red;
 
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
<h1>Welcome</h1>
   <div class="headerMenu">
  <a href="listcategory.jsp"><button><b>AvailableCategories</b></button></a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  <a href="rechargewallet.jsp"><button><b>RechargeWallet</b></button></a>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
  <a href="deleterequest.jsp"><button><b>DeleteRequest</b></button></a>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
 </div>
</div>
</body>
</html>