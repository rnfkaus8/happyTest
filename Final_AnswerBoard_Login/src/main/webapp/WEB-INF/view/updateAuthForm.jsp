<%@page import="com.happy.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="./Header.jsp" %>
	<h1>회원등급변경하기</h1>
	<form action="./updateAuth.do" method="post">
		<input type="hidden" name="seq" value="${dto.seq}">
		<table>
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name}</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
					<select name="role">
						<c:choose>
							<c:when test="${dto.auth eq 'ADMIN'}">
								<option value="ADMIN" selected="selected">관리자</option>
								<option value="USER">사용자</option>
							</c:when>
							<c:otherwise>
								<option value="ADMIN">관리자</option>
								<option value="USER" selected="selected">사용자</option>
							</c:otherwise>
						</c:choose>
						
					</select>
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="변경완료">
				</th>
			</tr>
		</table>
	</form>
<%@include file="./Footer.jsp" %>
</body>
</html>