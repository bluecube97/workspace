<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="map" items="${rlist}">
		<tr>
			<td>
				${map.replyno}
			</td>
			<td>
				${map.replynote}
			</td>
			<td>
				${map.brddate}
			</td>
			<!-- <td> -->
				<!--  버튼 -->
			<!-- </td> -->
		</tr>
		</c:forEach>
	</table>
</body>
</html>