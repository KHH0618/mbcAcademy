package com.lec.dao;

import java.io.IOException;
import java.util.ArrayList;
import com.lec.dto.Emp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EmpDaoTest")
public class EmpRepositoryTest extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpRepository empList = EmpRepository.getInstance();
		ArrayList<Emp> emps = empList.empList();
		if(emps.isEmpty()) {
			System.out.println("데이터 없음 or 오류");
		}else {
			for(Emp emp : emps) {
				System.out.println(emp);
			}
		}
		emps = empList.EmpListbyDeptno("30");
		if(emps.isEmpty()) {
			System.out.println("데이터 없음 or 오류");
		}else {
			for(Emp emp : emps) {
				System.out.println(emp);
			}
		}
		emps = empList.EmpListbySchEname("");
		if(emps.isEmpty()) {
			System.out.println("데이터 없음 or 오류");
		}else {
			for(Emp emp : emps) {
				System.out.println(emp);
			}
		}
	}

}
