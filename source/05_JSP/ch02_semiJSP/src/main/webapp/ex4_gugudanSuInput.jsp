<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{text-align:center;}
</style>
</head>
<body>
	<%--
	get 방식 전송 : 파라미터 데이터가 url 문자열로 전송. 보안에 취약. 길이 제한(2048자 이상 불가)
		검색에 주로
	post방식 전송 : 파라미터 데이터가 본문에 전송. 길이 제한x
		입력, 수정에 주로
	 --%>
	<%-- JSP주석 --%>
	<!-- html 주석 -->
	<% 
	//자바주석
	/*
		자바주석
	*/
	%>
	<form action="ex4_gugudanOut.jsp" method="post">
		<p><input type="number" name="dansu"></p>
		<p><input type="submit" value="구구단 출력!"></p>
	</form>
</body>
</html>