<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<frameset name="main" rows="140,*" frameborder="NO" border="0" framespacing="1px"> 
	<frame name="top" src="top" frameBorder="no" noResize scrolling="no">
	<frameset cols="20%,*" frameborder="NO" border="0" framespacing="1px">
		<frame name="left" src="left" frameBorder="no" noResize scrolling="true">
		<frame name="center" src="center" frameBorder="no" noResize scrolling="true">
	</frameset>
</frameset>

<body>
<p>此网页使用了框架，但您的浏览器不支持框架。</p>
</body>
</html>