<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form name="register" method="post">
		<div>
			<label for = "username">Username:</label>
			<input type = "text" name = "username" id = "username"/>
		</div>
		<div>
			<label for = "password">Password:</label>
			<input type = "password" name = "password" id = "password"/>
		</div>
		<div>
			<label for = "repassword">Repeat password:</label>
			<input type = "password" name = "repassword" id = "repassword"/>
		</div>
		<input type = "submit" name = "submit" value = "Register"/>
	</form>
	<a href="login">Login</a>
</body>
</html>