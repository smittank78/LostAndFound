<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>Login Page</title>
<style>
	body{ background-image:url("login.jpg");}
	.box1{ width:56%; height:8%; border-width: 3px 0px 3px 0px;  border-style : groove; ; border-color : navy;
	  transform : translate(397px,55px); background-color : black; margin-left: 40px;}
	#f1{font-size:40; color:blue;  padding:10px; font-weight:bold; font-shadow:3px 2px grey;}
	.box2{ width:40%; height:30%; background-color : lime ;  border-width: 3px 0px 3px 0px;  border-style : groove; ; border-color : navy;  border-radius:10px;
	transform:translate(550px,90px);
	} 
	h2{ margin : 20px 3px 20px 20px ;}
	h3{ margin : 20px ; }
	input{ padding : 3px ; }
	
</style>
</head>
<body>
<%
System.out.println("login page.....");
%>
<div class="box1">
<h1>	<marquee><font id="f1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Please Login to Use L And F </font></marquee> </h1>
</div>
<div class="box2">
	<h2>-------------Login ------------</h2> 
	<form action="LoginController" method="post">
				<table>
						<tr>
							<td> <font size="4px" color="red">${invalid } </font> </td>
						</tr>
						<% session.invalidate(); %>
						<tr>
							<td> <h3>User I'd  </h3></td>
							<td>: <input type="email" name="txtUserEmail"></td>
						</tr>
						<tr>
							<td><h3>password</h3> </td>
							<td>: <input type="password" name="pwdUserPassword"></td>
						</tr>
						<tr  hidden="hidden">
							<td><h3>Date</h3> </td>
							<c:set value="<%=new Date() %>" var="date"></c:set>
							<td>: <input type="text" name="LoginTime" value="${date }"></td>
						</tr>
						<tr>
							<td> </td>
							<td>
							<table style="width: 150px;">
							<tr>
							<td><input type="reset" value="RESET"> </td>
							<td><a href="L & F.html"><input type="submit" value="Login"></a>
							</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							
						</tr>
						
				</table>
			<center> 	<a href="ResetPasswordGetOtpController " style="font-size: 20px;'">Reset Passord </a>  </center> <br>
		    <center>	<a href="CreateAccount.jsp"><font size="5px" color="red">Create New Account</font></a>   </center>
				</form>
</div>
</body>
</html>