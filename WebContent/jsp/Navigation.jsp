<div id="navigation">
<table border="0">
  		<tr>
  			<td><a href="camList">camList</a></td>
  			<c:if test="${sessionScope.rolle.equals('adm')}">
  				<td><a href="userList">userList</a></td>
  			</c:if>
  			<td><a href="logout">logout</a></td>  			
  		</tr>
  	</table>
</div>