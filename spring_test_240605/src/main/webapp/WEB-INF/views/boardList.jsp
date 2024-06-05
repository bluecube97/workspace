<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/boardList.js" defer></script>
    <title>BoardList</title>
</head>
<body>
    <c:if test="${!empty sessionScope.userInfo}">
        <div class="welcomeComment">${sessionScope.userInfo.deptno}부서 ${sessionScope.userInfo.usernm}님 안녕하세요.</div>
    </c:if>
    <table>
        <tr>
            <c:choose>
                <c:when test="${!empty sessionScope.userInfo}">
                    <td><button onclick="regedit()">글쓰기</button></td>
                    <td>
                        <button onclick="logout()">로그아웃</button>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                        <button onclick="Login()">로그인</button>
                    </td>
                    <td>
                        <button onclick="Signup()">회원가입</button>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </table>
    <div style="padding: 0% 5%;">
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
                    <td style="padding: 1em;"><a
                            href="${pageContext.request.contextPath}/board/detail?brdno=${bv.brdno}">${bv.brdtitle}</a>
                    </td>
                    <td style="padding: 1em;">${bv.usernm}</td>
                    <td style="padding: 1em;">${bv.brddate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>