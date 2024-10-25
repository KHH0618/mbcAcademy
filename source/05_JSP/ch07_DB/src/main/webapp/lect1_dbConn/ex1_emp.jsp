<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
	%>
	<table>
		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM EMP";
			try{
				Class.forName(driver); // 1단계 : 드라이버 로드
				conn = DriverManager.getConnection(url, uid, upw); // 2단계 : DB연결
				stmt = conn.createStatement(); // 3단계 : SQL전송 객체
				rs = stmt.executeQuery(sql);
				out.print("<h2>DB연결성공</h2>");
				if(rs.next()){ // sql문 전송 결과가 1행 이상 있을때
					out.print("<tr><td>사번</td> <td>이름</td> <td>직책</td> <td>상사사번</td> <td>입사일</td> <td>급여</td> <td>상여금</td> <td>부서번호</td> </tr>");
					do{
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int mgr = rs.getInt("mgr"); 
						Date hiredate = rs.getDate("hiredate"); // 날짜만 받음 (시간을 받으려면 Timestamp)
						int sal = rs.getInt("sal"); // DB에 null이면 0으로 출력
						int comm = rs.getInt("comm");
						int deptno = rs.getInt("deptno");
						out.print("<tr><td>"+empno + "</td> <td>"+ename + "</td> <td>"+job + "</td> <td>"+ (mgr == 0 ? "CEO" : mgr) + "</td> <td>"+hiredate + "</td> <td> $"+sal + "</td> <td> $" + comm + "</td> <td>" + deptno +  "</td> </tr>");
					}while(rs.next());
				}else{
					out.print("<tr><td>입력된 사원정보가 없습니다</tr></td>");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try{
					if(conn!=null){
						conn.close();
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		%>
	</table>
</body>
</html>