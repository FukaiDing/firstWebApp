<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>modify_page</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<h5>Leave Basic Information</h5>
		<table class="table">
			<tr>
				<td colspan="1">Name</td>
				<td colspan="4" ><input readonly="true" value="${leavebean.name}"/></td>
			</tr>
			<tr>
				<td>Time</td>
				<td>From</td>
				<td><input readonly="true" value="${leavebean.startDate}"/></td>
				<td>to</td>
				<td><input readonly="true" value="${leavebean.endDate}"/></td>
			</tr>
			<tr>
				<td colspan="1">Reason</td>
				<td colspan="4"><textarea row="4" rows="3" cols="80" readonly="true" style="width: 468px; height: 95px;">${leavebean.reason}</textarea></td>
			</tr>
		</table>
		<h5>Operation module</h5>
		<form method="get" action="modifyMethod">
			status:<select name="note">
        		<option value="agree">agree</option>
        		<option value="disagree">disagree</option>
        		<option value="no-reply">no-reply</option>
  			</select>
  			<p/>
  			Annotation information:
  			<p/>
  			<textarea row="4" name="remark" id="remark" style="width: 468px; height: 95px;">${leavebean.remark}</textarea>
  			<p/>
  			<input type="hidden" name="id" value="${leavebean.id}" />
			<div id="checkMessage"></div>
			<input type="button" value="return" onclick="window.open('${pageContext.request.contextPath}/leaveManagement');"/>
			<input type="submit" value="Sure to modify" />
		</form>
	</center>
</body>
</html>