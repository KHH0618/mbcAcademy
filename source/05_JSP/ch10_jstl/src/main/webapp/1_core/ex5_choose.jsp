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
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:choose>
		<c:when test="${visitNum ==1 }"><h3>첫 방문 감사합니다</h3></c:when>
		<c:when test="${visitNum >1 and visitNum <= 5 }"><h3>자주 방문해 주세요</h3></c:when>
		<c:when test="${visitNum > 5 }"><h3>많이 방문해 주셔서 감사합니다</h3></c:when>
		<c:when test="${empty visitNum }">visitNum 파라미터값을 못받았습니다</c:when>
	</c:choose>
</body>
</html>