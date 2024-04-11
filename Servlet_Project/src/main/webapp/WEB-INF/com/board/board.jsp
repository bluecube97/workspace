<%@page import="com.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<!--  주석 표현 -->
<body>
	<h1>${sv.userDept}의${sv.userNm}님 어서오세요</h1>
	<h2>${count}건입니다.</h2>

	<!-- 변수 선언 -->
	<c:set var="page" value="${empty param.page?1:param.page}"></c:set>
	<!-- 페이지가 없으면 1을 넣고 그 외에는 그냥 페이지를 넣어라 -->
	<c:set var="startNum" value="${page-(page-1)%5 }"></c:set>
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
	<table border="1">
		<tr>
			<td>${page}</td>
			<td>/${lastNum}</td>
		</tr>
	</table>

	<!-- 페이징 처리 -->
	<!-- 이전 -->
	<c:if test="${startNum>1 }">
		<a href="?page=${startNum-1}&so=${param.so}&sk=${param.sk}">Prev</a>
		<!-- <a href 앵커라고 하이퍼링크를 넣어두는 것 -->
	</c:if>

	<c:if test="${startNum <=1}">
		<a href="#" onclick="alert('첫 페이지입니다.');">Prev</a>
		<!--  #을 넣게되면 sql이 안돌고 그 페이지 그대로 됨 -->
	</c:if>
	<ul>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${param.page==(startNum+i)}">
				<c:set var="style" value="font-weight:bold; color:red;" />
			</c:if>
			<c:if test="${param.page!=(startNum+i)}">
				<c:set var="style" value="" />
			</c:if>
			<c:if test="${(startNum+i) <=lastNum}">
				<li><a style="${style}"
					href="?page=${startNum+i}&so=${param.so}&sk=${param.sk}">${startNum+i}</a>
				</li>
			</c:if>
		</c:forEach>
	</ul>
	<!-- 다음 -->
	<c:if test="${startNum+5<lastNum}">
		<a href="?page=${startNum+5}&so=${param.so}&sk=${param.sk}">Next</a>
	</c:if>

	<c:if test="${startNum+5 >lastNum}">
		<a href="#" onclick="alert('마지막 페이지입니다.');">Next</a>
	</c:if>

	<form action="" id="searchForm" method="get">
		<table border="1">
			<tr>
				<td><select name="so">
						<option ${(param.so=="title")?"selected":""} value="title">제목</option>
						<option ${(param.so=="writernm")?"selected":""} value="writernm">글쓴이</option>
				</select></td>
				<td><input type="text" id="sk" name="sk" /> <!-- request.getparameter는 name만 봄, id, class는 javascript나 css로 보내는 DOM요소  -->
				</td>
				<td><input type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>사용자번호</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="bv" items="${board}">
			<tr>
				<td>${bv.brdNo}</td>
				<td><a href="detail?brdno=${bv.brdNo}">${bv.brdTitle}</a></td>
				<td>${bv.userNo}</td>
				<td>${bv.userNm}</td>
				<td>${bv.brdDate}</td>
			</tr>
		</c:forEach>
	</table>
	<button type="button" onclick="location.href='/userList'">유저목록</button>
</body>
</html>