<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Attendance management</title>
	<script type="text/javascript">

		function doSubmit(){
			if(doCheck("StartTime") && doCheck("EndTime")){
				return true;
			}
			return false;
		}

		function doCheck(id){

			var value = document.getElementById(id).value;
			if(value != null && value != ""){
				var reg = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
				if(reg.exec(value) == null){
					document.getElementById("checkMessage").innerHTML = "<font color='red'>" + id + " format is wrong, Example 2013-06-06 11:11:11</font>";
					return false;
				}
			}
			document.getElementById("checkMessage").innerHTML = "";
			return true;

		}
	</script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h1>Hello ${user.username}!</h1>
		<h2>Welcome to attendance management module!</h2>
		<form method="post" action="attendancemanagement" onsubmit="return doSubmit();">
			username:<input type="text" name="username" value="${checkbean.name}" />
			from:<input type="text" name="check_first" value="${checkbean.check_first}" id="StartTime" onBlur="doCheck('StartTime')"/>
			to:<input type="text" name="check_second" value="${checkbean.check_second}" id="EndTime" onBlur="doCheck('EndTime')"/>
  			<input type="submit" value="select"/>  
		</form>
		<div id="checkMessage"></div>
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
