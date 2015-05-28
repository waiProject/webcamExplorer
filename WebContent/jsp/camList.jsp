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
				<td>&nbsp;</td>
				<c:if test="${sessionScope.rolle.equals('adm')}">
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</c:if>
			</tr>			
			<c:forEach var="cam" items="${cams}">
				<c:if test="${sessionScope.rolle.equals(cam.rolle)
						|| (sessionScope.rolle.equals('adm') && cam.rolle.equals('usr'))}">
					<tr>
						<td><c:out value="${cam.id}"/></td>					
						<td><c:out value="${cam.name}"/></td>
						<td><c:out value="${cam.ort}"/></td>
						<td><c:out value="${cam.url}"/></td>
						<c:if test="${sessionScope.rolle.equals('adm')}">
							<td><a href="editCam?action=edit&id=${cam.id}">Ändern</a></td>
							<td><a href="editCam?action=delete&id=${cam.id}">Löschen</a></td>
						</c:if>
						<td><a href="search?cam_id=${cam.id}&cam_name=${cam.name}&cam_ort=${cam.ort}">Anzeigen</a></td>
					</tr>
				</c:if>
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

<!-- imageList?id=${cam.id}&cam_name=${cam.name}&cam_ort=${cam.ort} -->
