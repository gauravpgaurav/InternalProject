package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate_Servlet
 */
public class Validate_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Validate_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String role = request.getParameter("role");
		String labCode = request.getParameter("labCode");

		if (userName.equals("gaurav") && role.equals("Operator") && passWord.equals("123")) {
			out.println("<h2>Valid</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("ValidateUser.jsp");
			rd.forward(request, response);
		} else
			out.println("<h3>Not Valid</h3>");
	}

}
