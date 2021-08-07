<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreateAccount</title>
<style>
	body{ background-image:url("login.jpg");}
	.box1{ width:55%; height:15%; border-width: 5px 0px 5px 0px;  border-style : dashed ; border-color : black ;
	  transform : translate(370px,75px); background-color : magenta; }
	#f1{font-size:40; color:;  padding:10px; font-weight:bold; font-shadow:3px 2px grey;}
	.box2{ width:30%; height:30%; background-color : magenta ;  border:5px groove green; border-radius:10px;
	transform:translate(450px,180px);
	} 
	h2{ margin : 20px 3px 20px 20px ;}
	h3{ margin : 20px ; }
	input{ padding : 3px ; }
	
</style>
</head>
<body>
<div class="box1">
<h1>	<marquee><font id="f1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Create Account to Use L And F </font></marquee> </h1>
</div>
<div class="box2">
	<h2>Create New Account</h2>
	${failed } 
	
						<c:set value="<%=new java.util.Date() %>" var="date"></c:set>
						<fmt:formatDate dateStyle="long" timeStyle="long" type="date" value="${date }" var="Date"/> 
	<form action="CreateAccountController" method="post">
				<table>
						<tr>
							<td> </td>
							<td>${invalid } </td>
						</tr>
						<tr>
							<td> <h3>User I'd &nbsp; </h3></td>
							<td>: <input type="email" name="txtNewUserEmail" required="required" ></td>
						</tr>
						<tr>
							<td><h3>password</h3> </td>
							<td>: <input type="password" name="pwdUserPassword" required="required"></td>
						</tr>
						<tr hidden="hidden">
							<td><h3>Date</h3></td>
							<td>: <input type="text" name="txtTodayDate" value="${Date }" > </td>
						</tr>
						<tr>
							<td> </td>
							<td>
							<a href="L & F.html"><input type="submit" value="Login"></a>
							</td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							
						</tr>
						
				</table>
	</form>
</div>
</body>
</html>