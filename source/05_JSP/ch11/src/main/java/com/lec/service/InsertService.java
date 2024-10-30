package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse rsponse) {
		// insert로직 : 파라미터 받아 dao함수 호출
		System.out.println("insert로직 수행함");
		request.setAttribute("insertResult", 1);
	}

}
