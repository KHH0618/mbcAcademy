package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiiden = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.print("<div id='joinForm_wrap'>");
		out.print("<div id='join_title'>회원가입</div>");
		out.print("<h1>hiddenParam : " + hiiden + "</h1>");
		out.print("<h1>이름 : " + name + "</h1>");
		out.print("<h1>아이디 : " + id + "</h1>");
		out.print("<h1>비밀번호 : ");
		for(int i = 0; i < pw.length(); i++) {
			out.print("*");
		}
		out.print("</h1>");
		out.print("<h1>생일 : " + birth + "</h1>");
		out.print("<h1>취미 : ");
		for(String m : hobby) {
			out.print(m + " ");
		}
		out.print("</h1>");
		if(gender != null) {
			if(gender.equals("m")) {
				gender = "남자";
			}else {
				gender = "여자";
			}
		}
		out.print("<h1>성별 : " + gender + "</h1>");
		out.print("<h1>이메일 : " + email + "</h1>");
		out.print("<h1>메일 수신 동의 : ");
		for(String send : mailSend) {
			out.print(send + " ");
		}
		out.print("</h1>");
		out.print("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
