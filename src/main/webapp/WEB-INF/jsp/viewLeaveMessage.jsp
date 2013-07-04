<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>leave_message</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h2>View Leave Message about ${username}</h2>
		<table class="table">
			<tr>
				<td>No.</td>
				<td>username</td>
				<td>startDate</td>
				<td>endDate</td>
				<td>reason</td>
				<td>note</td>
				<td>remark</td>
			</tr>
			<c:forEach var="leavebean" items="${leavebeans}">
				<tr>
					<td>${leavebean.id}</td>
					<td>${leavebean.name}</td>
					<td>${leavebean.startDate}</td>
					<td>${leavebean.endDate}</td>
					<td>${leavebean.reason}</td>
					<td>${leavebean.note}</td>
					<td>${leavebean.remark}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>