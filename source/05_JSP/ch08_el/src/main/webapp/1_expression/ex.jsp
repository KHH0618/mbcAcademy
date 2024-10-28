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
	<h2>표현식 태그</h2>
	<p>산술연산 : <%=10+1 %></p>
	<p>산술연산 : <%=10/0.0 %></p>
	<p>관계연산 1 == 2 ? : <%=1==2 %></p>
	<p>관계연산 1 != 2 ? : <%=1!=2 %></p>
	<p>조건연산 <%=(1>2)? "1이 더 큽니다" : "2가 더 큽니다" %></p>
	<p>name 파라미터값 : <%= request.getParameter("name") %></p>
	<p>name 파라미터 여부 : <%= request.getParameter("name") == null ? "안받음":"받음" %></p>
	<%-- <p>name 파라미터 대문자로 : <%= request.getParameter("name").toUpperCase() %></p> --%>
	<h2>el표기법(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<p>산술연산 : ${10 + 1}</p>
	<p>산술연산 : ${10/0}</p>
	<p>관계연산 1 == 2 ? : ${1 == 2} or ${ 1 eq 2 } </p>
	<p>관계연산 1 == 2 ? : ${1 != 2} or ${ not(1 eq 2) }</p>
	<p>조건연산 ${(1>2)? "1이 더 큽니다" : "2가 더 큽니다"}</p>
	<p>name 파라미터값 : ${param.name}</p>
	<p>name 파라미터 여부 : ${empty param.name? "안받음":"받음"}</p>
	<p>name 파라미터 대문자로 : ${param.name.toUpperCase()}</p>
</body>
</html>