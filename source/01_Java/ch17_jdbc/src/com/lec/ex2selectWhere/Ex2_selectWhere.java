package com.lec.ex2selectWhere;
//1.사용자에게 원하는 부서번호를 입력받아
// 1.1 해당 부서번호가 존재하는 경우 : 부서정보 출력
//		사원정보(사번, 이름, 급여, 상사명) 출력, 사원이 존재하지 않는경우 사원이 없다고 출력
// 1.2 해당 부서번호가 존재하지 않을 경우 : 존재하지 않는 부서라고 출력

import java.sql.*;
import java.util.Scanner;

public class Ex2_selectWhere {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("출력을 원하는 부서번호는 ?");
		int deptno = scanner.nextInt();
		scanner.close();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String query2 = "SELECT W.EMPNO WORKEREMPNO, W.ENAME WORKER, W.SAL WORKERSAL, NVL(M.ENAME,'CEO') MANAGER"
				+ "    FROM EMP W, EMP M"
				+ "    WHERE W.MGR = M.EMPNO(+)"
				+ "        AND W.DEPTNO ="+ deptno;
		
		try {
			conn = DriverManager.getConnection(url, "dlow123", "tmvjswl");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if(rs.next()) {
				System.out.println("원하는 부서 번호 : " + deptno);
				System.out.println("원하는 부서 이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서 지역 : " + rs.getString("loc"));
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t상사명");
					do {
						System.out.println(rs.getInt("WORKEREMPNO")+"\t"
											+rs.getString("worker")+"\t"
											+rs.getInt("workersal")+"\t"
											+rs.getString("manager"));
					}while(rs.next());
				}else {
					System.out.println("해당부서에 사원이 존재하지 않습니다");
				}
			}else {
				System.out.println("해당부서가 존재하지 않습니다");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
