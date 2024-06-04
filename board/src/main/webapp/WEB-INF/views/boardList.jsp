<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BOARDLIST</title>
</head>
<body>
<table>
	<tr>
	<td><input type="button" onclick="location.href='regidit'" value="글쓰기"/></td> 
	</tr>
</table>
<div style = "padding: 0% 5%;">
	<table border="1" class="table table-dark table-striped" style="border-collapse: collapse;">
	    <tr>
	        <th style="padding: 1em;">번호</th>
	        <th style="padding: 1em;">제목</th>
	        <th style="padding: 1em;">작성자</th>
	        <th style="padding: 1em;">날짜</th>
	    </tr>
    	<c:forEach var="bv" items="${blist}">
        <tr>
            <td style="padding: 1em;">${bv.brdno}</td>
            <td style="padding: 1em;">${bv.brdtitle}</td>
            <td style="padding: 1em;">${bv.usernm}</td>
            <td style="padding: 1em;">${bv.brddate}</td>
        </tr>
    	</c:forEach>
	</table>
</div>
		<button type="button" class="btn btn-outline-primary" onclick="location.href='/board/boardList'">목록으로</button>
</body>
</html>