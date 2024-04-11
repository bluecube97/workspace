<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.user.vo.userListVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kr">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>USERLIST</title>
</head>
<body>
	<h2>${ucount}건입니다.</h2>

	<!-- 변수 선언 -->
	<c:set var="page" value="${empty param.page?1:param.page}"></c:set>
	<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(ucount/10), '.')}"></c:set>

	<table border="1">
		<tr>
			<td>${page}</td>
			<td>/ ${lastNum}</td>
		</tr>
	</table>

	<!-- 페이징 처리 -->
	<!-- 이전 -->
	<c:if test="${startNum > 1}">
		<a href="?page=${startNum-1}&ulso=${param.so}&ulsk=${param.sk}">Prev</a>
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
					href="?page=${startNum+i}&ulso=${param.ulso}&ulsk=${param.ulsk}">${startNum+i}</a></li>
			</c:if>
		</c:forEach>
	</ul>

	<!-- 다음 -->
	<c:if test="${startNum + 5 <= lastNum}">
		<a href="?page=${startNum + 5}&ulso=${param.ulso}&ulsk=${param.ulsk}">Next</a>
	</c:if>
	<c:if test="${startNum + 5 > lastNum}">
		<a href="#" onclick="alert('마지막 페이지 입니다.')">Next</a>
	</c:if>

	<form action="" id="searchForm" method="get">
		<table border="1">
			<tr>
				<td><select name="ulso">
						<option ${(param.ulso=="usernm") ?"selected":""} value="usernm">이름</option>
						<option ${(param.ulso=="userrole") ?"selected":""}
							value="userrole">역할</option>
				</select></td>
				<td><input type="text" id="ulsk" class="ulsk" name="ulsk" /></td>
				<td><input type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>사용자 번호</th>
			<th>사용자 이름</th>
			<th>사용자 역할</th>
		</tr>
		<%
		List<userListVO> list = (List<userListVO>) request.getAttribute("userlist");
		for (userListVO ulv : list) {
		%>
		<tr>
			<td><%=ulv.getUserNo()%></td>
			<td><%=ulv.getUserNm()%></td>
			<td><%=ulv.getUserRole()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>