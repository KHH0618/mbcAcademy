<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	int pw = Integer.parseInt(request.getParameter("pw"));
	%>
	<p>아이디는 <%=id %> 이고</p>
	<p>패스워드는 <%=pw %> 입니다</p>
	<p><%=name %>님 반갑습니다.</p>
</body>
</html>