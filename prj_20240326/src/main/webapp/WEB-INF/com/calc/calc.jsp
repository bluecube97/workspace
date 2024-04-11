<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${root}/js/calc.js" defer></script>
    <title>Calculator</title>
</head>
<body>

<div id="outputDiv">0</div>
<div id="buttonDiv1">
    <button type="button" onclick="input1()">1</button>
    <button type="button" onclick="input2()">2</button>
    <button type="button" onclick="input3()">3</button>
    <button type="button" onclick="plus()">+</button>
</div>
<div id="buttonDiv2">
    <button type="button" onclick="input4()">4</button>
    <button type="button" onclick="input5()">5</button>
    <button type="button" onclick="input6()">6</button>
    <button type="button" onclick="minus()">-</button>
</div>
<div id="buttonDiv3">
    <button type="button" onclick="input7()">7</button>
    <button type="button" onclick="input8()">8</button>
    <button type="button" onclick="input9()">9</button>
    <button type="button" onclick="multi()">*</button>
</div>
<div id="buttonDiv4">
    <button type="button" onclick="inputErase()"><-</button>
    <button type="button" onclick="input0()">0</button>
    <button type="button" onclick="inputEnter()">Enter</button>
    <button type="button" onclick="division()">/</button>
</div>

</body>
</html>