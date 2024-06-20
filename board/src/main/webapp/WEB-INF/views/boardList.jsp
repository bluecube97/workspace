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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/css/board.css">
    <title>Board List</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-between align-items-center mt-5 mb-3">
            <h1>Board List</h1>
            <c:choose>
                <c:when test="${userSession.userId == null}">
                    <div>
                        <a href="/user/login" class="btn btn-primary">Login</a>
                        <a href="/user/signup" class="btn btn-secondary">Sign Up</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="/user/logout" class="btn btn-primary">Logout</a>
                    <span>어서오세요, ${userSession.userNm}님</span>
                </c:otherwise>
            </c:choose>
            <div>
                <a href="https://www.youtube.com" class="btn btn-danger" target="_blank">YouTube</a>
            </div>
        </div>
        <form method="get" action="/board/list" class="search-container">
            <input type="text" class="form-control" name="keyword" placeholder="제목, 저자명을 입력하세요." value="${keyword}">
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        <c:choose>
            <c:when test="${userSession.userNm}">

            </c:when>
        </c:choose>
        <ul class="d-flex list-unstyled ul-tag">
            <li class="mr-3">
                <a href="/board/list?bgno=3" class="btn btn-light">
                    <i class="fa-solid fa-book"></i>개발책
                </a>
            </li>
            <li class="mr-3">
                <a href="/board/list?bgno=4" class="btn btn-light">
                    <i class="fa-solid fa-baseball"></i>야구
                </a>
            </li>
            <li class="mr-3">
                <a href="/board/list?bgno=5" class="btn btn-light">
                    <i class="fa-solid fa-futbol"></i>추추추추..축구
                </a>
            </li>
            <li class="mr-3">
                <a href="/board/list?bgno=6" class="btn btn-light">
                    <i class="fa-brands fa-fantasy-flight-games"></i>게-무
                </a>
            </li>
            <li class="mr-3">
                <a href="/board/list?bgno=7" class="btn btn-light">
                    <i class="fa-brands fa-space-awesome"></i>푸키몬
                </a>
            </li>
            <li class="mr-3">
                <a href="/board/list?bgno=8" class="btn btn-light">
                    <i class="fa-solid fa-basketball"></i>넝~구
                </a>
            </li>
        </ul>
        <table class="table table-striped mt-3">
            <thead>
            <tr>
                <td>ID</td>
                <td>제목</td>
                <td>글쓴이</td>
                <td>내용</td>
                <td>등록일</td>
                <td>조회수</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="row" items="${boardList}">
                <tr>
                    <td>${row.BRDNO }</td>
                    <td><a href="/board/detail/${row.BRDNO}">${row.BRDTITLE}</a></td>
                    <td>${row.USERNM }</td>
                    <td>${row.BRDMEMO }</td>
                    <td><fmt:formatDate value="${row.BRDDATE}"
                                        pattern="yyyy년 MM월 dd일 HH시"/></td>
                    <td>${row.HIT }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav>
            <div class="d-flex justify-content-between align-items-center mt-5 mb-3">
                <ul class="pagination">
                    <li class="page-item ${!hasPrev ? 'disabled' : ''}"><a
                            class="page-link"
                            href="/board/list?keyword=${keyword}&page=${startPage - 10}&size=${size}&bgno=${bgno}">이전</a>
                    </li>
                    <c:forEach var="i" begin="${startPage}" end="${endPage}">
                        <li class="page-item ${i == currentPage ? 'active' : ''}"><a
                                class="page-link"
                                href="/board/list?keyword=${keyword}&bgno=${bgno}&page=${i}&size=${size}&bgno=${bgno}">${i}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item ${!hasNext ? 'disabled' : ''}"><a
                            class="page-link"
                            href="/board/list?keyword=${keyword}&page=${endPage + 1}&size=${size}&bgno=${bgno}">다음</a>
                    </li>
                </ul>
                <div class="mt-3 mb-3">
                    <c:if test="${not empty userSession.userId}">
                        <a href="/board/write" class="btn btn-success">글쓰기</a>
                    </c:if>
                </div>
                <div class="mt-3 mb-3">
                    <a href="/board/unity" class="btn btn-success">게임 실행</a>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>