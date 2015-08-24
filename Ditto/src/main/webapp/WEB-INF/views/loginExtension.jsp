<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.loginField{
		width: auto;
		margin: 5px;
		
		background-color: #b9f6ca;
	}
	.logButton{
		color: window;
		background-color: #00e676;
		border-color #00e676;
		
		padding: 5px;
		box-shadow: 0 3px 6px 0 #fff, 0 -3px 6px 0 #fff;
	}
</style>
</head>
<body>

<fieldset class="loginField"><legend>Login</legend>
	<form action="/Ditto/loginEx" method="post">
	UserName : <input type="text" name="u_name" placeholder="User Name Here" /><br>
	<br>Password : <input type="password" name="u_pass" placeholder="Password Here" />
	<br><br><input class="logButton" type="submit" value="Login">
	</form>
</fieldset>

</body>
</html>