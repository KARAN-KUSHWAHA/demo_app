//package com.ioc.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class LoginServlet
// */
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * Default constructor.
//	 */
//	public LoginServlet() {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		String uname = request.getParameter("uname");
//		String psw = request.getParameter("psw");
//
//		if (uname.equalsIgnoreCase("test") && psw.equalsIgnoreCase("test")) {
//			response.sendRedirect("success.jsp");
//		} else {
//			response.sendRedirect("error.jsp");
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
