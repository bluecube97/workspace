<%@page import="java.util.ArrayList"%>
<%@page import="board.boardVO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
<link rel="shortcut icon" href="nahida.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="${root}/js/board.js" defer></script>
<title>Board</title>
</head>
<body>
<button onclick="searchBoardList()">asdf</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>사용자번호</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		
		<c:forEach var="bv" items="${list}">
			<tr>
				<td>${bv.brdNo}</td>
				<td><a href="detail?brdno=${bv.brdNo}">${bv.brdTitle}</a></td>
				<td>${bv.userNo}</td>
				<td>${bv.userNm}</td>
				<td>${bv.brdDate}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="boardList"></div>

	<form action="" id="serchForm" method="get">
		<table border="1">
			<tr>
				<td><select name="so">
						<option ${(bv.soption == "title")?"selected":""} value="title">제목</option>
						<option ${(bv.soption == "writernm")?"selected":""}
							value="writernm">작가</option>
				</select></td>
				<td><input type="text" id="sk" name="sk" /></td>
				<td><button type="button" onclick="searchBoardList()">검색</button></td>
			</tr>
		</table>
	</form>

</body>
</html>