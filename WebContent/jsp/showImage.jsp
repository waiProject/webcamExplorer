<%@ page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>EarthCam</title>
  </head>  
  <body>
	<form name="edit" action="edit" method="post">		
		<table border="1">
			<tbody>
				<tr>
					<figure>
                       <img src="z:\Desktop\w_mvc_3\w_mvc_3\w_mvc_3\bilder\MA-Wasserturm.jpg" alt="${cam.url}" width=240 height=260>
                    </figure>
                    
                    
					<figure>
                       <img src="${cam.url}" alt="${cam.url}" width=240 height=260>
                    </figure>	
				</tr>	
			
				<tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Zurück"></td>
				</tr>				
			</tbody>
		</table>
	</form>
  </body>
</html>
