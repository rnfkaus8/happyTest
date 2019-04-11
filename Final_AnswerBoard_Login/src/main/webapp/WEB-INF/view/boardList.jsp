<%@page import="com.happy.dto.HappyBoardPagingDto"%>
<%@page import="com.happy.dto.AnswerBoard_DTO"%>
<%@page import="java.util.List"%>
<%@page import="com.happy.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@include file="./Header.jsp"%>
	<div id="AllAnswerBoard">
		<form action="./boardController.jsp" method="post"
			onsubmit="return chsConfirm()">
			<input type="hidden" name="command" value="multiDel">
			<table id="BoardList" style="font-size: 10px;">
				<thead id="BoardList">
					<tr>
						<c:if test="${lDto.auth eq 'ADMIN'}">
							<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
						</c:if>
						<th>SEQ</th>
						<th style="width: 70px;">ID</th>
						<th style="width: 150px;">TITLE</th>
						<th>REFER</th>
						<th>STEP</th>
						<th>DEPTH</th>
						<th>READCOUNT</th>
						<th>DELFALG</th>
						<th>REGDATE</th>
					</tr>
				</thead>
				<tbody>
					<jsp:useBean id="ip" class="com.happy.board.usebean.InputPhoto" scope="page" />
					<jsp:useBean id="cp" class="com.happy.board.usebean.ConvertDate" scope="page" />
					<c:choose>
						<c:when test="${empty aLists}">
							<tr>
								<td colspan="9" style="text-align: center;">작성된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${aLists}">
								<tr>
									<c:if test="${lDto.auth eq 'ADMIN'}">
										<td><input type="checkbox" name="ch" value="${dto.seq}"></td>
									</c:if>
									<td>${dto.seq}</td>
									<td style="width: 70px;">${dto.id}</td>
									<c:choose>
										<c:when test="${dto.delfalg eq 'Y'}">
											<td style="color: red; font-size: 0.5em;">관리자에 의해 삭제된 글입니다</td>
										</c:when>
										<c:otherwise>
											<td style="width: 150px;">
												<jsp:setProperty property="depth" name="ip" value="${dto.depth}" />
												<jsp:getProperty property="photo" name="ip"/>
												<a href="./detailBoard.do?seq=${dto.seq}" style="color: black;">
													${dto.title}
												</a>
											</td>
										</c:otherwise>
									</c:choose>
									<td>${dto.refer}</td>
									<td>${dto.step}</td>
									<td>${dto.depth}</td>
									<td>${dto.readcount}</td>
									<td>${dto.delfalg}</td>
									<jsp:setProperty property="date" name="cp" value="${dto.regdate}"/>
									<td>
										<jsp:getProperty property="dateChange" name="cp"/>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<tr>
						<c:choose>
							<c:when test="${lDto.auth eq 'ADMIN'}">
								<td colspan="10" style="text-align: center;">
									<a href="./boardList.do?pageNo=${pg.firstPageNo}">◀</a>
									<a href="./boardList.do?pageNo=${pg.prevPageNo}">◁</a>

									<c:forEach var="i" begin="${pg.startPageNo}" end="${pg.endPageNo}" step="1">
										<a href="./boardList.do?pageNo=${i}"
										<c:if test="${i==pg.pageNo}">
											style="color:red;"
										</c:if>>${i}
										</a>
									</c:forEach> <a href="./boardList.do?pageNo=${pg.nextPageNo}">▷</a>
									<a href="./boardList.do?pageNo=${pg.finalPageNo}">▶</a>
								</td>
							</c:when>
							<c:otherwise>
								<td colspan="9" style="text-align: center;">
									<a href="./boardList.do?pageNo=${pg.firstPageNo}">◀</a>
									<a href="./boardList.do?pageNo=${pg.prevPageNo}">◁</a>

									<c:forEach var="i" begin="${pg.startPageNo}"
										end="${pg.endPageNo}" step="1">
										<a href="./boardList.do?pageNo=${i}"
											<c:if test="${i==pg.pageNo}">
											style="color:red;"
											</c:if>>${i}
										</a>
									</c:forEach> <a href="./boardList.do?pageNo=${pg.nextPageNo}">▷</a>
									<a href="./boardList.do?pageNo=${pg.finalPageNo}">▶</a>
								</td>
							</c:otherwise>
						</c:choose>
						
					</tr>
				</tbody>
				<tfoot>
					<tr class="tablebutton">
					
						<c:choose>
							<c:when test="${lDto.auth eq 'ADMIN'}">
								<td colspan="10" style="text-align: center;">
									<input type="submit" class="button" value="다중삭제"> 
									<input type="button" class="button" value="새글 작성" onclick="location.href='./writeForm.do'">
								</td>
							</c:when>
							<c:otherwise>
								<td colspan="9" style="text-align: center;">
									<input type="button" class="button" value="새글 작성" onclick="location.href='./writeForm.do'">
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</tfoot>

			</table>
		</form>
	</div>
	<%@ include file="./Footer.jsp"%>
</body>
</html>