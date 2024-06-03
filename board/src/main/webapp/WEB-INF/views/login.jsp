<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/resource/css/login.css">
<script type="text/javascript" src="/resource/js/login.js" defer></script>
<title>Login</title>
</head>
<body>
	<!--로그인 화면-->
	<div class="container">
		<h1>Login</h1>
		<form action="/login" method="post" id="loginForm">
			<div class="form-el">
				<label for="uid">User ID</label> <input type="text" id="uid"
					placeholder="place ID">
				<button type="button" class="btn btnP mt-2" onclick="idCheck()">idCheck</button>
			</div>
			<div class="form-el">
				<label for="upass">User PW</label> <input type="password" id="upass"
					placeholder="place PW">
			</div>
			<button type="button" class="btn btnS" onclick="pwCheck()">Login</button>
		</form>
	</div>
	<!--모달-->
	<div class="idCheck modal">
		<div class="modalContent">
			<div class="modalHeader">
				<span class="modalClose" onclick="closeModal()"></span>
				<h2>ID Check Result</h2>
			</div>
			<div class="modalBody">
				<button type="button" class="btn btnM mt-2" onclick="closeModal()">Close</button>
			</div>
		</div>
	</div>
</body>
</html>