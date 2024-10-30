package com.lec.ch12.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.naming.Context;

import com.lec.ch12.service.MemberJoinService;
import com.lec.ch12.service.MemberListService;
import com.lec.ch12.service.Service;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null;
		String viewPage = "";
		//System.out.println("요청 command: " + command);
		if(command.equals("/memberList.do")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage ="member/memberList.jsp";
		}else if (command.equals("/memberJoinView.do")) {
			viewPage ="member/memberJoinView.jsp";
		}else if (command.equals("/memberJoin.do")) {
			service = new MemberJoinService();
			service.execute(request, response);
			viewPage ="member/memberList.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
