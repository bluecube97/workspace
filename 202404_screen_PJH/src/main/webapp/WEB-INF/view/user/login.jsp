<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- login -->
	<div id="login">
		<form action="login" method="post">
			<label for="id">ID:</label> <input type="text" id="id" name="id"
				value="<c:out value='${id }'/>"> <label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
			<input type="submit" value="Login">

			<div class="login-param remember">
				<input type="checkbox" id="remember" name="remember" value="Y"
					<c:if test='${id != null && id != ""}'>checked</c:if>> <label
					for="remember">Remember ID</label>
			</div>

		</form>
	</div>



	<!-- sing up -->
	<div id="login-ment">alert: ${ment }</div>
</body>
</html>