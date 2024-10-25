package com.lec.dao;

import java.util.ArrayList;
import com.lec.dto.Dept;

public class DeptRepositoryTest {

	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getInstance();
		ArrayList<Dept> deptList = deptRepository.deptList();
		if(deptList.isEmpty()) {
			System.out.println("데이터 없음 or 함수오류");
		}else {
			for(int i = 0; i<deptList.size(); i++) {
				System.out.println(deptList.get(i));
			}
		}
	}

}
