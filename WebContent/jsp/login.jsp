<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="Head.jsp" %>
	<script src="/webcamExplorer/scripts/emptyCheck.js" type="text/javascript"></script> 
</head>
<body>

<form name="login" action="login" method="post" onsubmit="return required();">
	<div id="content">
	<table class="center">
		<tbody>
			<tr>
			<td colspan=2>Entering webcamExplorer</td>
			</tr>
			<tr>			
			<td>Benutzername:</td>
			<td><input type="text" name="benutzer" value=""></td>		
			</tr><tr>
			<td>Passwort:</td>
			<td><input type="password" name="password" value="" size="10"></td>		
			</tr><tr>		
			<td colspan="2"><input type="submit" name="btnLogin" value="Login"></td>
			</tr>
		</tbody>
	</table>
	</div>
</form>
</body>
</html>