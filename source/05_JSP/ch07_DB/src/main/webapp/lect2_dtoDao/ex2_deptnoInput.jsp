<%@page import="com.lec.dto.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptRepository"%>
<%@page import="java.sql.*"%>
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
	<form action="ex2_deptnOutEmp.jsp">
		<p>
			<select name = "deptno">
				<%
					DeptRepository deptRepository = DeptRepository.getInstance();
					ArrayList<Dept> deptList = deptRepository.deptList();
					for(Dept dept : deptList){
						int deptno = dept.getDeptno();
						String dname = dept.getDname();
						out.print("<option value='" + deptno + "'>"+ deptno + "-" + dname +"</option>");						
					}
				%>
			</select>
			<input type="submit" value="검색">
		</p>
	</form>
</body>
</html>