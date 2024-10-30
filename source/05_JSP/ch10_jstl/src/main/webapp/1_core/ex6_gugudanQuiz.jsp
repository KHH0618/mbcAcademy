<%@page import="org.apache.naming.java.javaURLContextFactory"%>
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
	<c:set var="random1" value="<%=java.lang.Math.round(java.lang.Math.random() * 9 + 1) %>"/>
	<c:set var="random2" value="<%=java.lang.Math.round(java.lang.Math.random() * 9 + 1) %>"/>
	<form mathod="post" action="ex6_gugudanResult.jsp">
	<p>
		<input type="text" name="first" value="${random1 }" readonly="readonly" size="1">
		*
		<input type="text" name="secund" value="${random2 }" readonly="readonly" size="1">
		=
		<input type="number" name="result" placeholder="정답입력">
	</p>
	<p>
		<input type="submit" value="확인">
	</p>
	</form>
</body>
</html>