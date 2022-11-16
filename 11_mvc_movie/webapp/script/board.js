/**
 * 
 */
 
 /* 게시글 등록에서 유효성 검사 */
 function boardCheck() {
 	var $name = $("#name");
 	var $pass = $("#pass");
 	var $email = $("#email");
 	var $title = $("#title");
 	var $content = $("#content");
 
 	/* 필수입력칸 검사 */
 	if($name.val() == "") {
 		alert("작성자 칸을 작성해주세요!");
 		$name.focus();
 		return false;
 	}
 	
 	if($pass.val() == "") {
 		alert("비밀번호 칸을 작성해주세요!");
 		$pass.focus();
 		return false;
 	}
 	
 	if($title.val().length == 0) {
 		alert("제목 칸을 작성해주세요!");
 		$title.focus();
 		return false;
 	}
 	
 	return true;
 }
 
 /* 게시글 수정, 삭제를 위한 비밀번호 입력창 띄우기 */
 function open_win(url, name) {
 	// url = BoardServlet?command=board_check_pass_form&num=
 	// name = 'update' 또는 'delete'
 	window.open(url, name, "width=500, height=200");
 }
 
 /* 비밀번호 입력창에서 유효성 검사 */
 function passCheck() {
 	var $pass = $("#pass"); 
 	
 	if($pass.val() == "") {
 		alert("비밀번호를 입력해주세요!");
 		$pass.focus();
 		return false;
 	}
 	return true;
 }
 
