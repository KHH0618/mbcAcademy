package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

//부서번호를 입력받아 중복체크후 부서명, 부서위치 받아 insert
public class Ex3_InsertDeptConfirm {
	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getINSTANCE();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("입력할 부서 번호 > ");
		int deptno = scanner.nextInt();
		Dept dept = deptRepository.getDept(deptno);
		
		if(dept == null) {
			System.out.print("입력할 부서명 > ");
			String dname = scanner.next();
			System.out.print("입력할 부서지역 > ");
			String loc = scanner.next();
			deptRepository.insertDept(deptno, dname, loc);
			scanner.close();
		}else {
			System.out.println("부서번호가 이미 존재합니다");
			scanner.close();
		}
		
		
		
	}
}