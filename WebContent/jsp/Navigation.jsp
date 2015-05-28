<div id="navigation">
<table border="0" cellspacing="15">
	<tbody>
  		<tr>
  			<th><a href="camList">camList</a></th>
  			<c:if test="${sessionScope.rolle.equals('adm')}">
  				<th><a href="userList">userList</a></th>
  			</c:if>
  			<th><a href="logout">${benutzer} logout</a></th>  			
  		</tr>
  	</tbody>
</table>
</div>