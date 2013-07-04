<html>
<head>
	<title>registration</title>

	<script type="text/javascript">
		function doSubmit(){
			if(doPassword() && doPasswordAgain()){
				return true;
			}
			return false;
		}
		function doPassword(){
			var reg = /^[a-zA-Z0-9]{6,20}$/;
			var password = document.getElementById('password').value;
			if(reg.exec(password) == null){
				document.getElementById("divpassword").innerHTML="<font color='red'>Password only by numbers and letters in length 6-12</font>";
				return false;
			}
			document.getElementById("divpassword").innerHTML="";
			return true;
		}
		function doPasswordAgain(){
			var password_again = document.getElementById('password_again').value;
			var password = document.getElementById('password').value;
			if(password_again == password){
				document.getElementById("divpasswordagain").innerHTML="";
				return true;
			}
			document.getElementById("divpasswordagain").innerHTML="<font color='red'>Two different passwords</font>";
			return false;
		}
	</script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<center>
		<form action="regSuccess" method="post" onsubmit="return doSubmit();">
			loginName:<input name="username" type="text" value="${username}" readonly="true"/>
			<p/>
			password:<input type="password" name="password" id="password" onBlur="doPassword()"/>
			<div id="divpassword"></div>
			<p/>
			password again:<input type="password" name="password_again" id="password_again" onBlur="doPasswordAgain()"/>
			<div id="divpasswordagain"></div>
			<p/>
			<input type="radio" name="role" value="Manager">Manager   
			<input type="radio" name="role" value="Employee" checked="true">Employee 
			<p/>
			<input type="submit" value="Reg"/>
		</form>
	</center>
</body>
</html>