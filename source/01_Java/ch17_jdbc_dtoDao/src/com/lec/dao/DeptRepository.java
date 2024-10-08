package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;
import com.lec.dto.Dept;

public class DeptRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dlow123";
	private String password = "tmvjswl";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;	
	private static DeptRepository INSTANCE = new DeptRepository();
	public static DeptRepository getINSTANCE () {
		return INSTANCE;
	}
	
	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//(1) 부서정보들 가져오는 함수 : getDeptList
	public ArrayList<Dept> getDeptList (){
		ArrayList<Dept> dtos = new ArrayList<Dept>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dtos.add(new Dept(deptno, dname, loc));
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
		return dtos;
	}
	
	//(2) deptno로 부서정보 가져오는 함수 : getDept
	public Dept getDept(int deptno){
		Dept dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new Dept(deptno, rs.getString("dname"), rs.getString("loc"));				
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
		
		return dto;
	}
	
	//(3) dname으로 부서정보 가져오는 함수 : getDept
	public Dept getDept(String dname){
		Dept dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER(?)";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));				
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
		
		return dto;
	}
	//(4) insertDept
	public int insertDept (int deptno, String dname, String loc) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES (?,UPPER(?),UPPER(?))";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
			
			System.out.println(result==SUCCESS ? "입력성공" : "입력실패");
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + deptno + dname + loc);
		}finally {
			try {
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
		
		return result;
	}
	
	//(5) updateDept
	public int updateDept (int deptno, String dname, String loc) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DEPT "
				+ "    SET DNAME = UPPER(?), "
				+ "        LOC = UPPER(?) "
				+ "    WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			result = pstmt.executeUpdate();
			
			System.out.println(result==SUCCESS ? "수정성공" : "부서번호가 유효하지 않아 수정실패");
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + deptno + dname + loc);
		}finally {
			try {
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
		
		return result;
	}
	
	
	//(6) deleteDept
	public int deleteDept (int deptno) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE DEPT WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			
			System.out.println(result==SUCCESS ? deptno + "번 부서 삭제했습니다" : deptno + "번 부서번호가 유효하지 않아 삭제실패");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
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
		
		return result;
	}
	
}
