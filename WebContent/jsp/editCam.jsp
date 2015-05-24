	<%@include file="Top.jsp" %>
<html>
  <head>    
    <%@include file="Head.jsp" %>
  </head>  
  <body>
  	<%@include file="Navigation.jsp" %>
	
	<form name="edit" action="editCam" method="post">		
		<table border="1" class="center">
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
