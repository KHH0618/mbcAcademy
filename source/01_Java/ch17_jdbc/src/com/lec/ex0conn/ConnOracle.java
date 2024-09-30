package com.lec.ex0conn;
import java.sql.Connection;
import java.sql.DriverManager;

//오라클 연동 : (1)드라이버 로드 (2)DB연결
public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver); //(1) 드라이버 로드
			System.out.println("드라이버로드성공");
			conn = DriverManager.getConnection(url, "dlow123", "tmvjswl");//(2)DB연결
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		} finally {
			try {
				if(conn != null) {
					conn.close();
					System.out.println("연결해제");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
