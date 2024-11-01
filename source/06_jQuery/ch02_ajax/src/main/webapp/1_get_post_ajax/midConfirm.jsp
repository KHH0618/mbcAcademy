<%@page import="com.lec.dao.MemberRepository"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<%
		String id = request.getParameter("id");
		MemberRepository repository = MemberRepository.getInstace();
		int cnt = repository.getCountMember(id);
		if(cnt==MemberRepository.MEMBER_EXISTENT){
			out.print("<b>중복된 ID입니다</b>");
		}else{
			out.print("사용가능한 ID입니다");
		}
	%>
</body>
</html>