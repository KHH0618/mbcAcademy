<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String conPath = request.getContextPath(); //톰캣에 실행되는 프로젝트 이름
 %>
 <%
 	String writer = request.getParameter("writer");
 	String memo = request.getParameter("memo");
 	String ip = request.getRemoteAddr();
 	Date today = new Date(System.currentTimeMillis()); //요청한 날짜
 	Timestamp todayTime = new Timestamp(System.currentTimeMillis()); //요청한 날짜와 시간
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h3>글쓴이 : <%= writer %></h3>
	<h3>한줄메모 : <%= memo %></h3>
	<h3>글쓴이 아이피 : <%= ip %></h3>
	<h3>글쓴날짜 : <%= today %></h3>
	<h3>글쓴시점 : <%= todayTime %></h3>
</body>
</html>