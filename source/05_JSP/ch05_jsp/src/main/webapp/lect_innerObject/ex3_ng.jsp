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
	<%int age = Integer.parseInt(request.getParameter("age")); %>
	<h3><%=age %>살 미성년자니 주류 구매 불가합니다</h3>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='ex3_ageInput.jsp'">새로입력</button>
</body>
</html>