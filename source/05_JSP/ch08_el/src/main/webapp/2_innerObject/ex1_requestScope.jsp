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
	<form action="ex2_requestScone.jsp">
		<p>ID<input type="text" name="id"></p>
		<p>PW<input type="password" name="pw"></p>
		<p><input type="submit"></p>
	</form>
	<%
		request.setAttribute("requestAtt", "requestValue");
		//자바에서 request객체에 setAttribute한 내용을 jsp로 전달
		//request객체를 유지한 상태에서 페이지변경(forward)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_requestScone.jsp?id=aaa&pw=111");
		dispatcher.forward(request, response);
	%>
	<h2><%=request.getAttribute("requestAtt") %></h2>
	<h2>${requestScope.requestAtt}</h2>
	<h2>${requestAtt}</h2>
</body>
</html>