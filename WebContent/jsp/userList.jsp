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
	  			<td>User Id</td>	
	  			<td>Benutzer Name</td>
				<td>Rolle</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>			
			<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.id}"/></td>					
					<td><c:out value="${user.name}"/></td>
					<td><c:out value="${user.rolle}"/></td>
					<td><a href="editUser?action=edit&id=${user.id}">Ändern</a></td>
					<td><a href="editUser?action=delete&id=${user.id}">Löschen</a></td>
				</tr>
			</c:forEach>
			<tr>
				<c:choose>
   					<c:when test="${sessionScope.rolle.equals('adm')}">
   						<td colspan="5"><a href="editUser?action=add">+ Neuen Benutzer hinzufügen</a></td>
   					</c:when>
				</c:choose>
			</tr>	
  		</tbody>
  	</table>
  </body>
</html>
