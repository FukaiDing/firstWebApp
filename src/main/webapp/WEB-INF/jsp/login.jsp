<html>
<head>
	<title>login</title>
	<script type="text/javascript">
		
		function doSubmit(){

			if(doCheck("username") && doCheck("password")){
				return true;
			}
			return false;
		}

		function doCheck(id){
			
			var value = document.getElementById(id).value;
			if(value == null || value == ""){
				document.getElementById("div"+id).innerHTML = "<font color='red'>Please enter your " + id + "</font>";
				return false;
			}
			document.getElementById("div"+id).innerHTML = "";
			return true;

		}

	</script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
</head>
<body>
	<div class="container">
		<h1 class="form-signin-heading">Login</h1>
		<form action="login" method="post" onsubmit="return doSubmit();" class="form-signin">
			loginName:<input name="username" type="text" id="username" onBlur="doCheck('username');" class="input-block-level"/>
			<div id="divusername"></div>
			<p/>
			password:<input name="password" type="password" id="password" onBlur="doCheck('password');" class="input-block-level"/>
			<div id="divpassword"></div>
			<p/>
			<font color="red">${loginMessage}</font>
			<p/>
			<input class="btn btn-small btn-primary" type="submit" value="login"/>
		</form>
		<h2><a href="googlelogin">Google +</a></h2>
	</div>
	
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
