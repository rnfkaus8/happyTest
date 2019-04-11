<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회(사용계정)</title>
</head>
<script type="text/javascript" src="./js/answerboard.js"></script>
<script type="text/javascript">
	function updateAuth(seq) {
// 		alert(typeof seq);
		location.href = "./updateAuthForm.do?seq="+seq;
	}
</script>
<body>
<%@include file="./Header.jsp" %>
	<h1>회원정보조회</h1>
	<table>
		<tr>
			<th>SEQ(번호)</th>
			<th>ID(아이디)</th>
			<th>NAME(성명)</th>
			<th>EMAIL(이메일)</th>
			<th>AUTH(등급)</th>
			<th>등급변경</th>
		</tr>
		
		<c:forEach var="dto" items="${lists}">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td colspan="2">${dto.email}</td>
				<td>${dto.auth}</td>
				<td>
					<button onclick="updateAuth('${dto.seq}')">변경</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			
		</tr>
		<tr>
			<td colspan="8" style="text-align: center;">
				<a href="./userList.do?page=${pg.firstPageNo}">◀</a>
				<a href="./userList.do?page=${pg.prevPageNo}">◁</a>
				<c:forEach var="i" begin="${pg.startPageNo}" end="${pg.endPageNo}" step="1">
						<a href="./userList.do?page=${i}" <c:if test="${i==pg.pageNo}">style="color:red;"</c:if>>
							${i}
						</a>
				</c:forEach>
				<a href="./userList.do?page=${pg.nextPageNo}">▷</a> 
				<a href="./userList.do?page=${pg.finalPageNo}">▶</a>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<button onclick="back()">메인</button>
			</td>
		</tr>
	</table>
<%@include file="./Footer.jsp" %>
</body>
</html>