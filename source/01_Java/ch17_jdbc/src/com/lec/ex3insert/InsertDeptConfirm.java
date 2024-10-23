package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력할 부서번호는 > ");
		int deptno = scanner.nextInt();
		String query ="SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;
		try {
			conn = DriverManager.getConnection(url, "dlow123", "tmvjswl");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			if(rs.getInt("cnt") == 0) {
				System.out.print("입력할 부서명은 > ");
				String dname = scanner.next();
				System.out.print("입력할 부서지역은 > ");
				String loc = scanner.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno,dname,loc);
				int result = stmt.executeUpdate(sql);
				System.out.println(result+"행 입력되었습니다");
			} else {
				System.out.println("입력하신 부서번호는 이미 사용중인 부서번호입니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
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
