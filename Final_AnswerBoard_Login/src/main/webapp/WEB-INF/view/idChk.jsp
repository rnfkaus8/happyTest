<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복체크 확인 화면</title>
</head>
<script type="text/javascript">
	onload = function() {
		var id = opener.document.getElementsByName("id")[0].value;
		document.getElementsByName("id")[0].value = id;
	};
	
	function confirmChk(bool) {
		if(bool == true){
			opener.document.getElementsByName("password")[0].focus();
			opener.document.getElementsByName("id")[0].title = "y";
		}else{
			opener.document.getElementsByName("id")[0].focus();
		}
		self.close();
	}
	
	
</script>

<%
	String isc = request.getParameter("isc");
%>
<body>
	<table>
		<tr>
			<td>
				<input type="text" name="id" />
			</td>
		</tr>
		
		<tr>
			<td>
				<%=isc.equals("true")?"사용할 수 있습니다.":"사용할 수 없습니다." %>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirmChk(<%=isc%>)">
			</td>
		</tr>
	</table>
</body>
</html>