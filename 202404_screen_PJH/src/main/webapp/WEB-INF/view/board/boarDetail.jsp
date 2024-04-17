<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<script type="text/javascript" src="${root}/resource/js/boardregedit.js" defer></script>
</head>
<body>

	<div class="boardetail">
	
		<div class="row header">
			<div class="cell">작성자</div>
			<div class="cell">제목</div>
			<div class="cell">등록일</div>
		</div>
		
		<div class="row">
			<div class="cell">${bmap.usernm}</div>

			<div class="cell">${bmap.brdtitle}</div>

			<div class="cell">${bmap.brddate}</div>
		</div>
		
		<div class="row memo">
			<div class="cell">내용</div>
		</div>
		
		<div class="row">
			<div class="cell">${bmap.brdmemo}</div>
		</div>
		
	</div>
	
	<c:if
		test="${bmap.userno == sessionScope.userMap.userno || sessionScope.userMap.userno eq 1 }">
		<button type="button"
			onclick="location.href='/board/update?flag=u&brdno=${brdno}'">수정</button>
		<button type="button"
			onclick="location.href='/board/update?flag=d&brdno=${brdno}'">삭제</button>
	</c:if>
	
	<button type="button" onclick="location.href='/board/boardList?page=${page }&field=${field }&keyword=${keyword }'">목록으로</button>
</body>
</html>