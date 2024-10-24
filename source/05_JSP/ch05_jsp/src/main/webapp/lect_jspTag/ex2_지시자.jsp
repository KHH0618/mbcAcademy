<%@page import="java.util.Arrays"%>
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
	<%-- 지시자 : page속성, include, taglib(9장에서) --%>
	<%
		int[] arr = {1,2,3};
		out.print(Arrays.toString(arr));
	%>
	<hr>
	<!-- jsp 표준 액션 태그에ㅐ서의 include : jsp를 실행한 결과 html을 include -->
	<jsp:include page="../main/footer.jsp"/><!-- JSP표준 액션 태그 -->
	<!-- 지시자의 include : jsp를 include -->
	<%-- <%@ include file="../main/footer.jsp" %> --%>
	<hr>
	다시 ex2_지시자로 옴 - 끝 -
</body>
</html>