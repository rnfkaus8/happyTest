<%@page import="com.happy.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보</title>
</head>
<!-- 수정폼으로 이동하여 수정 -->
<!-- 탈퇴 -->
<script type="text/javascript">
	function updateForm(seq) {
// 		alert(seq);
		location.href = "./updateForm.do?seq="+seq;
		
	}
	function delUser(seq) {
// 		alert(seq);
		location.href = "./delUser.do?seq="+seq;
	}
</script>
<body>
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
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.address}</td>
			<td>${dto.phone}</td>
			<td>${dto.email}</td>
			<td>${dto.enable}</td>
			<td>
				<c:choose>
					<c:when test="${dto.auth eq 'USER'}">
						사용자
					</c:when>
					<c:otherwise>
						관리자
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th colspan="8">
				<input type="button" value="수정" onclick="updateForm('${dto.seq}')">
				<input type="button" value="탈퇴" onclick="delUser('${dto.seq}')">
			</th>
		</tr>
		
	</table>
</body>
</html>