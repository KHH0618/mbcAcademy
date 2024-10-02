package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;

import com.lec.dto.Person;

public class PersonRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dlow123";
	private String password = "tmvjswl";
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getINSTANCE() {
		return INSTANCE;
	}
	
	// -----------------------------------------------------------------
	
	public ArrayList<String> jnameList (){
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
	
//-----------------------------------
	
	@SuppressWarnings("resource")
	public int insertPerson(String pname, String jname, int kor, int eng, int mat){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int jno;
		String jobsql = "SELECT * FROM JOB WHERE jNAME = ?";
		String personsql = "INSERT INTO PERSON(pNO,pNAME,jNO,KOR,ENG,MAT)\r\n"
				+ "    VALUES (TRIM(PERSON_SEQ.NEXTVAL),?,?,?,?,?)";
		int i = 0;
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(jobsql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				jno = rs.getInt("jno");
				pstmt = conn.prepareStatement(personsql);
				pstmt.setString(1, pname);
				pstmt.setInt(2, jno);
				pstmt.setInt(3, kor);
				pstmt.setInt(4, eng);
				pstmt.setInt(5, mat);
				i = pstmt.executeUpdate();
				
				if(i == 1) {
					System.out.println("삽입되었습니다");
				}else {
					System.out.println("삽입 실패하였습니다.");
				}
				
			}else {
				System.out.println("존재하지 않는 직업명입니다.");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return i;
	}
	
// ------------------------------------------------------------------------------------	
	
	@SuppressWarnings("resource")
	public ArrayList<Person> getPerson (String jname){
		ArrayList<Person> personList = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String jobsql = "SELECT * FROM JOB WHERE jNAME = ?";
		String sql = "SELECT ROWNUM||'등' \"RANK\", P.*\r\n"
				+ "    FROM (SELECT P.PNAME||'('||P.PNO||'번'||')' \"PNAME\",J.JNAME \"JNAME\",P.KOR,P.ENG,P.MAT,P.KOR+P.ENG+P.MAT \"TOTAL\" \r\n"
				+ "            FROM PERSON P ,JOB J\r\n"
				+ "            WHERE P.JNO = J.JNO\r\n"
				+ "                AND JNAME = ?\r\n"
				+ "            ORDER BY TOTAL DESC ) P";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			pstmt = conn.prepareStatement(jobsql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jname);
				rs = pstmt.executeQuery();
				do {
					String rank = rs.getString("rank");
					String pname = rs.getString("pname");
					jname = rs.getString("jname");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");
					int total = rs.getInt("total");
					
					Person person = new Person(rank, pname, jname, kor, eng, mat, total);
					personList.add(person);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return personList;
	}
	
	
	// --------------------------------------------------------------------------------------
	
	public ArrayList<Person> getPerson (){
		ArrayList<Person> personList = new ArrayList<Person>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' \"RANK\", P.*\r\n"
				+ "    FROM (SELECT P.PNAME||'('||P.PNO||')' \"PNAME\",J.JNAME \"JNAME\",P.KOR,P.ENG,P.MAT,P.KOR+P.ENG+P.MAT \"TOTAL\" \r\n"
				+ "            FROM PERSON P ,JOB J\r\n"
				+ "            WHERE P.JNO = J.JNO\r\n"
				+ "            ORDER BY TOTAL DESC ) P";
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				
				Person person = new Person(rank, pname, jname, kor, eng, mat, total);
				personList.add(person);
			}
			
		} catch (SQLException e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return personList;
	}
}
