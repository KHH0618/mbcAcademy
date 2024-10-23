package com.lec.lect;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet("/LifeCycle")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 객체 생성시 실행
		System.out.println("Ex3_LifeCycle 서블릿 생성될 때 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 서블릿 객체 소멸시 실행
		System.out.println("Ex3_LifeCycle 서블릿 소멸될 때 수행");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // service를 오버라이드 하면
	 * doGet(), doPost() 함수가 실행되지 않고 service()실행
	 * response.setContentType("text/html; charset=UTF-8");
	 * response.getWriter().println("<h1>service() 함수 실행</h1>");
	 * System.out.println("Ex3_LifeCycle service() 실행");
	 * response.getWriter().close(); }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>doGet() 함수 실행</h1>");
		System.out.println("Ex3_LifeCycle doGet() 실행");
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식 요청시 실행
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>doPost() 함수 실행</h1>");
		System.out.println("Ex3_LifeCycle doPost() 실행");
		response.getWriter().close();
	}

}
