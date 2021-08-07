<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP VERIFICATION</title>
<style type="text/css">
	div{
		width: 420px; height: 120px; border: 10px; border-style: double;
	}
</style>
</head>
<body>
<div>
<form action="ValidateOtpController">

<table>
	<tr>
		<td>enter email address : </td>
		<td><input type="email" name="mailI'd"> </td>
	</tr>
	<br>
	<tr> 
		<td>Enter Otp : </td>
		<td><input type="number" name="otp"> </td>
		<td> <a href="ResetPasswordGetOtpController">Resend otp</a> </td>
	</tr>
	<tr>
		<td> </td>
		<td><input type="submit" value="SUBMIT"> </td>
	</tr>
	<tr>	
		<td> </td>
		<td> 		${newotp } </td>
	</tr>
</table>
</form>
</div>
</body>
</html>