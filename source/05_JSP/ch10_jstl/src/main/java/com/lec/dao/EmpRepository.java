package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Emp;

public class EmpRepository {
	private EmpRepository() {}
	private static EmpRepository INSTANCE = new EmpRepository();
	public static EmpRepository getInstance() {
		return INSTANCE;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<Emp> getEmpList(){
		 ArrayList<Emp> empList = new  ArrayList<Emp>();
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT * FROM EMP";
		 try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					empList.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(rs != null) {
					rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			
		}
		 
		 return empList;
	}
	public ArrayList<Emp> getEmpList(String schName, String schJob){
		 ArrayList<Emp> empList = new  ArrayList<Emp>();
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT *"
		 		+ "    FROM EMP"
		 		+ "    WHERE ENAME LIKE '%'||UPPER(TRIM(?))||'%'"
		 		+ "        AND  JOB LIKE '%'||UPPER(TRIM(?))||'%'";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schJob);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					empList.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		 
		 return empList;
	}
}
