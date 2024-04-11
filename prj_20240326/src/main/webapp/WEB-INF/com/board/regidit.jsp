<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regidit</title>
</head>
<body>
	<form action="" method="post">
		${sessionScope.userinfo.userNm}님 어서오세요.
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="저장" />
	</form>
</body>
</html>