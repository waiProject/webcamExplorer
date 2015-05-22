<%@ page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>     
    <title>webcamExplorer - Add Cam</title>
  </head>
  <body>
  <table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<td><a href="userList">userList</a></td>
  			<td><a href="logout">logout</a></td>  			
  		</tr>
  	</table>
	<form name="edit" action="editCam" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>Cam Name:</td>
					<td><input type="text" name="name" value=""></td>		
					</tr><tr>
					<td>Ort:</td>
					<td><input type="text" name="ort" value=""></td>		
					</tr><tr>		
					<td>Url:</td>	
					<td><input type="text" name="url" value=""></td>
					</tr><tr>
					<td>Rolle (usr, adm):</td>
					<td><input type="text" name="rolle" value=""></td>		
					</tr><tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save"></td>
				</tr>
			</tbody>
		</table>
	</form>
  </body>
</html>
