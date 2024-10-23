package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

//부서번호를 입력받아 부서정보 출력
public class Ex2_selectWhereDeptno {
	public static void main(String[] args) {
		DeptRepository repository = DeptRepository.getINSTANCE();
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서 번호는 > ");
		int deptno = sc.nextInt();
		Dept dept = repository.getDept(deptno);
		sc.close();
		
		if (dept!=null) {
			System.out.println(deptno + "번 부서정보는 다음과 같습니다.");
			System.out.println("부서명 : " + dept.getDname());
			System.out.println("부서지역 : " + dept.getLoc());
		}else {
			System.out.println("해당부서는 존재하지 않습니다");
		}
		
	}
}
