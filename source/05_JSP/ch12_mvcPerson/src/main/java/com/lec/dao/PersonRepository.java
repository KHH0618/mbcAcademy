package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Person;

public class PersonRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getInstance() {
		return INSTANCE;
	}
	private PersonRepository() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//1.LIST : public ArrayList<Person> getPersonList()
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> personList = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSON";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String tel = rs.getString("tel");
					String address = rs.getString("address");
					Date   birth = rs.getDate("birth");
					String memo = rs.getString("memo");
					Date rdate = rs.getDate("rdate");
					personList.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				close(rs, pstmt, conn);
		}
		return personList;
	}
	//LIST(paging 추가) : public ArrayList<Person> getPersonList(int startRow, int endRow) : 몇등 ~ 몇등
	public ArrayList<Person> getPersonList(int startRow, int endRow){
		ArrayList<Person> personList = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * "
				+ "  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A)"
				+ "  WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				Date   birth = rs.getDate("birth");
				String memo = rs.getString("memo");
				Date rdate = rs.getDate("rdate");
				personList.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		return personList;
	}
	//getCount (paging 처리시 필요한 전체 갯수)
	public int getCount() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM PERSON";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		return cnt;
	}
	//3. 추가 : public int insertPerson(Person person)
	public int insertPerson(Person person) {
		int reslut = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO PERSON(ID, NAME, TEL, ADDRESS, BIRTH, MEMO)"
				+ "    VALUES(PERSON_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddress());
			pstmt.setDate(4, person.getBirth());
			pstmt.setString(5, person.getMemo());
			reslut = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		return reslut;
	}
	//4. 한명출력 : public Person getPerson(int id)
	public Person getPerson(int schId) {
		Person schPerson = new Person();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *"
				+ "    FROM PERSON"
				+ "    WHERE ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				String birthStr = rs.getString("birth");
				String memo = rs.getString("memo");
				Date rdate = rs.getDate("rdate");
				Date birth = null;
				if(birthStr != null &&!birthStr.equals("")) {
					birth = Date.valueOf(birthStr);
				}
				schPerson = new Person(id, name, tel, address, birth, memo, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		return schPerson;
	}
	//5. 수정 : public int updatePerson(Person person)
	public int updatePerson(Person person) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE PERSON"
				+ "    SET ID = ?, NAME=?,TEL = ?, ADDRESS=?, BIRTH=?, MEMO=?"
				+ "    WHERE ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			pstmt.setInt(7, person.getId());
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getTel());
			pstmt.setString(4, person.getAddress());
			pstmt.setDate(5, person.getBirth());
			pstmt.setString(6, person.getMemo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	//6. 삭제 : public int deletePerson(int id)
	public int deletePerson(int id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "DELETE PERSON"
				+ "    WHERE ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
}
