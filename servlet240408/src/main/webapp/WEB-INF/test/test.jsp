<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<script type="text/javascript" src="${root}/js/test.js"></script>
</head>
<body>
${root}
	<form action="/" method="post">
		<input type="text" id="input1"> <input type="text" id="input2">
		<button type="button" onclick="submitForm()">제출</button>
	</form>
</body>
</html>