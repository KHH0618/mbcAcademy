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
	<form action="ex4.jsp">
		name <input type="text" name="name"><br>
		<input type="checkbox" name="pets" value="고양이">고양이
		<input type="checkbox" name="pets" value="앵무새">앵무새
		<input type="checkbox" name="pets" value="강아지">강아지
		<input type="checkbox" name="pets" value="거북이">거북이<br>
		<input type="submit">
	</form>
</body>
</html>