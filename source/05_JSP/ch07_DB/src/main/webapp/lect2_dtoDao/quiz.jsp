<%@page import="com.lec.dto.Dept"%>
<%@page import="com.lec.dao.DeptRepository"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
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
<style type="text/css">
	select, input {
		text-align: center; 
		padding:5px;
		width: 100%;
		height: 100%;
		background-color: #FFE271;
		border: none;
	}
</style>
<script>
	window.onload = () => {
		document.querySelector('input[name="dname"]').onkeyup = function(){
			if(this.value.trim() != ""){
					console.log(1);
					document.querySelector('form').submit();
			};
		};
	};
</script>
</head>
<body>

<form method="post" action="">
	<table>
		<tr>
			<td>사원명</td>
			<% 
				String schEname = request.getParameter("dname"); 
				if(schEname==null){
					schEname = "";
				}
			%>
			<td colspan=6><input type="text" name="dname" id="dname" value="<%=schEname.replaceAll(" ","").toUpperCase()%>" ></td>
			<td><input type="submit" value="검색"></td>
		</tr>
		<tr>
			<th>사번</th>
			<th>이름</th> 
			<th>직책</th> 
			<th>상사사번</th> 
			<th>입사일</th>
			<th>급여</th> 
			<th>부서번호</th> 
			<th>부서명</th> 
		</tr>
		<%
			EmpRepository empRepository = EmpRepository.getInstance();
			ArrayList<Emp> empList = empRepository.EmpListbySchEname(schEname);
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
					int dno = emp.getDeptno();
					String dname = emp.getDname();
					out.print("<tr><td>"+empno + "</td> <td>" + ename + "</td> <td>"+job + "</td> <td>"
								+ (mgr == 0 ? "CEO" : mgr) + "</td> <td>"+hiredate 
								+ "</td> <td> $"+sal + "</td> <td>" + dno +  "</td> <td>"+ dname +"</td> </tr>");   
				}
			}
		%>
	</table>
</form>
</body>
</html>