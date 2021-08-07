<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter</title>
<style type="text/css">
	.d1
	{
		width: 470px; height: 500px; border: 5px; border-radius: 5px; border-color: red; border-style: solid; margin-left: 10px;
	}
	.f1
	{
		font-size: 45px; color:blue; font-weight: bold; 
	}
	font
	{
		font-size: 25px; color:yellow; font-weight: bold; 
	}
	.t1
	{
		margin: 5px; padding-left: 10px;
	}
	input
	{
		letter-spacing: 1px; size: auto;
	}
</style>
</head>
<body bgcolor="black">
<% 
System.out.println("home page........."); 
String user = (String)session.getAttribute("user");
System.out.println("Login User : " + user);
if( user != null) 
{
%> 
<c:set var="time" value="<%=new Date() %>"></c:set>
<fmt:formatDate value="${time }" type="both" dateStyle="long" timeStyle="short" var="date" />
<h4 align="center"><a href="home.jsp"><button>Back to Home Page</button></a></h4>
<table>
<tr>
	<td>
		<div class="d1">
			<font class="f1"> Lost </font> <hr><hr>
			<form action="LostInsertController" method="post">
			<table class="t1">
				<tr> 			
					<td>
						<font> <input type="radio" name="txtUserProfession" value="student">student
						 <input type="radio" name="txtUserProfession" value="faculty">faculty
						</font>
					 </td>
					<td>	<font>
						 <input type="radio" name="txtUserProfession" value="worker">worker 
						 <input type="radio" name="txtUserProfession" value="security">security
					</font></td>
				</tr> 
				<tr> </tr>
				<tr> </tr>
				<tr> </tr>
				<tr> </tr>
				<tr> 	
					<td><font> Name          </td>
					<td><font> :</font>  <input type="text" name="txtUserName"></td>
				</tr> 
				<tr> 	
					<td><font> Department   </font> </td>
					<td><font> :</font>  <input type="text" list="1" name="txtUserDepartment"> 
									     <datalist id="1">
									     <option value="computer">
									     <option value="info. & tech.">
					 				     <option value="mechanical">
									     <option value="civil">
									     <option value="mathemetics">
									     <option value="Worker">
									     <option value="Admin">
									     <option value="Security">
									     </datalist> </td>
				</tr> 
				<tr> 
					<td>	<font> Property name </font></td>
					<td><font> 	:</font>  <input type="text" name="txtPropertyName"></td>
				</tr> 
				<tr> 	
					<td><font> place       </font>  </td>
					<td><font> :</font>  <input type="text" name="txtPlace"></td>
				</tr> 
				<tr> 	
					<td><font> property sign </font></td>
					<td><font> :</font>  <input type="text" name="txtPropertySign"></td>
				</tr> 
					
				<tr> 	
					<td><font> contact Number   </font>   </td>
					<td><font> :</font>  <input type="text" name="txtUserContact"></td>
				</tr> 
				<tr> 	
					<td><font> email     </font>   </td>
					<td><font> :</font>  <input type="email" name="txtUserEmail"></td>
				</tr> 
				<tr> </tr>
				<tr hidden="">
					<td>time : </td>
					<td> <input type="text" name="date" value="${date }"></td>
				</tr>
				<tr> </tr>
				<tr> </tr>
				<tr> <td> </td>	 
					<td><input type="submit" value="SUBMIT"> </td>
				</tr>
			</table>
			</form>
		</div>
	</td>
	<td>
		<div class="d1">
			<font class="f1"> Found </font> <hr><hr>
			<form action="FoundInsertController" method="post">
			<table class="t1">
				<tr> 			
					<td><font> <input type="radio" name="z">student
						 <input type="radio" name="z">faculty </font></td>
					<td><font>	 <input type="radio" name="z">worker 
						 <input type="radio" name="z">security
					</font></td>
				</tr> 
				
				<tr> </tr>
				<tr> </tr>
				<tr> </tr>
				<tr> </tr>
				<tr> 	
					<td><font> Name       </font>   </td>
					<td><font> :</font>  <input type="text" name="txtUserName"></td>
				</tr> 
				<tr> 	
					<td><font> Department  </font>  </td>
					<td><font> :</font>  <input type="text" list="1" name="txtUserDepartment"> 
									     <datalist id="1">
									     <option value="computer">
									     <option value="info. & tech.">
					 				     <option value="mechanical">
									     <option value="civil">
									     <option value="mathemetics">
									     </datalist> </td>
				</tr> 
				<tr> 
					<td>	<font> Property name </font></td>
					<td><font> 	:</font>  <input type="text" name="txtPropertyName"></td>
				</tr> 
				<tr> 	
					<td><font> place     </font>    </td>
					<td><font> :</font>  <input type="text" name="txtPlace"></td>
				</tr> 
				<tr> 	
					<td><font> property sign </font></font> </td>
					<td><font> :</font>  <input type="text" name="txtPropertySign"> </td>
				</tr> 
					
				<tr> 	
					<td><font> contact     </font>  </td>
					
					<td><font> :</font>  <input type="text" name="txtUserContact"></td>
				</tr> 
				<tr> 	
					<td><font> email    </font>    </td>
					<td><font> :</font>  <input type="email" name="txtUserEmail"></td>
				</tr> 
				<tr> 	
					<td><font> submited   </font>    </font></td>
					<td><font>:  <input type="radio" value="yes" name="submit">yes<input type="radio" value="no" name="submit">no </font></td>
				</tr> 
				<tr> 	
					<td><font> Collect From    </font>    </td>
					<td><font> :</font>  <input type="text" name="collectFrom" value="where to collect"></td>
				</tr> 
				<tr hidden="hidden">
					<td>time : </td>
					<td> <input type="text" name="date" value="${date }"></td>
				</tr>
				<tr> </tr>
				<tr> </tr>
				<tr> </tr>
				<tr> 	 <td> </td>
					<td><input type="submit" value="SUBMIT"> </td>
				</tr>
			</table>
			</form>
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