<%@ page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EarthCam</title>
</head>
<body>
<h1>Es ist ein Fehler aufgetreten!</h1>
<br>
<td><c:out value="Fehler: ${error}"/></td>
<br>
<a href="logout">Zurück zur Login Seite</a>
</body>
</html>