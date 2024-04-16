<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Regedit</title>
<link rel="stylesheet" type="text/css" href="${root }/resource/css/regedit.css" />
<script type="text/javascript" src="${root}/resource/js/boardregedit.js" defer></script>
</head>
<body>
	<div class="ment">${ment }</div>
	
	<div>userid = ${userMap.userid }</div>
    <div>usernm = ${userMap.usernm }</div>
    <div>userno = ${userMap.userno }</div>
    <div>userrole = ${userMap.userrole }</div>
    <div>userdept = ${userMap.userdept }</div>
    <div>useremail = ${userMap.useremail }</div>
	
	<div class="form-container">
		<form id="regform" action="" method="POST">
		
			<div class="detail-param">
				<label for="brdtitle">제목</label> <input type="text" name="brdtitle"
					id="brdtitle" />
			</div>
			
			<div class="detail-param">
				<label for="brdmemo">글 내용</label>
				<textarea name="brdmemo" id="brdmemo"></textarea>
			</div>
			
			<div class="detail-param">
				<button type="button" onclick="formSubmit()">저장</button>
			</div>
			
		</form>
	</div>
</body>
</html>