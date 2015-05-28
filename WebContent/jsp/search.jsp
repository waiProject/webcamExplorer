	<%@include file="Top.jsp" %>
<html>
  <head>      
    <%@include file="Head.jsp" %>     
  </head>
  <body>
  	<%@include file="Navigation.jsp" %>
  	
  	<form name="showImage" action="showImage" method="post">
  	<table border="1" class="center">
  		<tbody>
	  		<tr>	  			
	  			<td>Datum</td>				
				<td>&nbsp;</td>				
			</tr>		
				<tr>				
					<td>
					<select name="datumauswahl">					    
					    <c:forEach var="date" items="${dates}">
						    <option>${date}</option>
						</c:forEach>
					 </select>
					</td>
					<td>
					<input type="submit" name="btnSave" value="Datum Anzeigen">
					<!-- <a href="showImage?action=thumbnailView&datum=${date}">Datum Anzeigen</a> -->
					</td>
				</tr>
  		</tbody>
  	</table>
  	</form> 
  </body>
</html>
