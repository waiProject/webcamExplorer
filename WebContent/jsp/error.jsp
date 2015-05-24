	<%@include file="Top.jsp" %>
<html>
<head>
	<%@include file="Head.jsp" %>
</head>
<body>
	<%@include file="Navigation.jsp" %>
	
	<h1>Es ist ein Fehler aufgetreten!</h1>
	<br>
	<td><c:out value="Fehler: ${error}"/></td>
	<br>
	<a href="logout">Zurück zur Login Seite</a>
</body>
</html>