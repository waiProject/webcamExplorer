<%@ page language="java" contentType="text/html" %>
<%@ page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>webcamExplorer - Available Cams</title>     
  </head>
  <body>
  	<table border="1">
  		<tbody>
	  		<tr>	
	  			
	  			
	  			<td>Datum</td>				
				<td>Uhrzeit</td>
				<td>&nbsp;</td>
				
			</tr>			
			<c:forEach var="cam" items="${cams}">
				<tr>
										
					
					<td><c:out value="${cam.Datum}"/></td>
					<td><c:out value="${cam.Uhrzeit}"/></td>
					<td><a href="editCam?action=show&id=${cam.id}">Anzeigen</a></td>
				</tr>
			</c:forEach>	
  		</tbody>
  	</table>
  
  </body>
</html>
