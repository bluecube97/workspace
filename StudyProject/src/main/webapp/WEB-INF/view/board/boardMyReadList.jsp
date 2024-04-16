<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyReadList</title>
</head>
<body>

	<!-- 자신이 최근 에 쓴 문서 5개 출력 -->
	<!-- MyReadBoardList 출력 -->
	<div class="boardlist">
		<!-- header -->
		<div class="row header">
			<div class="cell">글 번호</div>
			<div class="cell">제목</div>
			<div class="cell">내용</div>
			<div class="cell">작성일</div>
		</div>
		<!-- content -->
		<c:forEach var="mdlist" items="${mdlist}">
			<div class="row">
				<div class="cell">${mdlist.brdno }</div>
				<div class="cell">
					<a href="/board/boardetail?brdno=${mdlist.brdno}&mylistflag=true">${mdlist.brdtitle}</a>
				</div>
				<div class="cell">${mdlist.brdmemo }</div>
				<div class="cell">${mdlist.lastreadate }</div>
			</div>
		</c:forEach>
	</div>
	<!-- 목록으로 가는 버튼 -->
	<div class="list-btn">
		<button type="button"
			onclick="location.href='${root}/board/boardList'">목록으로</button>
	</div>

</body>
</html>