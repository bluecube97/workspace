<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<link rel="shortcut icon" href="nahida.ico">
<meta charset="UTF-8">
<script type="text/javascript" src="${root}/js/signup.js" defer></script>
<title>SignUp</title>
</head>
<body>

	<form target="/signup" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id" placeholder="ID Input" onblur="idChk()"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="name"
					placeholder="Name Input" onblur="nameChk()"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" id="gender" name="gender" value="M" checked />남성
					<input type="radio" id="gender" name="gender" value="F" />여성</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="pw"
					placeholder="PASSWORD" onblur="pwChk()"></td>
			</tr>
			<tr>
				<th>비번확인</th>
				<td><input type="password" id="pwchk" name="pwchk"
					placeholder="PASSWORD" onblur="rePwChk()"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" id="email" name="email"
					placeholder="Email"></td>
			</tr>
			
		</table>
		<input type="submit" onclick="valChk()" value="가입">
		<div id="message"></div>
	</form>

</body>
</html>