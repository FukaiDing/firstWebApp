<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body bgcolor="#A25BD6">
	<table class="table">
		<tr>
			<td>Description</td>
		</tr>
		<c:forEach var="roleRight" items="${roleRights}">
			<tr>
				<td><a href="${roleRight.url}?falgCheck=${check.flag}&name=${user.username}" target="center">${roleRight.rights}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
