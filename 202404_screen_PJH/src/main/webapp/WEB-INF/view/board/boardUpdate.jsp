<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<div>userid = ${userMap.userid }</div>
    <div>usernm = ${userMap.usernm }</div>
    <div>userno = ${userMap.userno }</div>
    <div>userrole = ${userMap.userrole }</div>
    <div>userdept = ${userMap.userdept }</div>
    <div>useremail = ${userMap.useremail }</div>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${detail.brdtitle}"/></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea name="content">${detail.brdmemo}</textarea></td>
			</tr>
		</table>
		<input type="hidden" value="${brdno}"/>
		<input type="submit" value="저장" />
	</form>
</body>
</html>