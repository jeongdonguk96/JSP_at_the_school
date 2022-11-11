/**
 * 
 */
 
 /* 
  * 로그인시 id나 pwd를 입력하지 않았을 경우를 체크하는 함수
  */
 function loginCheck() {
 	var userid = document.getElementById("userid").value;
 	var userpwd = document.getElementById("userpwd").value;
 	
 	/* id가 입력이 되지 않았을 경우 false를 리턴 */
 	if(userid == "") {
 		alert("아이디를 입력해주세요!");
 		document.getElementById("userid").focus();
 		return false;
 	}
 	
 	/* pwd가 입력이 되지 않았을 경우 false를 리턴 */
 	if(userpwd == "") {
 		alert("비밀번호를 입력해주세요!");
 		document.getElementById("userpwd").focus();
 		return false;
 	}
 	
 	/* 그 외에는 true 리턴 */
 	return true; 
 }
 
 /* 
  * 회원가입시 id가 중복인지 아닌지 확인하는 함수
  */
 function idCheck() {
 	var userid = document.getElementById("userid").value;
 	
 	/* 먼저 id가 입력이 되지 않았을 경우 false를 리턴 */
 	if(userid == "") {
		alert("아이디를 입력해주세요!");
		document.getElementById("userid").focus();
 		return false;
 	}

	var url = "idCheck.do?userid=" + userid;
 	/* 팝업창 열기 */
 	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
 }
 
 /* 
  * 회원가입 작성이 잘 이우러졌는지 확인하는 함수
  */
 function joinCheck() {
 	/*
 	var username = document.getElementById("name").value;
 	var userid = document.getElementById("userid").value;
 	var userpwd = document.getElementById("pwd").value;
 	var userpwd_check = document.getElementById("pwd_check").value;
	var userreid = document.getElementById("reid").value;
	*/
	 	
 	/* 1. 필수 입력 항목이 작성 되었는지 확인 */
 	if(document.getElementById("name").value != "" && document.getElementById("userid").value != "" && document.getElementById("pwd").value != "" && document.getElementById("pwd_check").value != "" && document.getElementById("reid").value != "") {
 		return true;
 	} else {
 		alert("필수 입력 항목을 작성해주세요!");
		document.getElementById("name").focus();
 		return false;
 	}
 	
 	/* 2. 암호와 학인암호 일치 여부 확인 */
 	if(document.getElementById("pwd").value != document.getElementById("pwd_check").value) {
 		alert("암호가 일치하지 않습니다! 다시 입력해주세요.");
 		document.getElementById("userpwd").focus();
 		return false;
 	} 	
 } 
 
 /*
  * 아이디 중복체크 화면에서 사용 누를 시 회원가입 화면으로 ID 복사
  */
 function idok() {
 	opener.document.getElementById("userid").value = document.getElementById("userid").value;
 	opener.document.getElementById("reid").value = document.getElementById("userid").value;
 	self.close();
 	/* opener – 현재 창을 열어 준 부모 창(회원 가입 폼), self - 현재 창, reid - 회원가입시 숨겨둔 정보 */	
 }
 
 
 
 
 
 