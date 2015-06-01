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
					<td>Benutzer Name:</td>
					<td><input type="text" name="name" value=""></td>		
					</tr><tr>
					<td>Passwort:</td>
					<td><input type="password" name="password" value=""></td>		
					</tr><tr>
					<td>Rolle:</td>
					<td>
					<select name="rolle">
					    <option>usr</option>
					    <option>adm</option>
					</select>
					</td>
					</tr><tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save"></td>
				</tr>
			</tbody>
		</table>
	</form>
  </body>
</html>
