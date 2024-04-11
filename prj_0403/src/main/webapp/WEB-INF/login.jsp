<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<link rel="shortcut icon" href="nahida.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="${root}/js/login.js" defer></script>
<title>Login</title>
</head>
<body>
	<form target="/login" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id" placeholder="ID Input"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="pw"
					placeholder="PASSWORD"></td>
			</tr>
			<tr>
				<td><button type="button" onclick="loginSubmit()">로그인</button></td>
			</tr>
		</table>
		<div id="userid"></div>
	</form>
</body>
</html>