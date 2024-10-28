package com.lec.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.lec.dto.Quiz2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Quiz2RepositoryTest")
public class Quiz2RepositoryTest extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws SecurityException, IOException{
		Quiz2Repository quiz2Repository = Quiz2Repository.getInstance();
		ArrayList<Quiz2> quiz2List = quiz2Repository.getFriendList();
		if(quiz2List.isEmpty()) {
			System.out.println("데이터 없음 or 함수오류");
		}else {
			for (Quiz2 friend : quiz2List) {
				System.out.println(friend);
			}
			int result = quiz2Repository.addFriendList("김길동","010-8888-8888");
			System.out.println(result == 1 ? "추가성공":"추가 실패" );
		}
	}


}
