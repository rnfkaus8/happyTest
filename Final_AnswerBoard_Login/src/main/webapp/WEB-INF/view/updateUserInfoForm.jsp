<%@page import="com.happy.dto.UserDto"%>
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
<body>
	<form action="./updateUser.do" method="post">
		<input type="hidden" name="seq" value="${dto.seq}">
		<table>
			<tr>
				<th>SEQ</th>
				<td>${dto.seq}</td>
				<th>ID</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>${dto.name}</td>
				<th>PHONE</th>
				<td>
					<input type="text" name="phone" value="${dto.phone}">
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td colspan="3">
					<input type="text" name="email" value="${dto.email}">
				</td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td colspan="3">
					<input type="text" name="address" value="${dto.address}">
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<input type="submit" value="수정완료">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>