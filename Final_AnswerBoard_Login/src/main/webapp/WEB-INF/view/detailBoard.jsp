<%@page import="com.happy.dto.AnswerBoard_DTO"%>
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
<title>상세보기</title>
</head>
<script type="text/javascript" src="./js/answerboard.js"></script>
<script type="text/javascript">
	onload = function() {
		var fileName = document.getElementById("express").value;
		if(fileName != "N"){
			var fileLink = document.getElementById("fileLink");
			fileLink.style.cursor = "pointer";
			fileLink.setAttribute("onmouseover", "changeColor()");
			fileLink.setAttribute("onmouseout", "changeColor2()");
		}
	};
	
	function changeColor() {
		var fileLink = document.getElementById("fileLink");
		fileLink.style.fontWeight = "bold";
		fileLink.style.color = "red";
	}
	
	function changeColor2() {
		var fileLink = document.getElementById("fileLink");
		fileLink.style.fontWeight = "";
		fileLink.style.color = "";
	}
	
	function go() {
		var fileName = document.getElementById("express").value;
		if(fileName != "N"){
			var isc = confirm("다운 받으시겠습니까?");
			if(isc){
				location.href = "./fileDown.do?fileName="+fileName;
			}
		}
	}
</script>
<body>
	<%@ include file="./Header.jsp"%>
	<div id="container">
		<table>
			<col width="200px"><col width="700px">
			<tr>
				<th>아이디</th><td>${aDto.id}</td>
			</tr>
			<tr>
				<th>제목</th><td>${aDto.title}</td>
			</tr>
			<tr>
				<th>내용</th><td>${aDto.content}</td>
			</tr>
			<tr>
				<th colspan="2" style="text-align: center;">${aDto.regdate}</th>
			</tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${aDto.filename eq null}">
							파일 : <a id="fileLink" onclick="go()">없음</a>
							<input type="hidden" id="express" value="N" />
						</c:when>
						<c:otherwise>
							파일 : <a id="fileLink" onclick="go()">${aDto.orgfile}</a>
							<input type="hidden" id="express" value="${aDto.filename}" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
		
		<form action="./boardController.jsp" method="post">
			<input type="hidden" name="seq" value="${aDto.seq}">
			<div>
				<c:if test="${lDto.id eq aDto.id}">
					<input type="button" class="button" value="완전삭제" onclick="del()">
					<input type="button" class="button" value="글수정" onclick="modify()">
				</c:if>
				<input type="button" class="button" value="답글작성" onclick="reply()">
				<input type="button" class="button" value="목록으로" onclick="goBack()">
			</div>
			
		</form>
		
	</div>
	<%@ include file="./Footer.jsp"%>
</body>
</html>