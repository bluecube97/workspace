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
			<td>${detailMap.usernm}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detailMap.brdtitle}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${detailMap.brddate}</td>
		</tr>
		<tr>
			<th colspan=2>내용</th>
		</tr>
		<tr>
			<th colspan=2>${detailMap.brdmemo}</th>
		</tr>
	</table>

	<a href="comment?brdno=${detailMap.brdno}">덧글보기</a>

	<table border="1">
		<c:forEach var="comment" items="${commentList}">
			<tr>
				<th>${comment.userno}</th>
				<th>${comment.commenttitle}</th>
				<td>${comment.commentmemo}</td>
				<td>${comment.commentdate}</td>
			</tr>
		</c:forEach>
	</table>

	<button type="button">덧글 새로고침</button>

	<table border="1">
		<c:forEach var="reply" items="${replyList}">
			<tr>
				<th>${reply.user}</th>
				<td>${reply.memo}</td>
			</tr>
		</c:forEach>
	</table>

	<button type="button">댓글 새로고침</button>
	<div>
		<button type="button">
			<!-- onclick="comment"-->
			덧글달기
		</button>
		<button type="button">
			<!-- onclick="reply"-->
			댓글달기
		</button>
	</div>
</body>
</html>