<%@page import="com.lec.dto.Quiz2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.Quiz2Repository"%>
<%@page import="com.lec.dto.Quiz2"%>
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
	<form action="friendInputPro.jsp" method="post">
		<p>
			친구이름 
			<input type="text" name="name" required="required" size="5">
			전화
			<input type="tel" name="tel" size="10">
			<input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		<%
			Quiz2Repository repository = Quiz2Repository.getInstance();
			ArrayList<Quiz2> friendList = repository.getFriendList();
			for (Quiz2 friend : friendList){
				String tel = friend.getFriendTel();
				out.println("<tr>");
				out.println("<td>" + friend.getNo() + "</th>");
				out.println("<td>" + friend.getFriendName() + "</th>");
				out.println("<td>" + (tel==null? "":tel) + "</th>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>