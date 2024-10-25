package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;

import com.lec.dto.Dept;

public class DeptRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "dlow123";
	private String upw    = "tmvjswl";
	private static DeptRepository INSTANCE  = new DeptRepository();
	public static DeptRepository getInstance() {
		return INSTANCE;
	}
	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Dept> deptList(){
		ArrayList<Dept> deptdtos = new ArrayList<Dept>();
		String sql = "SELECT DEPTNO, DNAME FROM DEPT";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
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
