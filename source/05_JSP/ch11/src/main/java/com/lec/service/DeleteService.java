package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse rsponse) {
		// TODO Auto-generated method stub
		System.out.println("delete할 정보 파라미터를 받아 dao함수 호출 후 결과를 request에 set");
		request.setAttribute("deleteResult", 1);
	}

}
