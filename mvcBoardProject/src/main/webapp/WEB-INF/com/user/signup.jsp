<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.cdnfonts.com/css/dinpro-medium" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/global.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/member.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/signUp.js"></script>
	<!-- pageContext: 현재 요청에 대한 페이지 컨텍스트를 참조합니다. 주소창에 기재되어있는 정보
		 contextPath: 현재 웹 애플리케이션의 컨텍스트 루트 경로를 나타냅니다. 예를 들어, 웹 애플리케이션이 http://localhost:8080/pubmed 에서 실행되고 있다면, contextPath는 /pubmed 임 -->

	<title>SignUp</title>
</head>
<body>
	<div class="login-container">
		<section>
			<main>
				<a href="/" class="logo a-c ma-b-10"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="로고염" /></a>
				<h2 class="ma-b-10 ma-l-5">Sign Up!</h2>
					<form id="joinform" name="joinform" action="" method="post" onsubmit="return createFrom(this)">
						<div class="form-fields">
							<fieldset>
								<label for="userId">Your ID</label>
								<div class="clear">
									<input type="text" name="userId" id="userId" tabindex="1" placeholder="이메일 형식으로 입력하세요." class="text-input" autocorrect="off" autocapitalize="off" onblur="idCheck()" />
									<div id="idcheckmessage">

									</div>
								</div>
							</fieldset>
							<fieldset>
								<label for="password" class="pw">Password</label>
								<input type="password" name="userPass" id="passWord" tabindex="2" placeholder="패스워드를 넣어주세요 (8자리 이상)" class="text-input" onblur="passCheck()"/>
								<div id="passcheckmessage">
								</div>
							<!-- <p class="fs-12 col-crim ma-t-5 ma-l-5">*비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.</p> -->
							</fieldset>

							<fieldset>
								<label for="name">Name</label>
								<input type="text" name="userNm" id="name" tabindex="3" placeholder="이름을 넣어주세요" class="text-input" onblur="nameCheck()"/>
								<!-- <p class="fs-12 col-crim ma-t-5 ma-l-5">*이름: 필수 정보입니다.</p> -->
								<div id="namecheckmessage">
								</div>
							</fieldset>
						<div class="clear">
							<fieldset class="f-l w-48">
								<label for="nation">Nationality</label>
								<select class="minimal" tabindex="4" name="nation" id="nationVal">
									<option value="">출신국가</option>
										<c:forEach var="nat" items="${nat}">
											<option value="${nat.ci}">${nat.codeko}</option>
										</c:forEach>
								</select>
								<!-- <p class="fs-12 col-crim ma-t-5 ma-l-5">*국가 선택: 필수 정보입니다.</p> -->
							</fieldset>

							<fieldset class="f-r w-48">
								<label for="job">Occupation</label>
								<select class="minimal" tabindex="5" name="job" id="jobVal">
									<option value="">직업</option>
										<c:forEach var="job" items="${job}">
											<option value="${job.ci}">${job.codeko}</option>
										</c:forEach>
								</select>
								<!-- <p class="fs-12 col-crim ma-t-5 ma-l-5">*직업 선택: 필수 정보입니다.</p> -->
							</fieldset>
						</div>

						<div class="hr-txt ma-t-20 ma-b-15">Additional selection</div>
						<div class="clear">
							<fieldset class="f-l w-48">
								<label for="major">Primary Field</label> <select class="minimal"
									tabindex="6" name="major" id="major" onchange="loadInterest()">
									<option value="">학술지분류</option>
									<c:forEach var="pri" items="${pri}">
										<option value="${pri.ci}">${pri.kn}</option>
									</c:forEach>
								</select>
							</fieldset>

							<%-- iList를 배열로 읽어옵니다. --%>
							<fieldset class="f-r w-48">
								<label for="interest">Interest Area</label> <select
									class="minimal" tabindex="7" name="interest" id="interest">
									<option value="">세부분야</option>
								</select>
							</fieldset>
						</div>
					</div>
					<input class="btn btn-1 ma-t-15 ma-b-10" type="button" onclick="signUpsubmit()" value="SignUp" tabindex="8" />
				</form>

				<p class="a-c">
					Already have an account?
					<a class="underline" href="/member/login">Login</a>
				</p>
			</main>
		</section>
	</div>
</body>
</html>