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
 * Servlet implementation class EmpSch
 */
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String schJob = request.getParameter("schJob");
		EmpRepository empRepository = EmpRepository.getInstance();
		ArrayList<Emp> empList = empRepository.getEmpList(schName, schJob);
		request.setAttribute("schName", schName);
		request.setAttribute("schJob", schJob);
		request.setAttribute("empList", empList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empSch.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
