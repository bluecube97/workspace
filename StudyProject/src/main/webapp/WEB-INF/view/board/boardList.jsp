<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${root }/resource/css/style.css">
<title>BoardList</title>
</head>
<body>
	<!-- 현재 페이지에 변수선언 -->
	<c:set var="vpage" value="${empty param.page?1:param.page}"></c:set>
	<c:set var="startPage" value="${vpage-(vpage-1)%5}"></c:set>
	<c:set var="lastPage"
		value="${fn:substringBefore(Math.ceil(count/10),'.')}" />
	
	<div>userid = ${userMap.userid }</div>
	<div>usernm = ${userMap.usernm }</div>
	<div>userno = ${userMap.userno }</div>
	<div>userrole = ${userMap.userrole }</div>
	<div>userdept = ${userMap.userdept }</div>
	<div>useremail = ${userMap.useremail }</div>
	

	<!-- 전체건수, 검색조건, 로그인, 로그아웃 -->
	<!-- 전체건수 -->
	<div class="main-header">
		<div class="count">
			<p>
				총 <strong>${count }</strong>건이 조회되었습니다
			</p>
		</div>

		<!-- 검색 -->

		<div class="search">
			<form action="" id="searchForm" method="get">
				<!-- 검색조건 -->
				<select name="field">
					<option ${(param.field == "title")?"selected":"" } value="title">제목</option>
					<option ${(param.field == "user")?"selected":"" } value="user">글쓴이</option>
				</select>
				<!-- 검색창 -->
				<input type="text" name="keyword"><span><input
					type="submit" value="검색"></span>
			</form>
		</div>
		<!-- header login / logout -->
		<div class="account-header">
			<!-- signup -->
			<div class="signup-header">
				<button type="button" onclick="location.href='${root }/user/signup'">Signup</button>
			</div>
			<!-- login -->
			<div class="login-header">
				<button type="button" onclick="location.href='${root }/user/login'">Login</button>
			</div>
			<!-- logout -->
			<div class="logout-header">
				<button type="button" onclick="location.href='${root }/user/logout'">Logout</button>
			</div>
		</div>
	</div>

	<div>count : ${count }</div>
	<div>vpage : ${vpage }</div>
	<div>startPage : ${startPage }</div>
	<div>lastPage : ${lastPage }</div>

	<!-- borad list 시작 -->
	<div class="boardList">
		<!-- header -->
		<div class="row header">
			<div class="cell">ID</div>
			<div class="cell">제목</div>
			<div class="cell">내용</div>
			<div class="cell">글쓴이</div>
			<div class="cell">등록일</div>
			<div class="cell">조회수</div>
		</div>
		<!-- content -->
		<c:forEach var="bl" items="${blist}">
			<div class="row">
				<div class="cell">${bl.brdno}</div>
				<div class="cell">${bl.brdtitle}</div>
				<div class="cell">${bl.brdmemo}</div>
				<div class="cell">${bl.userno}</div>
				<div class="cell">${bl.brddate}</div>
				<div class="cell">${bl.hit}</div>
			</div>
		</c:forEach>
	</div>

	<!-- paging -->

	<!-- 현재페이지 -->
	<strong>${vpage } / ${lastPage } pages</strong>
	<!-- 페이징 -->
	<div class="paging lists">
		<div class="page-list lists">
			<!-- 이전 -->
			<c:if test="${startPage>1 }">
				<a href="?page=${startPage-1 }" class="a-tag"><strong><</strong></a>
			</c:if>
			<c:if test="${startPage<=1 }">
				<a href="#" onclick="alert('첫페이지입니다.')" class="a-tag"><strong><</strong></a>
			</c:if>
			<!-- 이전 -->
			<!-- 페이징 리스트 -->
			<ul class="page-num lists">
				<c:forEach var="pages" begin="0" end="4">
					<c:if test="${param.page == (startPage+pages)}">
						<c:set var="style" value="font-weight:bold; color:blue;" />
					</c:if>
					<c:if test="${param.page != (startPage+pages)}">
						<c:set var="style" value="color:black;" />
					</c:if>
					<c:if test="${(startPage+pages) <= lastPage}">
						<li><a
							href="?page=${startPage + pages }&field=${param.field}&keyword=${param.keyword}"
							style="${style}">${startPage + pages }</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<!-- 다음 -->
			<c:if test="${startPage + 5 <= lastPage }">
				<a href="?page=${startPage+5 }" class="a-tag"><strong>></strong></a>
			</c:if>
			<c:if test="${startPage+5 > lastPage }">
				<a href="#" onclick="alert('마지막페이지입니다.')" class="a-tag"><strong>></strong></a>
			</c:if>
			<!-- 다음 -->
		</div>
	</div>
</body>
</html>