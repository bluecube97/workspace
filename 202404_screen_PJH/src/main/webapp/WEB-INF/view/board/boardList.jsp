<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<script type="text/javascript" src="${root}/resource/js/boardlist.js" defer></script>
</head>
<body>
	<!-- 현재 페이지에 변수선언 -->
	<c:set var="vpage" value="${empty param.page?1:param.page}"></c:set>
	<c:set var="startPage" value="${vpage-(vpage-1)%5}"></c:set>
	<c:set var="lastPage"
		value="${fn:substringBefore(Math.ceil(count/10),'.')}" />

	<!-- 전체건수, 검색조건, 로그인, 로그아웃 -->
	<!-- 전체건수 -->
	<div class="ment">
		<c:if test="${!empty sessionScope.userMap }">
			<h2>${sessionScope.userMap.usernm }님 환영합니다.</h2>
		</c:if>
	</div>
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

			<c:choose>
				<c:when test="${empty sessionScope.userMap }">
					<!-- signup -->
					<div class="signup-header">
						<button type="button" id="signup">Signup</button>
					</div>
					<!-- login -->
					<div class="login-header">
						<button type="button" id="login">Login</button>
					</div>
				</c:when>
				<c:otherwise>
					<!-- logout -->
					<div class="logout-header">
						<button type="button" id="logout">Logout</button>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

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
				<div class="cell"><a href="/board/boardetail?brdno=${bl.brdno}&page=${page}&field=${field}&keyword=${keyword}">${bl.brdtitle}</a></div>
				<div class="cell">${bl.brdmemo}</div>
				<div class="cell">${bl.usernm}</div>
				<div class="cell">${bl.brddate}</div>
				<div class="cell">${bl.hit}</div>
			</div>
		</c:forEach>
	</div>
	<div class="todayList">
		<c:forEach var="rl" items="${rlist }">
			<div class="row">
				<div class="cell">${rl.brdno}</div>
				<div class="cell"><a href="/board/boardetail?brdno=${rl.brdno }">${rl.brdtitle}</a></div>
				
			</div>
		</c:forEach>
	</div>
	<!-- paging & write -->
	<!-- 현재페이지와 글 관리 -->
	<div class="status-body">
		<div class="status-page">
			<strong>${vpage } / ${lastPage } pages</strong>
		</div>
		<div class="status-write">
			<c:if test="${!empty sessionScope.userMap }">
				<div class="status-regedit">
					<button type="button" id="regedit" onclick="/board/regedit">글쓰기</button>
				</div>
			</c:if>
		</div>
	</div>
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
							href="/board/boardList?page=${startPage + pages }&field=${param.field}&keyword=${param.keyword}"
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