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
  				<th colspan="2"><c:out value="${sessionScope.cam_name} - ${sessionScope.cam_ort}"></c:out></th>
  			</tr>
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
				</td>
			</tr>
  		</tbody>
  	</table>
  	</form> 
  </body>
</html>
