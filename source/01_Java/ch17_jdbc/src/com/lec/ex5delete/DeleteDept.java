package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.print("삭제할 부서 번호는 > ");
		int deptno = scanner.nextInt();
		String query = "SELECT * FROM DEPT WHERE DEPTNO ="+deptno;
		String sql = "DELETE FROM DEPT WHERE DEPTNO ="+deptno;
		
		try {
			conn = DriverManager.getConnection(url, "dlow123", "tmvjswl");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				int result = stmt.executeUpdate(sql);
				if (result >0) {
					System.out.println("삭제완료되었습니다.");
				}
			} else {
				System.out.println("해당부서는 존재하지 않습니다");
			}
		} catch (Exception e) {
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
				scanner.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
	}

}
