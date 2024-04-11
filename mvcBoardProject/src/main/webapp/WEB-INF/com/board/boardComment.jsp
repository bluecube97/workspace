<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment</title>
</head>
<body>

	<table border="1">
		<c:forEach var="comment" items="${commentList}">
			<tr>
				<th>${comment.userno}</th>
				<th>${comment.commenttitle}</th>
				<td>${comment.commentmemo}</td>
				<td>${comment.commentdate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>