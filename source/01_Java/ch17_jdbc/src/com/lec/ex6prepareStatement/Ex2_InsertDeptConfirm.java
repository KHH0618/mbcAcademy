package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex2_InsertDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO DEPT VALUES (?,UPPER(?), UPPER(?))";
		System.out.print("입력할 부서번호는 > ");
		int deptno = scanner.nextInt();
		String query = "SELECT * FROM DEPT WHERE DEPTNO ="+deptno;
		
		try {
			conn = DriverManager.getConnection(url, "dlow123","tmvjswl");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptno);
				System.out.print("입력할 부서명은 > ");
				pstmt.setString(2, scanner.next());
				System.out.print("입력할 부서지역은 > ");
				pstmt.setString(3, scanner.next());
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "입력성공" : "입력실패");
			} else {
				System.out.println("이미 존재하는 부서번호입니다");
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
