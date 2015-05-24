	<%@include file="Top.jsp" %>
<html>
  <head>    
    <%@include file="Head.jsp" %>
  </head>  
  <body>
 	<%@include file="Navigation.jsp" %>
	
	<form name="edit" action="editUser" method="post">		
		<table border="1" class="center">
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
