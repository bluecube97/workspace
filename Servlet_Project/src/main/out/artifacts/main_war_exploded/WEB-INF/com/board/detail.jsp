<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글쓴이</th>
			<td>${detail.userNm}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detail.brdTitle }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${detail.brdDate }</td>
		</tr>
		<tr>
			<th colspan=2>내용</th>
		</tr>
		<tr>
			<td colspan=2>${detail.brdMemo }</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='/board'">목록으로</button>
	<!-- include 위치 -->
	
	<form action="/detail" method="POST">
	<table>
		<tr>
			<td>${userId}</td>
			<td><input type="text" name="replyment"/></td>
			<td><input type="submit" id="replysubmit" value="입력"></td>
		</tr>
	</table>
	<input type="hidden" name="userId" value="${userId}" />
	<input type="hidden" name="brdNo" value="${brdNo}" />
	</form>
	<c:if test="${not empty rlist}">
		<jsp:include page="/WEB-INF/com/board/reply.jsp" />
	</c:if>
	
</body>
</html>