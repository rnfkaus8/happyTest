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
	<%@ include file="./Header.jsp"%>
	<div id="container">
		<form action="./modify.do" method="post">
			<input type="hidden" name="seq" value="${aDto.seq}">
			<table>
				<col width="200px"><col width="500px">
				<tr>
					<td>아이디</td>
					<td>
						${lDto.id}
					</td>
				</tr>
				
				<tr>
					<td>제목</td>
					<td>
						<input required="required" type="text" name="title" value="${aDto.title}">
					</td>
				</tr>
				
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="20" cols="50" required="required" name="content">${aDto.content}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="수정완료">
						<input type="button" value="돌아가기" onclick="back()">
					</td>
				</tr>
			</table>
					
		</form>
	</div>
	<%@ include file="./Footer.jsp"%>
</body>
</html>