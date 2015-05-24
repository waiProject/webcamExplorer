	<%@include file="Top.jsp" %>
<html>
  <head>
  	<%@include file="Head.jsp" %>    
  </head>
  <body>
  	<%@include file="Navigation.jsp" %>
  	  	
  	<table border="1" class="center">
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
					<c:if test="${sessionScope.rolle.equals('adm')}">
						<td><a href="editCam?action=edit&id=${cam.id}">Ändern</a></td>
						<td><a href="editCam?action=delete&id=${cam.id}">Löschen</a></td>
					</c:if>
					<td><a href="editCam?action=show&id=${cam.id}">Anzeigen</a></td>
				</tr>
			</c:forEach>
			<tr>
				<c:choose>
   					<c:when test="${sessionScope.rolle.equals('adm')}">
   						<td colspan="8"><a href="editCam?action=add">+ Neue Kamera hinzufügen</a></td>
   					</c:when>
				</c:choose>
			</tr>	
  		</tbody>
  	</table>  	
  </body>
</html>
