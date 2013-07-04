<html>
<head>
	<title>Ask For Leave</title>

	<script type="text/javascript">

		function leaveDoSubmit(){

			if(doCheck("StartTime") && doCheck("EndTime") && doCheckReason()){
				return true;
			}
			return false;
		}

		function doCheck(id){

			var value = document.getElementById(id).value;
			var reg = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
			if(reg.exec(value) == null){
				document.getElementById("checkMessage").innerHTML = "<font color='red'>" + id + " format is wrong, Example 2013-06-06 11:11:11</font>";
				return false;
			}
			document.getElementById("checkMessage").innerHTML = "";
			return true;

		}

		function doCheckReason(){
			var value = document.getElementById("reason").value;
			if(value != null && value.trim() != ""){
				document.getElementById("checkMessage").innerHTML = "";
				return true;
			}
			document.getElementById("checkMessage").innerHTML = "<font color='red'>Leave reason can not be empty</font>";
			return false;
		}

	</script>

	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h1>Ask For Leave</h1>
		<form method="get" action="leave_true" onsubmit="return leaveDoSubmit();">
			<table class="table">
				<tr>
					<td colspan="1">Name</td>
					<td colspan="4" ><input readonly="true" value="${user.username}" name="name"/></td>
				</tr>
				<tr>
					<td>Time</td>
					<td>From</td>
					<td><input name="startDate" id="StartTime" onBlur="doCheck('StartTime');" /></td>
					<td>to</td>
					<td><input name="endDate" id="EndTime" onBlur="doCheck('EndTime');" /></td>
				</tr>
				<tr>
					<td colspan="1">Reason</td>
					<td colspan="4" align="center"><textarea row="4" rows="3" cols="80" name="reason" id="reason" onBlur="doCheckReason();" style="width: 468px; height: 95px;" ></textarea></td>
				</tr>
			</table>
			<font color="red">${leaveMessage}<font>
				<div id="checkMessage"></div>
			<input type="submit" value="Ask For Leave" />
		</form>
	</center>
</body>
</html>