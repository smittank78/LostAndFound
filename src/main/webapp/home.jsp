<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lost And Found</title>
<style>
marquee{  background-color : black ; border : 3px dotted lightblue ; border-radius : 15px ;  }
	
#header{ color : red ;  font-size : 100px ; text-spacing : 1px ; word-spacing : 3px ; text-decoration : underline ; text-transform : uppercase ; text-shadow : 3px 2px 3px yellow ; }
	hr{ border : 5px solid blue ; width = 100px background-color : green ;}
	font{text-size : 15 ; text-spacing : 1px ; word-spacing : 3px ; text-transform : uppercase ; }
	body{  background-image : repeating-linear-gradient(orange,white,green); }
	a{ text-decoration : none ;  color : blue ;}
	a:hover{ color : blue ;  background-color:pink; }
	td:hover{ background-color:black;}
	img{ opacity : 0.5 ; }
	img:hover{ opacity : 1 }
</style>
</head>
<body>
<% 
System.out.println("home page........."); 
String user = (String)session.getAttribute("user");
System.out.println("Login User : " + user);
if( user != null) 
{
%> 
 	<marquee><b><font id="header">Lost And Found Portal</font></b></marquee>
	<br>
<details>
<summary style=" margin-left: 80%;"><button style="width: 80px; height: 20px; background-color: white;">User</button></summary>
<b style=" margin-left: 80%;">User id :</b><%=session.getAttribute("user") %><br>
<b style=" margin-left: 80%;">Login Time :</b><%=session.getAttribute("time") %>
</details>
<br>
	<table style="border:2px; width: 100%;  height : 40px; background-color : lightblue;">
	    <tr>
		<td>
			<a href="home.jsp" ><b><font>HOME</font></b></a>	
		</td>
		
		<td>
			<a href="Enter.jsp" ><b><font>ENTER INFO.</font></b></a>
		</td>
		<td>
			<a href="LostRetriveController" ><b><font>DETAILS</font></b></a>
		</td>
		<td>
			<a href="about.jsp" ><b><font>ABOUT</font></b></a>	
		</td>
		<td>
			<a href="logout.jsp" ><b><font>LOG-OUT</font></b></a>	
		</td>
	    </tr>
	</table>
	<hr>
	<br><br>
	<img src="1.jpg" width = 250px height=300px>
	<img src="2.jpg" width = 250px height=300px>
	<img src="3.jpg" width = 250px height=300px>
	<img src="4.jpg" width = 270px height=300px>
 <%
 }
 else
 {
	 response.sendRedirect("logout.jsp");
 }
	 %>
</body>
</html>