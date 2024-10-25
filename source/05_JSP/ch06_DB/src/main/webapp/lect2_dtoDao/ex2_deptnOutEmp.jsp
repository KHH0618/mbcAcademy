<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
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
	<table>
		<%
			String deptnoStr = request.getParameter("deptno");
			EmpRepository empRepository = EmpRepository.getInstance();
			ArrayList<Emp> empList = empRepository.EmpListbyDeptno(deptnoStr);
			out.print("<tr><th>사번</th> <th>이름</th> <th>직책</th> <th>상사사번</th> <th>입사일</th>" 
					    + "<th>급여</th> <th>상여금</th> <th>부서번호</th> </tr>");
			if(empList.isEmpty()){
				out.print("<tr><td colspan=8>해당부서 사원이 없습니다</td></tr>");
			}else{
				for(Emp emp : empList){				
					int empno = emp.getEmpno();
					String ename = emp.getEname();
					String job = emp.getJob();
					int mgr = emp.getMgr(); 
					Date hiredate = emp.getHiredate(); // 날짜만 받음 (시간을 받으려면 Timestamp)
					int sal = emp.getSal(); // DB에 null이면 0으로 출력
					int comm = emp.getComm();
					int dno = emp.getDeptno();
					out.print("<tr><td>"+empno + "</td> <td>"+ename + "</td> <td>"+job + "</td> <td>"
								+ (mgr == 0 ? "CEO" : mgr) + "</td> <td>"+hiredate 
								+ "</td> <td> $"+sal + "</td> <td> $" + comm + "</td> <td>" + dno +  "</td> </tr>");   
				}
			}
		%>
	</table>
</body>
</html>