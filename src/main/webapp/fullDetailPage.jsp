<%@page import="com.bean.LFBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>whole details</title>
</head>
<body>
<%LFBean bean = (LFBean)request.getAttribute("fullDetail"); %>
<h2>Full Detail</h2>
<table>
<tr><td>Id </td><td>: </td><td><%=bean.getId() %></td></tr>
<tr><td>Name </td> <td> : </td> <td> <%=bean.getName() %>   </td></tr>
<tr><td>Property </td><td>:</td> <td><%=bean.getProp() %></td></tr>
<tr><td>Property Identity </td><td>:</td> <td><%=bean.getIdentity() %></td></tr>
<tr><td>Place </td> <td>: </td><td><%=bean.getPlace() %></td></tr>
<tr><td>Profession </td> <td>:</td>  <td><%=bean.getField() %></td></tr>
<tr><td>Email I'd </td> <td>:</td>  <td><%=bean.getEmail() %> 	</td></tr>
<tr><td>Contact Number </td> <td>: </td>  <td><%=bean.getContact() %> </td> </tr>
</table>
<a href="home.jsp"><button>Home Page</button></a>
</body>
</html>