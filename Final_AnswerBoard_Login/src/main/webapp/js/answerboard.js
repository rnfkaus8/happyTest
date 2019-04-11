function checkAll(bool) {
//	alert(bool);
	var chs = document.getElementsByName("ch"); //NodeList
	for (var i = 0; i < chs.length; i++) {
		chs[i].checked = bool;
	}
}

function chsConfirm() {
	var chs = document.getElementsByName("ch");
	var cntCheck = 0;
	for (var i = 0; i < chs.length; i++) {
		if(chs[i].checked){
			cntCheck++;
		}
	}
	if(cntCheck>0){
		return true;
	}else{
		swal("선택된 글이 없습니다.")
		return false;
	}
}

// --------------------------detailBoard.jsp의 스크립트
function del() {
	var con = confirm("선택 글이 정말 삭제됩니다.");
	if(con){
		var obj = document.forms[0];
		obj.action = "./del.do";
		obj.method = "post";
		obj.submit();
	}else{
		alert("삭제가 취소되었습니다.")
	}
	
}

function modify() {
	var obj = document.forms[0];
	obj.action = "./modifyForm.do";
	obj.method = "post";
	obj.submit();
}

function reply() {
	var obj = document.forms[0];
	obj.action = "./replyForm.do";
	obj.method = "post";
	obj.submit();
}

// modifyForm.jsp의 스크립트
function back() {
	history.back(-1);
}

// replyForm.jsp의 스크립트
function contentChk() {
	var obj1 = document.getElementById("hideContent").value;
	var obj2 = document.getElementById("txtArea").value;
	var obj3 = obj2.replace("원본글>", "");
	
	if(obj1 == obj3){
		document.getElementById("txtArea").value = "";
		document.getElementById("conTxt").innerHTML = "내&nbsp;&nbsp;&nbsp;&nbsp;용";
	}
	
	
}

function goBack() {
	var obj = document.forms[0];
	obj.action = "./boardList.do";
	obj.method = "post";
	obj.submit();
}













