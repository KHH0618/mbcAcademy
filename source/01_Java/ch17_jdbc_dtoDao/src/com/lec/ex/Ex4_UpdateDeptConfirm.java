package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

public class Ex4_UpdateDeptConfirm {

	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getINSTANCE();
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 부서의 부서번호를 입력하세요 > ");
		int deptno = scanner.nextInt();
		Dept dept = deptRepository.getDept(deptno);
		
		
		if (dept != null) {
			System.out.print("수정할 부서의 부서명을 입력하세요 > ");
			String dname = scanner.next();			
			System.out.print("수정할 부서의 지역을 입력하세요 > ");
			String loc = scanner.next();
			deptRepository.updateDept(deptno, dname, loc);
		}else {
			System.out.println("해당 부서번호는 존재하지 않아 수정이 불가합니다");
		}
		scanner.close();
	}

}
