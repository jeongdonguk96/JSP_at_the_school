<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.ezen.javabeans.BoardBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<BoardBean> boardList = new ArrayList<>();
	boardList.add(new BoardBean(1, "홍길동", "gdhong@email.com", "첫번째 게시글", "안녕하세요 첫번째 게시글입니다.", "2021-10-08"));
	boardList.add(new BoardBean(2, "장보고", "bkjang@email.com", "가입인사", "안녕하세요 가입인사드립니다.", "2021-11-15"));
	boardList.add(new BoardBean(3, "유관순", "ksyou@email.com", "정모 알림", "11월 둘째주 금요일에 정기모임입니다.", "2022-11-01"));
	boardList.add(new BoardBean(4, "이순신", "sslee@email.com", "두번째 게시글", "두번째 게시글입니다.", "2022-11-03"));
	boardList.add(new BoardBean(5, "강감찬", "kckang@email.com", "번개모임", "안녕하세요 오늘 번개모임있습니다.", "2022-11-05"));
	
	request.setAttribute("boardList", boardList);

	RequestDispatcher rd = request.getRequestDispatcher("11_boardListResult.jsp");
	rd.forward(request, response);
%>
</body>
</html>
