<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- login -->
	<div id="login">
		<form action="login" method="post">
			<label for="id">ID:</label> 
			<input type="text" id="id" name="id" required> 
			<label for="password">Password:</label> 
			<input type="password" id="password" name="password" required> 
			<input type="submit" value="Login">
		</form>
	</div>
	<!-- sing up -->
	<div id="signup">
	</div>
</body>
</html>