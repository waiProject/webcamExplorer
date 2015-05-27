	<%@include file="Top.jsp" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<%@include file="Head.jsp" %>
</head>
<body>
	<%@include file="Navigation.jsp" %>	
	
	<table border="1" class="images">
  		<tbody>
	  		<tr>
	  			<th colspan="5"><c:out value="${cam_name} - ${cam_ort}"></c:out></th>
			</tr>
			<c:forEach var="img" items="${images}" varStatus="status" step="5">
				<tr>							
					<c:forEach var="i" begin="1" end="5" step="1">
						<c:if test="${status.index+1+i != fn:length(images)}">
							<td>
								<figure>
			                       <img src="thumbnail?path=${images[status.index+i].localPathThumb}" alt="${images[status.index+i].localPathThumb}" width=105 height=80>
			                    </figure>
							</td>
						</c:if>
					</c:forEach>
	 				<tr>
						<c:forEach var="i" begin="0" end="4" step="1">
							<c:if test="${status.index+1+i != fn:length(images)}">
								<td>
									<c:out value="${images[status.index+i].uhrzeit}"></c:out>
								</td>
							</c:if>
						</c:forEach>
					</tr>
				</tr>
			</c:forEach>		
  		</tbody>
  	</table>
	
</body>
</html>