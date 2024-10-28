<%@page import="com.lec.dto.Friend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String conPath = request.getContextPath(); //톰캣에 실행되는 프로젝트 이름
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		//mvc 패턴에서는 자바에서 구현될 소스는 자바에서 구현
		Friend friend = new Friend(1, "홍길동", "010-9999-9999");
		request.setAttribute("friend", friend);
	%>	
	<h2>친구정보 (el표기법)</h2>
	<h2>friend : ${friend }</h2>
	<h2>순번 : ${friend.no }</h2>
	<h2>이름 : ${friend.name }</h2>
	<h2>전화 : ${friend.tel }</h2>
</body>
</html>