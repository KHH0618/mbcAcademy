package com.lec.ch12.controller;

import java.io.IOException;

import com.lec.service.InsertPerson;
import com.lec.service.PersonDelete;
import com.lec.service.PersonInfo;
import com.lec.service.PersonList;
import com.lec.service.PersonUpdate;
import com.lec.service.Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null;
		String viewPage = "";
		if(command.equals("/list.do")) {
			service = new PersonList();
			service.extend(request, response);
			viewPage = "person/personList.jsp";
		}else if(command.equals("/insert.do")) {
			viewPage = "person/personInsert.jsp";
		}else if(command.equals("/info.do")) {
			service = new PersonInfo();
			service.extend(request, response);
			viewPage = "person/personInfo.jsp";
		}else if(command.equals("/update.do")) {
			service = new PersonInfo();
			service.extend(request, response);
			viewPage = "person/personUpdate.jsp";
		}else if(command.equals("/delete.do")) {
			service = new PersonDelete();
			service.extend(request, response);
			viewPage = "list.do";
		}else if(command.equals("/update2.do")) {
			service = new PersonInfo();
			service.extend(request, response);
			viewPage = "person/personUpdate2.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = "";
		Service service = null;
		if(command.equals("/list.do")) {
			service = new PersonList();
			service.extend(request, response);
			viewPage = "person/personList.jsp";
		}else if(command.equals("/insert.do")) {
			service = new InsertPerson();
			service.extend(request, response);
			viewPage = "list.do";
		}else if(command.equals("/update.do")) {
			service = new PersonUpdate();
			service.extend(request, response);
			viewPage = "info.do";
		}else if(command.equals("/info.do")) {
			service = new PersonInfo();
			service.extend(request, response);
			viewPage = "person/personInfo.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
