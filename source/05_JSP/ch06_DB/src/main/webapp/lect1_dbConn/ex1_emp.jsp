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
		String upw    = "tiger";
	%>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			out.print("<h2>DB연결성공</h2>");
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
</body>
</html>