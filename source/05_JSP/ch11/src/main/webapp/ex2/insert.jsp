<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/><!-- 톰캣에 실행되는 프로젝트 이름 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>insert.jsp파일입니다</h1>
	<h3>insert결과 : ${insertResult eq 1 ? "insert성공":"insert실패" }</h3>
	<button onclick="location.href='${conPath}/select.do'">목록가기</button>
</body>
</html>