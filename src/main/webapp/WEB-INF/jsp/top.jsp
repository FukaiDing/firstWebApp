<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	Hello ${user.username}!<a href="safetySignOut" target="_top">Safety sign out</a>
	<center>
		<h1>Welcome to dodopipe!</h1>
	</center>
</body>
</html>
