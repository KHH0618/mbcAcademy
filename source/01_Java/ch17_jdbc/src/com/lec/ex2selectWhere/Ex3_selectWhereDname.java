package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//부서이름을 입력받아 해당 부서 정보 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("원하는 부서 이름을 작성하세요");
		String dname = scanner.next();
		String query = "SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('"+dname+"')";
		
		try {
			conn = DriverManager.getConnection(url, "dlow123", "tmvjswl");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println("해당 부서 이름은 : " + dname);
				System.out.println("해당 부서 번호는 : " + rs.getInt("deptno"));
				System.out.println("해당 부서 이름은 : " + rs.getString("loc"));
			} else {
				System.out.println("해당 부서가 존재하지 않습니다.");
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
