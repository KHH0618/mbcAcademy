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
	<h3>변수 선언과 출려과 삭제</h3>
	<c:set var="varName" value="varValue"/> <!-- 변수선언. scope생략시 page scope -->
	varName : ${varName } <br>
	<c:set var="varName" value="XXX"/>
	varName : ${varName } <br>
	<!-- varName 변수 삭제 -->
	<c:remove var="varName"/>
	varName(삭제한 후 변수) : ${varName } <br>
	varName(삭제한 후 변수) : <c:out value="${varName }" default="삭제된 변수"/> <br>
	varName(삭제한 후 변수) : ${empty varName? "삭제된변수":varName } <br>
</body>
</html>