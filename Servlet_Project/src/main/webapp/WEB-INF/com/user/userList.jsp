<%@page import="com.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BOARD</title>
</head>
<body>
	<h2>${count} 건입니다.</h2>
	<!-- 변수 선언 -->
	<c:set var ="page" value="${empty param.page?1:param.page}"></c:set><!-- 페이지가 없으면 1을 넣고 그 외에는 그냥 페이지를 넣어라 -->
	<c:set var = "startNum" value ="${page-(page-1)%5 }"></c:set>
	<c:set var = "lastNum" value ="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
	<table border ="1">
			<tr>
				<td>${page}</td>
				<td>/${lastNum}</td>
			</tr>
	</table>
	<!-- 페이징 처리 -->
	<!-- 이전 -->
	<c:if test="${startNum>1 }">
		<a href="?page=${startNum-1}&so=${param.so}&sk=${param.sk}">Prev</a><!-- <a href 앵커라고 하이퍼링크를 넣어두는 것 -->
	</c:if>
	
	<c:if test="${startNum <=1}">
		<a href="#" onclick="alert('첫 페이지입니다.');">Prev</a>
	</c:if>
	<ul>
		<c:forEach var="i" begin="0" end="4"	>
			<c:if test="${param.page==(startNum+i)}">
				<c:set var = "style" value = "font-weight:bold; color:red;" />
			</c:if>
			<c:if test="${param.page!=(startNum+i)}">
				<c:set var = "style" value = "" />
			</c:if>
			<c:if test="${(startNum+i) <=lastNum}">
				<li><a style="${style}" href="?page=${startNum+i}&so=${param.so}&sk=${param.sk}">${startNum+i}</a>
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
		<table boarder="1">
			<tr>
				<td>
					<input type="text" id="nmk" name="nmk" />  <!-- request.getparameter는 name만 봄, id, class는 javascript나 css로 보내는 DOM요소  -->
				</td>
				<td>
					<input type="submit" value="검색" />
				</td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>사용자번호</th>
			<th>사용자명</th>
			<th>사용자롤</th>
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