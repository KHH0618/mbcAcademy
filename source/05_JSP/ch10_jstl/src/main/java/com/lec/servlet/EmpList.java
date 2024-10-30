package com.lec.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.lec.dao.EmpRepository;
import com.lec.dto.Emp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpList
 */
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpRepository empRepository = EmpRepository.getInstance();
		ArrayList<Emp> empList = empRepository.getEmpList();
		request.setAttribute("empList", empList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empList.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
