<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% //스크립트릿은 자바 코드
		long result = power(7,9);
	%>
	<p>7의 9승은 <%=result %></p>
	<p>12의 7승은 <%=power(12,7) %></p>
	<%! //선언부는 먼저 최초 1회 실행
		private long power(int a, int b){
		long result = 1;
		for(int i = 1; i <= b; i++){
			result *= a;
		}
		return result;
	}
	%>
</body>
</html>