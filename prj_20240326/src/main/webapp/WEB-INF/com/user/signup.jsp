<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <script type="text/javascript" src="${root}/js/signup.js"></script>
</head>
<body>
ROOT:${root}
<c:if test="${!empty ment }">
    <script type="text/javascript">
        alert("${ment}");

    </script>
</c:if>
<form id="signForm" action="" method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <td><input type="text" id="id" class="id" name="id"></td>
            <td>
                <button type="button" onclick="idChk()">ID Check</button>
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" id="name" class="name" name="name"/></td>
        </tr>
        <tr>
            <th>PASSWORD</th>
            <td><input type="password" id="pw" class="pw" name="pw" onblur="pwChk()"></td>
        </tr>
        <tr>
            <th>PASSWORD 확인</th>
            <td><input type="password" id="pwchk" class="pwchk" name="pwchk" onblur="rePwChk()"></td>
        </tr>
        <tr>
            <th>EMAIL</th>
            <td><input type="email" id="email" class="email" name="email"></td>
        </tr>
        <tr>
            <th>JOB</th>
            <td><select id="joblist" name="joblist" onclick="loadJobList()">
                <option value="">직업선택</option>
                <c:forEach var="job" items="${jList}">
                    <option value="${job.code}">${job.codenm}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>
    <button type="button" onclick="valChk()">가입</button>
    <div id="message"></div>
</form>
</body>
</html>