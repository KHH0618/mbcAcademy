package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;

import com.lec.dto.Emp;

public class EmpRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "dlow123";
	private String upw    = "tmvjswl";
	private static EmpRepository INSTANCE = new EmpRepository();
	
	public static EmpRepository getInstance() {
		return INSTANCE;
	}
	
	private EmpRepository() {
		try {
			Class.forName(driver);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Emp> empList(){
		ArrayList<Emp> empListDtos = new ArrayList<Emp>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr"); 
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					empListDtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return empListDtos;
	}
	
	public ArrayList<Emp> EmpListbyDeptno(String deptnoStr){
		ArrayList<Emp> empListDtos = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.*, DNAME"
				+ " FROM EMP E, DEPT D"
				+ " WHERE E.DEPTNO = D.DEPTNO"
				+ " AND E.DEPTNO LIKE '%' || ? ";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptnoStr);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr"); 
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					empListDtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return empListDtos;
	}
	public ArrayList<Emp> EmpListbySchEname(String SchEname){
		ArrayList<Emp> empListDtos = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.*, DNAME" +
					    " FROM EMP E, DEPT D" +
					    " WHERE E.DEPTNO = D.DEPTNO" +
					        " AND E.ENAME LIKE '%'||UPPER(TRIM(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, SchEname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr"); 
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					empListDtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return empListDtos;
	}
}
