<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${root}/js/jstest.js" defer></script>
<title>JSTEST</title>
</head>
<body>
	<div id=test>
		<input type="text" id="js_val1" name="java_val1" />
		<button type="button" onclick="formSubmit()">입력</button>
		<div id="result"></div>
	</div>


</body>
</html>