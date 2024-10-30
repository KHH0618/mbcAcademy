<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String conPath = request.getContextPath(); //톰캣에 실행되는 프로젝트 이름 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String[] names = {"홍길동","김길동","신길동"};
		for (String name : names){
			out.println("<p>"+name+"</p>");
		}
		for (int idx = 0; idx < names.length; idx++){
			out.println("<p>"+idx+"번째"+names[idx]+"</p>");
		}
		request.setAttribute("names", names); //자바측에서 뷰단에 출력할 내용을 setAttribute
	%>
	<hr>
	<h4>확장 for문 역할</h4>
	<c:forEach var="name" items="${names }"> <!-- items는 자바 확장 for문 일반for문에선 begin변수 초기화, end 까지, step 씩증가 -->
		<p>${name }</p>
	</c:forEach>
	<h4>일반 for문 역할</h4>
	<c:set var="idx" value="0"/>
	<c:forEach var="name" items="${names }">
		<p>${idx }번째 ${name }</p>
		<c:set var="idx" value="${idx + 1 }"/>
	</c:forEach>
	<h4>for문을 끝까지 수행하지 않고 특정 횟수만 실행</h4>
	<c:forEach var="name" items="${names }" begin="0" end="1">
		<p>${name }</p>
	</c:forEach>
	<h4>5번 반복하는 for문</h4>
	<c:forEach begin="0" end="4">
		<p>안녕하세요</p>
	</c:forEach>
</body>
</html>