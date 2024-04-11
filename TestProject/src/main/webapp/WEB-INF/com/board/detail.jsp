<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<td>${detail.brdTitle}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${detail.brdDate}</td>
		</tr>
		<tr>
			<th colspan=2>내용</th>
		</tr>
		<tr>
			<th colspan=2>${detail.brdMemo}</th>
		</tr>
	</table>

	<c:if test="${detail.userNo == sessionScope.userinfo.getUserNo() || sessionScope.userinfo.getUserNo() eq 1}">
		<button type="button" onclick="location.href='/update?flag=u&brdno=${brdno}'">수정</button>
		<button type="button" onclick="location.href='/update?flag=d&brdno=${brdno}'">삭제</button>
	</c:if>
	<button type="button" onclick="location.href='/board'">목록으로</button>
</body>
</html>