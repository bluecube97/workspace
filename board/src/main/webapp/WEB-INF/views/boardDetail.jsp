<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.test.board.model.UserSession" %>
<jsp:useBean id="userSession" class="com.test.board.model.UserSession" scope="session"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Post Detail</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Post Detail</h1>
        <div class="form-group">
            <label>Title</label>
            <p class="form-control-static">${post.BRDTITLE}</p>
        </div>
        <div class="form-group">
            <label>Content</label>
            <div class="form-control-static">${post.USERID} / ${post.USERNM}</div>
        </div>
        <div class="form-group">
            <label>Content</label>
            <div class="form-control-static">${post.BRDMEMO}</div>
        </div>
        <div class="form-group">
            <label>File</label>
            <c:if test="${post.FILEPATH != null}">
                <a href="/board/download/${post.FILEPATH}">Download</a>
            </c:if>
        </div>
        <a href="/board/list" class="btn btn-secondary">Back to List</a>

        <c:if test="${userSession != null && userSession.userId == post.USERID}">
            <a href="/board/delete/${post.BRDNO}" class="btn btn-danger">Delete</a>
            <a href="/board/update/${post.BRDNO}" class="btn btn-primary">Update</a>
        </c:if>
    </div>
</body>
</html>