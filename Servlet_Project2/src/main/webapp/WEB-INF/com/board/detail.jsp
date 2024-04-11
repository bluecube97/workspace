<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DETAIL</title>
</head>
<body>
<table border="1">
    <tr>
        <th>글쓴이</th>
        <td>${detail.userNm}</td>
    </tr>
    <tr>
        <th>제목</th>
        <td>${detail.brdTitle}</td>
    </tr>
    <tr>
        <th>등록일</th>
        <td>${detail.brdDate}</td>
    </tr>
    <tr>
        <th colspan="2">내용</th>
    </tr>
    <tr>
        <td colspan="2">${detail.brdMemo}</td>
    </tr>
</table>
<button type="button" onclick="location.href=''">목록으로</button>
</body>
</html>