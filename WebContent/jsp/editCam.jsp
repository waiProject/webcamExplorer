<%@ page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>webcamExplorer - Edit Cam</title>
  </head>  
  <body>
  <table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<td><a href="userList">userList</a></td>
  			<td><a href="login?action=logout">logout</a></td>  			
  		</tr>
  	</table>
	<form name="edit" action="editCam" method="post">		
		<table border="1">
			<tbody>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="${cam.name}"></td>		
				</tr>
				<tr>
					<td>Ort:</td>
					<td><input type="text" name="ort" value="${cam.ort}"></td>		
				</tr>
				<tr>		
					<td>Url:</td>	
					<td><input type="text" name="url" value="${cam.url}"></td>
				</tr>
				<tr>
					<td>Rolle:</td>
					<td><input type="text" name="rolle" value="${cam.rolle}"></td>		
				</tr>				
				<tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save"></td>
				</tr>				
			</tbody>
		</table>
		<input type="hidden" name="id" value="${cam.id}">
	</form>
  </body>
</html>
