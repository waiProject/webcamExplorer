<%@ page language="java" contentType="text/html" %>
<%@ page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>EarthCam</title>     
  </head>
  <body>
  	<table border="1">
  		<tbody>
	  		<tr>
	  			<td>Id</td>	
	  			<td>Kamera Name</td>				
				<td>URL</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>			
			<c:forEach var="cam" items="${cams}">
				<tr>
					<td><c:out value="${cam.id}"/></td>					
					<td><c:out value="${cam.Name}"/></td>
					<td><c:out value="${cam.Url}"/></td>
					<td><a href="edit?action=edit&id=${cam.id}">Ändern</a></td>
					<td><a href="edit?action=delete&id=${cam.id}">Löschen</a></td>
					<td><a href="edit?action=show&id=${cam.id}">Anzeigen</a></td>
				</tr>
			</c:forEach>	
  		</tbody>
  	</table>
  	<br>
  	<a href="edit?action=add">Neue Kamera hinzufügen</a>
  </body>
</html>
