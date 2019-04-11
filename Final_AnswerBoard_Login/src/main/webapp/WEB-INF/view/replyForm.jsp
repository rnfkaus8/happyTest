<%@page import="com.happy.dto.AnswerBoard_DTO"%>
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
<script type="text/javascript" src="./js/answerboard.js"></script>
<body>
<%@include file="./Header.jsp" %>
<div id="container">
		<form action="./reply.do"method="post">
			<input type="hidden" name="seq" value="${aDto.seq}">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" required="required" readonly="readonly" name="id" value="${lDto.id}">
					</td>
				</tr>

				<tr>
					<td>제목</td>
					<td><input type="text" required="required" name="title">
					</td>
				</tr>

				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="60" name="content"></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="작성완료">
						<input type="reset" value="초기화">
						<input type="button" value="뒤로가기" onclick="back()">
						<!-- <a href="javascript:history.back(-1)">뒤로가기</a> : 인라인 방식 -->
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@include file="./Footer.jsp" %>
</body>
</html>