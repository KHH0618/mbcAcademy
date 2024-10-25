package com.lec.dao;

import java.util.ArrayList;
import com.lec.dto.Emp;

public class EmpRepositoryTest {

	public static void main(String[] args) {
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
