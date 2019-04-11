<%@page import="com.happy.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더페이지</title>
<link type="text/css" rel="stylesheet" href="./css/loginStyle.css">
<link type="text/css" rel="stylesheet" href="./css/button.css">
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<%
	UserDto lDto = (UserDto)session.getAttribute("lDto");
%>
	<header>
		<h1>힘이 난다 싸이트</h1>
		<div>
			<span class="login">${lDto.id}님 환영합니다. (등급${lDto.auth})</span>
			<a class="login" href="./logout.do">로그아웃</a>
			<a class="login" href="./userInfo.do?uSeq=${lDto.seq}">My Page</a>
		</div>
		<hr />
	</header>
</html>