<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoardDetail</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <td>
                    <div>글번호</div>
                    <div>작성자</div>
                    <div>제목</div>
                    <div>내용</div>
                </td>
            </tr>
            <tr>
                <td>
                    <div>${detail.brdno}</div>
                    <div>${detail.usernm}</div>
                    <div>${detail.brdtitle}</div>
                    <div>${detail.brdmemo}</div>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>