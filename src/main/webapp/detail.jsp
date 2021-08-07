<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.LFBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>DetailPage</title>
<style>
	.head1{ width:100%; height:60px; background-color:lightblue; }
	.head2{ width:100%; height:70%; background-color:blue;}
	.head3{ width:100%; height:0%; background-color:blue;}
	.f1{ font-size:45px; font-weight:bold; font-style:oblique;
	     text-spacing:1px; word-spacing:3px; background-color:lightblue;
	      text-shadow: gray;
	    }
	.f2{ font-size:26px; font-weight:bold; text-spacing:1px; word-spacing:1.5px; 
		background-color:lightblue;
		}
	.f3{ font-size:20px;text-spacing:1px;word-spacing:2px; }
	tr{  width=100% height=100% bgcolor=lightblue }
	
	
</style>
</head>
<body bgcolor=blue>

<% 
System.out.println("Detail page........."); 
String user = (String)session.getAttribute("user");
System.out.println("Login User : " + user);
if( user != null) 
{
%> 
<%List<LFBean> listOfProp = (ArrayList)request.getAttribute("LostProperties");%> 
<%List<LFBean> listOFFoundData = (ArrayList)request.getAttribute("FoundData"); %> 
<div class="head1">
<pre><font class="f1">     Lost And Found Property Details</font></pre>
</div> 

<font align="left" ><a href="home.jsp"><button style="margin-top: 25px;">Back to Home Page</button></a>  </font>
<font align="right">
<details>
<summary><button style="width: 80px; height: 20px; background-color: white;">User</button></summary>
User id :<%=session.getAttribute("user") %><br>
Login Time :<%=session.getAttribute("time") %>
</details>
</font>

<div class="head1">
   <table width=100% height=50% class="t1">
	<tr>
	<td>
	      <pre><font class="f2">        LOST PROPERTY STUFF  </font></pre>
	</td>
	<td>
	<pre><font class="f2">       FOUND PROPERTY STUFF  </font></pre>
	
	</td>
	</tr>
   </table>
</div>

<table width=100%>
<tr>
	<td width=50%>
		<div class="head2">
		 <table style="width:100%; height:100%; background-color:lightblue;">
		<tr> <td> <br> </td>	</tr>
				<% for(int i=0;i<listOfProp.size();i++)
				{
					LFBean bean = listOfProp.get(i);			
				%> 
				<tr>
				<td><b> Id : <%=bean.getId() %> </b> </td> 
				<td> <b>Property : <%=bean.getProp() %> </b></td> 
				<td> <a href="LostDeleteController?id=<%=bean.getId() %>"><b>delete</b></a></td> 
				</tr> 
				<tr>
				 <td><b>	Property Identity : <%=bean.getIdentity() %> </b> </td>
				 <td><b>    Place : <%=bean.getPlace() %> </b> </td>
				  </tr>
				<tr> 
				<td><a href="LostFullDetailController?lId=<%=bean.getId() %>">full details</a>
				     <hr>
				</td>
				</tr>
				<% } %>
				</table> 
		</div>
	</td>
	<td width=50%>
		<div class="head3">
		<table style="width:100%; height:100%; background-color:lightblue;">
			
				<%for(int j=0;j<listOFFoundData.size();j++)
				  {
					LFBean bean = listOFFoundData.get(j);
				%>
				 
				<tr>
					<td><b> Id : <%=bean.getId() %> </b> </td> 
					<td> <b>Property : <%=bean.getProp() %> </b></td> 
					<td> <a href="FoundDeleteController?id=<%=bean.getId() %>"><b>delete</b></a></td> 
				</tr> 
				<tr>
					 <td><b>	Property Identity : <%=bean.getIdentity() %> </b></td> 
					 <td><b>    Place : <%=bean.getPlace() %> </b> </td> 
				</tr>
				<tr> 
					<td>
						<a href="FoundFullDetailController?fId=<%=bean.getId() %>">Full Details</a>
						<hr>
					</td>
				</tr>
				<%} %>
		</table>
		</div>
	</td>
</tr>
</table> 
<%
 }
 else
 {
	 response.sendRedirect("logout.jsp");
 }
	 %>
</body>
</html>