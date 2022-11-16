<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	if (window.name == 'update') {
		$(opener.location).attr("href", "BoardServlet?command=board_update_form&num=${param.num}");
	} else if (window.name == 'delete') {	
		$(opener.location).attr("href", "BoardServlet?command=board_delete&num=${param.num}");
	}
	window.close();  // 비밀번호 확인창 닫기
	</script>
</body>
</html>