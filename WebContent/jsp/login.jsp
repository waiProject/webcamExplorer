<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>webcamExplorer Login</title>
</head>
<body>

<form name="login" action="login" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>Benutzername:</td>
					<td><input type="text" name="benutzer" value=""></td>		
					</tr><tr>
					<td>Passwort:</td>
					<td><input type="password" name="password" value=""></td>		
					</tr><tr>		
					<td colspan="2"><input type="submit" name="btnLogin" value="Login"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>