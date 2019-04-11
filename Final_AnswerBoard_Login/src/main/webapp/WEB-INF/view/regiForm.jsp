<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function emailCheck() {
		var email = document.getElementById("email").value;
			var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
		//맞으면 true 아니면 false
		if(!pattern.test(email)){
			alert("잘 못 작성하였습니다.");
			
		}
	}
	
	function idChk() {
		var doc = document.getElementsByName("id")[0].value;
		window.open("./idChk.do?id="+doc,"","width=500,height=500");
	}
	
	function idConfirm() {
// 		alert("작동");
		var id = document.getElementsByName("id")[0].title;
		if (id == "n") {
			alert("아이디 중복 검사를 먼저 실행해 주세요");
			document.getElementsByName("id")[0].focus();
		}
	}
</script>
<body>
<%-- #{id}, #{password}, #{name}, #{address}, #{phone}, #{email} --%>
<h1>회원가입</h1>
<form action="./addUser.do" method="post">
	<div id="AllAnswerBoard">
		<table id="BoardList">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" title="n" name="id" />
					<input type="button" value="중복체크" onclick="idChk()" />
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" onclick="idConfirm()" name="password" />
				</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>
					<input type="text" onclick="idConfirm()" name="name" />
				</td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td>
					<input type="text" onclick="idConfirm()" name="address"  />
				</td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" onclick="idConfirm()" name="phone" />
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" id="email" onclick="idConfirm()" name="email"/>
					<input type="button" value="이메일확인" onclick="emailCheck()"  />
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="회원가입"/>
				</th>
			</tr>
		</table>
	</div>
</form>
</body>
</html>