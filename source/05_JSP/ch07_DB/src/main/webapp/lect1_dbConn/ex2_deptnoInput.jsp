<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid    = "dlow123";
	String upw    = "tmvjswl";
%>
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
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					String sql = "SELECT * FROM DEPT";
					try{
						Class.forName(driver);
						conn = DriverManager.getConnection(url, uid, upw);
						stmt = conn.createStatement();
						rs = stmt.executeQuery(sql);
						if(rs.next()){
							do{
								int deptno = rs.getInt("deptno");
								String dname = rs.getString("dname");
								out.print("<option value='" + deptno + "'>"+ deptno + "-" + dname +"</option>");
							}while(rs.next());
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
						try{
							if(rs!=null){
								rs.close();
							}
							if(stmt!=null){
								stmt.close();
							}
							if(conn!=null){
								conn.close();
							}
						}catch(Exception e){
							System.out.println(e.getMessage());
							
						}
					}
				%>
			</select>
			<input type="submit" value="검색">
		</p>
	</form>
</body>
</html>