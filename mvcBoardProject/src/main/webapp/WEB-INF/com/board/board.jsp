<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<table border="1" class="table-danger">
		<tr class="table-danger">
			<th class="table-danger">번호</th>
			<th class="table-danger">제목</th>
			<th class="table-danger">사용자번호</th>
			<th class="table-danger">글쓴이</th>
			<th class="table-danger">날짜</th>
		</tr>
		<tr>
			<c:forEach var="bv" items="${list}">
				<tr>
					<td>${bv.brdNo}</td>
					<td><a href="detail?brdno=${bv.brdNo}">${bv.brdTitle}</a></td>
					<td>${bv.userNo}</td>
					<td>${bv.userNm}</td>
					<td>${bv.brdDate}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>