<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h2>The name: <font color="red"><c:out value="${username}" /></font> is already registered!</h2>
		You can click <a href="index">here</a> to login!
	</center>
</body>
</html>
