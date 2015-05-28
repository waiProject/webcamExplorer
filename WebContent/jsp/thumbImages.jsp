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
					<c:forEach var="i" begin="0" end="4" step="1">
						<c:if test="${status.index+i lt fn:length(images)}">
							<td>
								<figure>
			                       <a href="showImage?action=showPicture&localpath=${images[status.index+i].localPath}">
			                       		<img src="thumbnail?path=${images[status.index+i].localPathThumb}" alt="${images[status.index+i].localPathThumb}">
			                       </a>
			                    </figure>
							</td>
						</c:if>
					</c:forEach>
	 				<tr>
						<c:forEach var="i" begin="0" end="4" step="1">
							<c:if test="${status.index+i lt fn:length(images)}">
								<td>									
									<a href="showImage?action=showPicture&localpath=${images[status.index+i].localPath}">
										<c:out value="${images[status.index+i].uhrzeit}"></c:out>
									</a>
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