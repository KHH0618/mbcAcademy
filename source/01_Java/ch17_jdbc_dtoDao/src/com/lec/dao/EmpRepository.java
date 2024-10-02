package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lec.dto.Emp;

public class EmpRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dlow123";
	private String password = "tmvjswl";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private static EmpRepository INSTANCE = new EmpRepository();
	private EmpRepository () {}
	public static EmpRepository getINSTANCE () {
		return INSTANCE;
	}
	
	//(1) 사원정보들 가져오는 함수 : getEmpList
	public ArrayList<Emp> getEmpList (){
		ArrayList<Emp> emps = new ArrayList<Emp> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int emepno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emps.add(new Emp(emepno,ename,job,mgr,hiredate,sal,comm,deptno));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return emps;
	}
	//(2) deptno로 사원정보 가져오는 함수 : getEmpList
	public ArrayList<Emp> getEmpList (int deptno){
		ArrayList<Emp> emps = new ArrayList<Emp> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int emepno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				emps.add(new Emp(emepno,ename,job,mgr,hiredate,sal,comm,deptno));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return emps;
	}
	//(3) dname으로 사원정보 가져오는 함수 : getEmpList
	public ArrayList<Emp> getEmpList (String dname){
		ArrayList<Emp> emps = new ArrayList<Emp> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.* \r\n"
				+ "    FROM EMP E, DEPT D\r\n"
				+ "    WHERE E.DEPTNO = D.DEPTNO\r\n"
				+ "        AND DNAME = UPPER(?);";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int emepno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emps.add(new Emp(emepno,ename,job,mgr,hiredate,sal,comm,deptno));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return emps;
	}
	
	
	
}
