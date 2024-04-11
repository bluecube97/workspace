<%@page import="java.sql.*"%>

<%@ page import="java.io.IOException"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body>
	<form target="/login" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" id="id" name="id" placeholder="ID"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="password" id="pass" name="pass" placeholder="PASSWORD"></td>
			</tr>
			<tr>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
</body>
</html>