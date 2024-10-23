package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class quiz1_gugudan
 */
@WebServlet("/quiz1Gugu")
public class quiz1_gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quiz1_gugudan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] dansu = request.getParameterValues("dansu");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		for (String su : dansu) {
			out.print("<h1>" + su + "단 출력</h1>");
			int dan = Integer.parseInt(su);
			for(int i = 1; i <= 9; i++) {
				out.println(dan + " * " + i + " = " + dan * i + "<br>");
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
