package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		 out.println(
		         "<html>\n" +
		            "<head><title>Login</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">Login</h1>\n" +
		               "<ul>\n" +
		                  "  <li><b>First Name</b>: "
		                  + request.getParameter("firstName") + "\n" +
		                  "  <li><b>Last Name</b>: "
		                  + request.getParameter("lastName") + "\n" +
		               "</ul>\n" +
		            "</body>" +
		         "</html>"
		      );		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		 out.println(
		         "<html>\n" +
		            "<head><title>Login</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">Login</h1>\n" +
		               "<ul>\n" +
		                  "  <li><b>First Name</b>: "
		                  + request.getParameter("firstName") + "\n" +
		                  "  <li><b>Last Name</b>: "
		                  + request.getParameter("lastName") + "\n" +
		               "</ul>\n" +
		            "</body>" +
		         "</html>"
		      );
	}

}
