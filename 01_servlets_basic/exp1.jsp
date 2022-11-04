<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form method="post" action="Ex1Servlet">
		<label for="name">이름 *</label> 
		<input type="text" name="name" id="name" style=position:absolute required/>
		<br>
		<label for="idNUm">주민등록번호 * </label>
		<input type="text" name="idNum" id="idNum" required/> - <input type="text" name="idNum2" id="idNum2" required/>
		<br>
		<label for="id">아이디 * </label>
		<input type="text" name="id" id="id" required/>
		<br>
		<label for="pwd">비밀번호 * </label>
		<input type="text" name="pwd" id="pwd" style=position:relaive required/>
		<br>
		<label for="pwd_cor">비밀번호 확인 * </label>
		<input type="text" name="pwd_cor" id="pwd_cor" required/>
		<br>
		<label for="email">이메일</label>
		<input type="text" name="email" id="email"/> @ <input type="text" name="email2" id="email2"/> 
		<select id="com" name="com" size="1">
        	<option value="naver">naver.com</option>
        	<option value="nate">nate.com</option>
        	<option value="google">google.com</option>
        	<option value="kakao">kakao.com</option>
        	<option value="manual">직접 입력</option>
        </select><br>
		<label for="postNum">우편번호</label>
		<input type="text" name="postNum" id="postNum"/>
		<br>
		<label for="address">주소</label>
		<input type="text" name="address" id="address"/> <input type="text" name="address2" id="address2"/>
		<br>
		<label for="phoneNum">전화번호</label>
		<input type="text" name="phoneNum" id="phoneNum" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/>
		<br>
		<label for="job">직업</label>
        <select id="job" name="job" size="3">
            <option value="">선택하세요</option>
            <option value="학생">학생</option>
            <option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
            <option value="언론">언론</option>
            <option value="공무원">공무원</option>
            <option value="군인">군인</option>
            <option value="서비스업">서비스업</option>
            <option value="교육">교육</option>
        </select><br>
        <label>메일/SMS 정보 수신 : </label>
            <input type="radio" name="chk_mail" value="yes" checked>수신
            <input type="radio" name="chk_mail" value="no">수신거부<br>
        
        <label for="interest">관심분야</label>
        <input type="checkbox" name="interest" value="생두">생두
        <input type="checkbox" name="interest" value="원두">원두
        <input type="checkbox" name="interest" value="로스팅">로스팅
        <input type="checkbox" name="interest" value="핸드드립">핸드드립
        <input type="checkbox" name="interest" value="에스프레소">에스프레소
        <input type="checkbox" name="interest" value="창업">창업
        <br><br>
        <div style="text-align:center">
        <input type="submit" value="회원가입">
        <input type="submit" value="취소">
        </div>
    </form>
</body>
</html>