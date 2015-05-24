	<%@include file="Top.jsp" %>
<html>
  <head>    
    <%@include file="Head.jsp" %>
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
