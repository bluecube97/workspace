<%@page import="com.user.vo.userVO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>USERLIST</title>
</head>
<body>
	<h2>${cnt}건입니다.</h2>
	<c:set var="page" value="${empty param.page?1:param.page}"></c:set>
	<c:set var="startNum" value="${page - (page - 1) % 5}"></c:set>
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(cnt / 10), '.')}"></c:set>

	<table>
		<tr>
			<td>${page}</td>
			<td>/${lastNum}</td>
		</tr>
	</table>

	<!-- 페이징 처리 -->
	<!-- 이전 페이징 -->

	<c:if test="${startNum > 1}">
		<a href="?page=${startNum - 1}&so=${param.so}&sk=${param.sk}">Prev</a>
	</c:if>
	<c:if test="${startNum <= 1 }">
		<a href="#" onclick="alert('첫 페이지 입니다.')">Prev</a>
	</c:if>

	<ul>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${param.page == (startNum + i)}">
				<c:set var="style" value="font-weight:bold;color:red" />
			</c:if>
			<c:if test="${param.page != (startNum + i)}">
				<c:set var="style" value="" />
			</c:if>
			<c:if test="${(startNum + i) <= lastNum}">
				<li><a style="${style}"
					href="?page=${startNum + i}&so=${param.so}&sk=${param.sk}">${startNum + i}</a></li>
			</c:if>
		</c:forEach>
	</ul>

	<!-- 다음 페이징 -->
	<c:if test="${startNum + 5 <= lastNum}">
		<a href="?page=${startNum + 5}&so=${param.so}&sk=${param.sk}">Next</a>
	</c:if>
	<c:if test="${startNum + 5 > lastNum}">
		<a href="#" onclick="alert('마지막 페이지 입니다.')">Next</a>
	</c:if>

	<form action="" id="serchForm" method="get">
		<table border="1">
			<tr>
				<td><select name="so">
						<option ${(param.so == "userno")?"selected":""} value="userno">사번</option>
						<option ${(param.so == "usernm")?"selected":""} value="usernm">이름</option>
				</select>
				<td><input type="text" id="sk" name="sk" /></td>
				<td><input type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>

	<table border="1">
		<tr>
			<th>사용자 번호</th>
			<th>사용자 이름</th>
			<th>사용자 직권</th>
		</tr>
		<c:forEach var="uv" items="${userList}">
			<tr>
				<td>${uv.userNo}</td>
				<td>${uv.userNm}</td>
				<td>${uv.userRole}</td>
			</tr>
		</c:forEach>
	</table>

	<button type="button" onclick="location.href='/board'">목록으로</button>

</body>
</html>

















