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
	<h2>이름 : ${param.name }</h2>
	<h2>
	애완동물 : 
	${paramValues.pets[0] }
	${paramValues.pets[1] }
	${paramValues.pets[2] }
	${paramValues.pets[3] }
	</h2>
</body>
</html>