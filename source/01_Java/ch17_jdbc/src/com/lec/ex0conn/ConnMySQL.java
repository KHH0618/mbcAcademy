package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dev_user?serverTimezon=UTC";
		Connection conn = null;
		try {
			Class.forName(driver); //(1) 드라이버 로드
			System.out.println("드라이버로드성공");
			conn = DriverManager.getConnection(url, "root", "mysql");//(2)DB연결
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
