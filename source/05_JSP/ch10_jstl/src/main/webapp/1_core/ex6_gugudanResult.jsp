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
	<c:set var="first" value="${param.first}"/>
	<c:set var="secund" value="${param.secund}"/>
	<c:set var="result" value="${param.result}"/>
	<c:if test="${empty result}"></c:if>
	<c:if test="${first * secund eq result}"><h2>${first } * ${secund } = ${result }은 정답</h2></c:if>
	<c:if test="${not empty result && first * secund != result}"><h2>${first } * ${secund } = ${result }은 오답</h2></c:if>
	<p><button onclick="location.href='ex6_gugudanQuiz.jsp'">다시하기</button></p>
</body>
</html>