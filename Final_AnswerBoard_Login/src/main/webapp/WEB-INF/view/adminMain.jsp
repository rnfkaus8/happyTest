<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./error.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>

<body>
	<h1>관리자 모드</h1>
	<div>
		<span>${lDto.name}님 환영합니다.(등급:${lDto.auth})</span>
	</div>
	<div style="font-size: small;">
		<a href="./logout.do">로그아웃</a>
	</div>
	<div>
		<a href="./userListStatus.do?page=1">회원상태정보조회</a>
	</div>
	<div>
		<a href="./userList.do?page=1">회원정보조회(사용계정)</a>
	</div>
</body>
</html>