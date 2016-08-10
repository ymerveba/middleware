<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="login.css"> -->
<title>Login User and Service Provider</title>
<script language="Javascript">
	function IsEmpty() {
		if (document.forms.frm.userid.value == "") {
			alert("Username is empty");
			return false;
		}
		if (document.forms.frm.pass.value == "") {
			alert("Password is empty");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <style type="text/css">
 .error {
	color: #ff0000;
	font-style: italic;
}
.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://ginva.com/wp-content/uploads/2012/07/city-skyline-wallpapers-008.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	 z-index: 0; 
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
	z-index: 1;
	opacity: 0.7;
}

.login{
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 1;
}
.login input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login input[type=password]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}
::-webkit-input-placeholder{
   color: rgba(0,0,0,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}

.login input[type=submit]:hover{
	opacity: 0.8;
}

.login input[type=submit]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=submit]:focus{
	outline: none;
}
.header{
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span{
	color: #5379fa !important;
}
h2{
position: absolute;
z-index: 2;
}
</style> 
</head>
<body>

 	<h2>Service Providers and Users Login</h2>
	<div class = body></div>
	<div class = grad></div>
   <div class="header"><h2>Customers Login</h2></div>

	<div class="login">
	<form:form name="frm" method="get" action="loginValidation"
		commandName="loginForm">

		<table align="center">
			
			<tr>
				<td><div class="input-group input-group-lg"><font face="Lucida Handwriting">User ID</font></div></td>
				<td><form:input path="email_id" placeholder="Username"/></td>
				<td><form:errors path="email_id" cssClass="error" /></td>
				
			</tr>
			<tr>
				<td><div class="input-group input-group-lg"><font face="Lucida Handwriting">Password</font></div></td>
				<td><form:password path="password" placeholder="Password"/></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="submit"
					value="log in"></td>
			</tr>
		</table>

	</form:form>
	</div>
	
	
</body>
</html>