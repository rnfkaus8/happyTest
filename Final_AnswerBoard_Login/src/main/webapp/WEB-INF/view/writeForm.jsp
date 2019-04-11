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
<script type="text/javascript" src="./dist/js/service/HuskyEZCreator.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/answerboard.js"></script>
<body>
<%@include file="./Header.jsp" %>
<div id="container">
		<form action="./write.do" method="post" enctype="multipart/form-data">
			<table style="width: 1000px;">
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
					<td><textarea id="navereditor" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						파일첨부 : <input type="file" name="file1" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="작성완료" onclick="javascript:save()" >
						<input type="reset" value="초기화">
						<input type="button" value="뒤로가기" onclick="back()">
						<!-- <a href="javascript:history.back(-1)">뒤로가기</a> : 인라인 방식 -->
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		//에디터 오브젝트
		var editor_obj = [];
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef:editor_obj,
			elPlaceHolder:"navereditor",
			sSkinURI:"./dist/SmartEditor2Skin.html",
			hParams:{
				// 툴바 사용여부
				bUseToolbar:true,
				//입력창 크기 조절바
				bUseVerticalResizer: true,
				// 모드 탭 (editor, html, text)
				bUseModeChanger: true
			}
		});
		
		function save() {
			editor_obj.getById["navereditor"].exec("UPDATE_CONTENTS_FIELD",[]);
// 			document.getElementById("frame").submit();
			document.forms[0].submit();
		}
	</script>
<%@include file="./Footer.jsp" %>
</body>
</html>