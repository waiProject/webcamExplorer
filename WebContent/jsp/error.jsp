	<%@include file="Top.jsp" %>
<html>
<head>
	<%@include file="Head.jsp" %>
</head>
<body>
	
	<table class="error">
		<tbody>
		<tr>
			<th>Error !</th>
		</tr>
		<tr>
			<td><c:out value="Fehler: ${error}"/></td>
		</tr>
		<tr>
			<td><a href="logout">Zurück zur Login Seite</a></td>
		</tr>
		</tbody>
	</table>
</body>
</html>