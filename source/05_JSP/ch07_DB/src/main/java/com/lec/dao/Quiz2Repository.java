package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Quiz2;

public class Quiz2Repository {

	private Quiz2Repository() {}
	public static final int SUCCESS = 1;
	private static final int FAL = 0;
	private static Quiz2Repository INSTANCE = new Quiz2Repository();
	public static Quiz2Repository getInstance() {
		return INSTANCE;
	}
	private Connection getConnection() throws SQLException{
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
	
	public ArrayList<Quiz2> getFriendList(){
		ArrayList<Quiz2> friends = new ArrayList<Quiz2>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				do {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String tel = rs.getString("tel");
					friends.add(new Quiz2(no, name, tel));
				}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return friends;
	}
	
	public int addFriendList(String name, String tel) {
		int result = FAL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND VALUES(FRIEND_SEQ.NEXTVAL, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "친구추가 성공":"친구추가 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 친구추가 실패 (이름이나 전번 잘못입력)");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
}
