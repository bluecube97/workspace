<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<th>PW</th>
				<td><input type="password" id="pw" name="pw"
					placeholder="PASSWORD"></td>
			</tr>
			<tr>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
		<input type="hidden" name="ment1" value="안녕하세요?"/>
		<input type="hidden" name="ment2" value="안녕하세요??"/>
	</form>
</body>
</html>