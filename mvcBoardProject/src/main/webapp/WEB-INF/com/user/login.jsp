<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.cdnfonts.com/css/dinpro-medium"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/user.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/login.js"></script>
<title>Login</title>
</head>
<body>
	<div class="login-container">
		<section>
			<main>
				<div>
					<form action="/user/login" method="post">
						<div class="form-fields">
							<fieldset>
								<label for="ID">Your ID</label> <input type="text" name="id"
									id="id" tabindex="1" placeholder="ID" class="text-input"
									autocorrect="off" autocapitalize="off" />
							</fieldset>
							<fieldset>
								<label for="password" class="pw">Password <a href="#">Forgot?</a></label>
								<input type="password" name="pass" id="password" tabindex="2"
									placeholder="Password" class="text-input" />
							</fieldset>
						</div>

						<p class="error-message ma-t-10 pa-l-5 col-crim a-c" id="ment"></p>
						<input class="btn btn-1 ma-t-15 ma-b-10" type="button"
							value="LOGIN" onclick="UserCheck()" tabindex="3" />

					</form>
					<p class="a-c">
						Don't have an account? <a class="underline" href="/member/signup">Sign
							up</a>
					</p>
				</div>
			</main>
		</section>
	</div>
</body>
</html>