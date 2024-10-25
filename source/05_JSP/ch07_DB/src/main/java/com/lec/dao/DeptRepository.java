package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Dept;

public class DeptRepository {
	private static DeptRepository INSTANCE  = new DeptRepository();
	public static DeptRepository getInstance() {
		return INSTANCE;
	}
	private DeptRepository() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public ArrayList<Dept> deptList(){
		ArrayList<Dept> deptdtos = new ArrayList<Dept>();
		String sql = "SELECT DEPTNO, DNAME FROM DEPT";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				deptdtos.add(new Dept(deptno, dname));				
			}
//			while(rs.next()) {
//				Dept dept = new Dept();
//				dept.setDeptno(rs.getInt("deptno"));
//				dept.setDname(rs.getString("dname"));
//				deptdtos.add(dept);
//			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return deptdtos;
	}
}
