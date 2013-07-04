<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>check_message</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h2>View Check Message about ${username}</h2>
		<table class="table">
			<tr>
				<td>No.</td>
				<td>username</td>
				<td>check_in</td>
				<td>check_out</td>
				<td>totle_time</td>
				<td>data</td>
			</tr>
			<c:forEach var="checkbean" items="${checkbeans}">
				<tr>
					<td>${checkbean.id}</td>
					<td>${checkbean.name}</td>
					<td>${checkbean.check_first}</td>
					<td>${checkbean.check_second}</td>
					<td>${checkbean.time}</td>
					<td>${checkbean.data}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>