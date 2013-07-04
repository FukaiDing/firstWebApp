<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Leave Management</title>
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

		function doModify(id){
			var changeFlag = confirm("Sure Modify?");
			if (changeFlag) {
				window.location = "${pageContext.request.contextPath}/sureModify?id="+id;
			}
		}
	</script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h1>Hello ${user.username}!</h1>
		<h2>Welcome to leave management module!</h2>
		<form method="post" action="leaveManagement" onsubmit="return doSubmit();">
			username:<input type="text" name="username" value="${leavebean.name}"/>
			from:<input type="text" name="startDate" value="${leavebean.startDate}" id="StartTime" onBlur="doCheck('StartTime')"/>
			to:<input type="text" name="endDate" value="${leavebean.endDate}" id="EndTime" onBlur="doCheck('EndTime');"/>
			status:<select name="note">
				<option value=""></option>
        		<option value="agree">agree</option>
        		<option value="disagree">disagree</option>
        		<option value="no-reply">no-reply</option>
  			</select> 
  			<input type="submit" value="select"/>  
		</form>
		<div id="checkMessage"></div>
		<table class="table">
			<tr>
				<td>No.</td>
				<td>username</td>
				<td>startDate</td>
				<td>endDate</td>
				<td>reason</td>
				<td>note</td>
			</tr>
			<c:forEach var="leavebean" items="${leavebeans}">
				<tr>
					<td>${leavebean.id}</td>
					<td>${leavebean.name}</td>
					<td>${leavebean.startDate}</td>
					<td>${leavebean.endDate}</td>
					<td>${leavebean.reason}</td>
					<td>${leavebean.note}<input type="button" value="Modify" onclick="doModify('${leavebean.id}');"/></td>
				</tr>
			</c:forEach>
		</table>
		<font color="red">${modifymessage}<font>
	</center>
</body>
</html>
