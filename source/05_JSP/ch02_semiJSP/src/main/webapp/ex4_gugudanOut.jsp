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
	//String suStr = request.getParameter("dansu");
	//int dansu = Integer.parseInt(suStr);
	int dansu = Integer.parseInt(request.getParameter("dansu"));
	%>
	<h2><%=dansu %>단 구구단</h2>
	<%for(int i = 1; i <= 9; i++){%>
		<p><%=dansu %> * <%=i %> = <%= dansu*i %></p>
	<%}%>
</body>
</html>