package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//부서명을 입력받아 해당 부서정보를 출력하고, 해당부서 사원(사번, 이름, 급여 급여순출력)
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int deptno;
		String dept_query = "SELECT * FROM DEPT WHERE DNAME = UPPER(?)";
		String emp_query = "SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO = ? ORDER BY SAL";
		
		try {
			conn = DriverManager.getConnection(url, "dlow123","tmvjswl");
			pstmt = conn.prepareStatement(dept_query);
			System.out.print("부서명을 입력하세요 > ");
			pstmt.setString(1, scanner.next());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서지역 : " + rs.getString("loc"));
				deptno = rs.getInt("deptno");
				pstmt = conn.prepareStatement(emp_query);
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					System.out.println("사번\t이름\t급여");
					do {
						System.out.println(rs.getString("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));						
					}while(rs.next());
				} else {
					System.out.println("현제 부서에 사원이 존재하지 않습니다.");
				}
				
			} else {
				System.out.println("현제 검색한 부서는 없는 부서입니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
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
				scanner.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
