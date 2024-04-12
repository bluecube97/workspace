<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>

	<div class="boardetail">
		<div class="row header">
			<div class="cell">작성자</div>

			<div class="cell">제목</div>

			<div class="cell">등록일</div>

		</div>
		<div class="row memo">
			<div class="cell">내용</div>

		</div>

	</div>

	<c:if
		test="${detail.userNo == sessionScope.userinfo.getUserNo() || sessionScope.userinfo.getUserNo() eq 1 }">
		<button type="button"
			onclick="location.href='/update?flag=u&brdno=${brdno}'">수정</button>
		<button type="button"
			onclick="location.href='/update?flag=d&brdno=${brdno}'">삭제</button>
	</c:if>
	<button type="button" onclick="location.href='/board/boardList'">목록으로</button>
</body>
</html>