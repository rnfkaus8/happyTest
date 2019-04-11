<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 정보</title>
</head>
<script type="text/javascript" src="./js/answerboard.js"></script>
<body>
	<%@include file="./Header.jsp"%>

	<h1>회원상태정보 전체 조회</h1>
	<table>
		<tr>
			<th>SEQ(번호)</th>
			<th>ID(아이디)</th>
			<th>NAME(성명)</th>
			<th>ADDRESS(주소)</th>
			<th>PHONE(전화번호)</th>
			<th>EMAIL(이메일)</th>
			<th>ENABLE(사용여부)</th>
			<th>AUTH(등급)</th>
		</tr>
		<c:forEach var="dto" items="${lists}">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.address}</td>
				<td>${dto.phone}</td>
				<td>${dto.email}</td>
				<td><c:choose>
						<c:when test="${dto.enable eq 'Y'}">
								사용중
							</c:when>
						<c:otherwise>
								탈퇴
							</c:otherwise>
					</c:choose></td>
				<td>${dto.auth}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8" style="text-align: center;">
				<a href="./userListStatus.do?page=${pg.firstPageNo}">◀</a>
				<a href="./userListStatus.do?page=${pg.prevPageNo}">◁</a>
				<c:forEach var="i" begin="${pg.startPageNo}" end="${pg.endPageNo}" step="1">
						<a href="./userListStatus.do?page=${i}" <c:if test="${i==pg.pageNo}">style="color:red;"</c:if>>
							${i}
						</a>
				</c:forEach>
				<a href="./userListStatus.do?page=${pg.nextPageNo}">▷</a> 
				<a href="./userListStatus.do?page=${pg.finalPageNo}">▶</a>
			</td>
		</tr>
		<tr>
			<td colspan="8">
				<button onclick="back()">메인</button>
			</td>
		</tr>
		
		</table>
	<%@include file="./Footer.jsp"%>
</body>
</html>