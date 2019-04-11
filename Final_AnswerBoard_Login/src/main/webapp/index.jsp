<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link type="text/css" rel="stylesheet" href="./css/loginStyle.css">
<link type="text/css" rel="stylesheet" href="./css/button.css">
</head>
<script type="text/javascript">
	function regiForm() {
		location.href = "./regiForm.do";
	}
</script>
<body>
	<header>
		<h1>힘이 난다 싸이트</h1>
		<hr />
	</header>
	<form action="./login.do" method="post">
		<input type="hidden" name="command" value="login">
		<div id="main_page">
			<div class="login_comm">
				<div class="login">
					<img alt="아이디그림" src="./img/user.png">
					<input type="text" name="id">
				</div>
				<div class="login">
					<img alt="비밀번호그림" src="./img/key.png">
					<input type="password" name="pw">
				</div>
				<div class="login">
					<input class="loginBtn" type="submit" value="로그인"> 
					<input class="loginBtn" type="button" value="회원가입" onclick="regiForm()">
				</div>
			</div>
		</div>
	</form>
	<footer>
		<hr />
		<h5>처음 만든 페이지의 정보가 들어갈 footer입니다</h5>
	</footer>
</body>
</html>