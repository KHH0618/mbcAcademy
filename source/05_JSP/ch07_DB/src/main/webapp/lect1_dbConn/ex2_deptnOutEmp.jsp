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
	<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String uid    = "dlow123";
		String upw    = "tmvjswl";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	%>
	<table>
		<%
			String sql = "SELECT E.*, DNAME "
						    +"FROM EMP E, DEPT D "
						    +"WHERE E.DEPTNO = D.DEPTNO "
						        +"AND E.DEPTNO LIKE '%' || ?";
		
			String deptno = request.getParameter("deptno");
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deptno);
				rs = pstmt.executeQuery();
				out.print("<tr><th>사번</th> <th>이름</th> <th>직책</th> <th>상사사번</th> <th>입사일</th> <th>급여</th> <th>상여금</th> <th>부서번호</th> </tr>");
				if(rs.next()){
					do{
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						String mgr = rs.getNString("mgr"); 
						Date hiredate = rs.getDate("hiredate"); // 날짜만 받음 (시간을 받으려면 Timestamp)
						int sal = rs.getInt("sal"); // DB에 null이면 0으로 출력
						int comm = rs.getInt("comm");
						int dno = rs.getInt("deptno");
						out.print("<tr><td>"+empno + "</td> <td>"+ename + "</td> <td>"+job + "</td> <td>"+ (mgr == null ? "CEO" : mgr) + "</td> <td>"+hiredate + "</td> <td> $"+sal + "</td> <td> $" + comm + "</td> <td>" + dno +  "</td> </tr>");
					}while(rs.next());
				}else{
					out.print("<tr><td colspan=8>해당부서 사원이 없습니다</td></tr>");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try{
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		%>
	</table>
</body>
</html>