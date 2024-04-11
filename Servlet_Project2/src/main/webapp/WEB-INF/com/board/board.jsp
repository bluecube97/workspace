<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.board.vo.boardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BOARD</title>
</head>
<body>
	<h1>${sv.userDept}의 ${sv.userNm}님 어서오세요.</h1>
	<h2>${count}건입니다.</h2>

	<!-- 변수 선언 -->
	<c:set var="page" value="${empty param.page?1:param.page}"></c:set>
	<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>

	<table border="1">
		<tr>
			<td>${page}</td>
			<td>/ ${lastNum}</td>
		</tr>
	</table>

	<!-- 페이징 처리 -->
	<!-- 이전 -->
	<c:if test="${startNum > 1}">
		<a href="?page=${startNum-1}&so=${param.so}&sk=${param.sk}">Prev</a>
	</c:if>
	<c:if test="${startNum <= 1}">
		<a href="#" onclick="alert('첫 페이지 입니다.')">Prev</a>
	</c:if>

	<ul>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${param.page==(startNum+i)}">
				<c:set var="style" value="font-weight:bold; color:red;" />
			</c:if>
			<c:if test="${param.page!=(startNum+i)}">
				<c:set var="style" value="" />
			</c:if>
			<c:if test="${(startNum+i)<=lastNum}">
				<li><a style="${style}"
					href="?page=${startNum+i}&so=${param.so}&sk=${param.sk}">${startNum+i}</a></li>
			</c:if>
		</c:forEach>
	</ul>

	<!-- 다음 -->
	<c:if test="${startNum + 5 <= lastNum}">
		<a href="?page=${startNum+5}&so=${param.so}&sk=${param.sk}">Next</a>
	</c:if>
	<c:if test="${startNum+5 > lastNum}">
		<a href="#" onclick="alert('마지막 페이지 입니다.')">Next</a>
	</c:if>

	<form action="" id="searchForm" method="get">
		<table border="1">
			<tr>
				<td><select name="so">
						<option ${(param.so=="title") ?"selected":""} value="title">제목</option>
						<option ${(param.so=="writernm") ?"selected":""} value="writernm">글쓴이</option>
				</select></td>
				<td><input type="text" id="sk" class="sk" name="sk" /></td>
				<td><input type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<button type="button" onclick="location.href='userlist'">유저
		리스트</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>유저 번호</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		<%
		List<boardVO> list = (List<boardVO>) request.getAttribute("board");
		for (boardVO bv : list) {
		%>
		<tr>
			<td><%=bv.getBrdNo()%></td>
			<td><a href="detail?brdno=<%=bv.getBrdNo()%>"><%=bv.getBrdTitle()%></a></td>
			<td><%=bv.getUserNo()%></td>
			<td><%=bv.getUserNm()%></td>
			<td><%=bv.getBrdDate()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>