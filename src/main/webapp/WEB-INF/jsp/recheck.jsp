<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<c:choose>
		<c:when test="${checkFlag == 'success'}">
			<img src="${pageContext.request.contextPath}/bootstrap/img/work.jpeg" class="img-rounded">
		</c:when>
			
		<c:otherwise>
			Check Failed!
		</c:otherwise>
	</c:choose>
</body>
</html>
