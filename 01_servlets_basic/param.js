/**
 * 
 */
 function check() {
	if(document.getElementById("id").value==""){ // 빈칸이면 에러창 대신 알람 뜨게끔
		alert("아이디를 입력해주세요.");
		document.getElementById("id").focus();
		return false;
	} else if(document.getElementById("age").value==""){ // 빈칸이면 에러창 대신 알람 뜨게끔
		alert("나이를 입력해주세요.");
		document.getElementById("age").focus();
		return false;
	} else if(isNaN(document.getElementById("age").value)) { // 숫자가 아닌 문자를 넣었을 때 뜨게끔
		alert("숫자를 입력해주세요!");					     	 // NotaNumber : 숫자인지 아닌지 확인
		document.getElementById("age").focus();
		return false;
	} else {
		return true;
	}	
}