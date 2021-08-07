<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<h4 align="right"><a href="home.jsp"><button>Back to Home Page</button></a></h4>
<title>HomePage</title>
<style>
	font{ text-spacing:1px; word-spacing:3px; }
	body{ background-image:url("About.png"); 
	background-color:green;	
	background-repeat: no-repeat;
	}
</style>
</head>
<body><% 
System.out.println("About page........."); 
String user = (String)session.getAttribute("user");
System.out.println("Login User : " + user);
if( user != null) 
{
%> 
<pre>
<marquee><font size=10 color=red ><b>About Lost And Found Web-Site</b></font></marquee>
<font size=5 color=pink>
        <b> Lost And Found Portal </b> is stand to help those peoples who lost their property like mobile , vollet , 
      key , books , bag , manual , documents , papers , file ,charger ,etc ...  
	L & F site  is  very use full for college students & faculty .
 
 	if you Lost your books then ?????????
 	where lost ?  
	throungh L & F site tou should send the detail about lost property to other peoples if any person found 
 	that property then he/she give back property to you or if he gives property to any head or incharge or  
 	security then he send detail about  where he submitted property................
 
 	for use this web-site user need to log-in through your email id .this web-site is for those who 
	intrects with that  particular place/college/school/hospital/society .
 	how to use L & F Site ?
 	if you lost or found property then?
 	Login --->ENTER INFO. -->found/lost -->enter details ........ -->click submit . 

 	if you found any property and owner of that alredy submitted details about that thing then ? 
	Login --->Details -->click that particular detail -->click messege -->give information -->click done 
</font>
</pre>
<%
 }
 else
 {
	 response.sendRedirect("logout.jsp");
 }
	 %>
</body>
</html>