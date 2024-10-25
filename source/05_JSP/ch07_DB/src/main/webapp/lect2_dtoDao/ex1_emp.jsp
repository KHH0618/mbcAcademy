<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
<%@page import="com.lec.dao.DeptRepository"%>
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
	<table>
		<%
			out.print("<tr><td>사번</td> <td>이름</td> <td>직책</td> <td>상사사번</td> <td>입사일</td> <td>급여</td> <td>상여금</td> <td>부서번호</td> </tr>");
			EmpRepository empRepository = EmpRepository.getInstance();
			ArrayList<Emp> empList = empRepository.empList();
			if(empList.isEmpty()){
				out.print("<tr><td>입력된 사원정보가 없습니다</tr></td>");
			}else{
				for(Emp emp : empList){
					out.print("<tr><td>" + emp.getEmpno() + "</td>");
					out.print("<td>" + emp.getEname() + "</td>");
					out.print("<td>" + emp.getJob() + "</td>");
					out.print("<td>" + emp.getMgr() + "</td>");
					out.print("<td>" + emp.getHiredate() + "</td>");
					out.print("<td>" + emp.getSal() + "</td>");
					out.print("<td>" + emp.getComm() + "</td>");
					out.print("<td>" + emp.getDeptno() + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>