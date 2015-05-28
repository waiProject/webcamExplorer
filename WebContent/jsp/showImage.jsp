	<%@include file="Top.jsp" %>
<html>
  <head>
  	<script type="text/javascript">
  	<!--
  		
  	-->
  	</script>   
    <%@include file="Head.jsp" %>
  </head>  
  <body>
  	<%@include file="Navigation.jsp" %>
			
		<table border="1" class="images">
			<tbody>
				<tr>
				 <td>
					<figure>
                      <img src="thumbnail?path=${localpath}" alt="${localpath}">
                    </figure>
                    </td>
				</tr>			
				<tr>	
					<td><a href="javascript:history.go(-1);" >zurück</a></td>
				</tr>				
			</tbody>
		</table>
	
  </body>
</html>
