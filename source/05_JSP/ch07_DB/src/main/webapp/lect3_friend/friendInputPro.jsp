<%@page import="com.lec.dao.Quiz2Repository"%>
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
	<%
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Quiz2Repository dao = Quiz2Repository.getInstance();
		int result = dao.addFriendList(name, tel);
		if(result == Quiz2Repository.SUCCESS){
		%>	
		<script>
		alert('친구추가 성공');
		location.href = 'friendInputList.jsp';
		</script>
		<%}else{%>
		<script>
		alert('친구추가 실패');	
		history.back();
		</script>
		<%}%>
</body>
</html>