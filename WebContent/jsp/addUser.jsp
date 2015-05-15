<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>     
    <title>webcamExplorer - Add User</title>
  </head>
  <body>
	<form name="edit" action="editUser" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>Benutzer Name:</td>
					<td><input type="text" name="name" value=""></td>		
					</tr><tr>
					<td>Passwort:</td>
					<td><input type="password" name="password" value=""></td>		
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
