<%@ page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>webcamExplorer - edit</title>
  </head>  
  <body>
  <table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<td><a href="userList">userList</a></td>
  			<td><a href="login?action=logout">logout</a></td>   			
  		</tr>
  	</table>
	<form name="edit" action="editUser" method="post">		
		<table border="1">
			<tbody>
				<tr>
					<td>Benutzer:</td>
					<td><input type="text" name="name" value="${user.name}"></td>		
				</tr>
				<tr>
					<td>Passwort:</td>
					<td><input type="password" name="password" value="${user.passwort}"></td>		
				</tr>
				<tr>
					<td>Rolle:</td>
					<td><input type="text" name="rolle" value="${user.rolle}"></td>		
				</tr>		
				<tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save"></td>
				</tr>				
			</tbody>
		</table>
		<input type="hidden" name="id" value="${user.id}">
	</form>
  </body>
</html>
