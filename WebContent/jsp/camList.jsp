<%@ page language="java" contentType="text/html" %>
<%@ page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>webcamExplorer - Available Cams</title>     
  </head>
  <body>
  	<table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<td><a href="userList">userList</a></td>
  			<td><a href="login?action=logout">logout</a></td>  			
  		</tr>
  	</table>
  	<table border="1">
  		<tbody>
	  		<tr>
	  			<td>Id</td>	
	  			<td>Kamera Name</td>
	  			<td>Ort</td>				
				<td>URL</td>
				<td>Rolle</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>			
			<c:forEach var="cam" items="${cams}">
				<tr>
					<td><c:out value="${cam.id}"/></td>					
					<td><c:out value="${cam.name}"/></td>
					<td><c:out value="${cam.ort}"/></td>
					<td><c:out value="${cam.url}"/></td>
					<td><c:out value="${cam.rolle}"/></td>
					<td><a href="editCam?action=edit&id=${cam.id}">�ndern</a></td>
					<td><a href="editCam?action=delete&id=${cam.id}">L�schen</a></td>
					<td><a href="editCam?action=show&id=${cam.id}">Anzeigen</a></td>
				</tr>
			</c:forEach>	
  		</tbody>
  	</table>
  	<br>
  	<a href="editCam?action=add">+ Neue Kamera hinzuf�gen</a>
  </body>
</html>
