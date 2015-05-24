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
