<%@ page language="java" contentType="text/html" %>
<%@ page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>webcamExplorer - Available Users</title>     
  </head>
  <body>
  <table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<td><a href="userList">userList</a></td>
  			<td><a href="logout">logout</a></td>   			
  		</tr>
  	</table>
  	<table border="1">
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
  		</tbody>
  	</table>
  	<br>
  	<a href="editUser?action=add">+ Neuen Benutzer hinzufügen</a>
  </body>
</html>
