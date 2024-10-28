package com.lec.dao;

import java.io.IOException;
import java.util.ArrayList;
import com.lec.dto.Dept;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeptRepositoryTest")
public class DeptRepositoryTest extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws SecurityException, IOException{
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
