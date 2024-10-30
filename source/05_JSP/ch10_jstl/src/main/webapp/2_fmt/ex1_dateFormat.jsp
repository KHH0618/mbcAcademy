<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/><!-- 톰캣에 실행되는 프로젝트 이름 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="nowSQLDate" value="<%= new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%= new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowUtilDate" value="<%= new java.util.Date() %>"/>
	${nowSQLDate }<br>
	${nowTimes }<br>
	${nowUtilDate }<br>
	<h3>날짜만 출력</h3>
	short : <fmt:formatDate value="${nowSQLDate }" type="date" dateStyle="short"/> <br>
	medium : <fmt:formatDate value="${nowTimes }" type="date" dateStyle="medium"/> <br>
	long : <fmt:formatDate value="${nowTimes }" type="date" dateStyle="long"/> <br>
	full : <fmt:formatDate value="${nowUtilDate }" type="date" dateStyle="full"/> <br>
	<h3>시간만 출력</h3>
	short : <fmt:formatDate value="${nowSQLDate }" type="time" timeStyle="short"/> <br>
	medium : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="medium"/> <br>
	long : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="long"/> <br>
	full : <fmt:formatDate value="${nowUtilDate }" type="time" timeStyle="full"/> <br>
	<h3>날짜와 시간을 모두 출력</h3>
	<fmt:formatDate value="${nowSQLDate }" type="both" dateStyle="long" timeStyle="medium"/> <br>
	<fmt:formatDate value="${nowTimes }" type="both" pattern="YY-MM-dd(E요일) HH:mm:ss:SSS"/> <br>
	<fmt:formatDate value="${nowTimes }" type="both" pattern="YY-MM-dd(E요일) a hh:mm:ss:SSS"/> <br>
	
</body>
</html>