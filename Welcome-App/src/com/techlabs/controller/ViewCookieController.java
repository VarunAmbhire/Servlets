package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewCookieController
 */
@WebServlet("/ViewCookieController")
public class ViewCookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCookieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	     Cookie cookie = null;
	      Cookie[] cookies = null;

	      // Get an array of Cookies associated with this domain
	      cookies = request.getCookies();

	      // Set response content type
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      	         
	      out.println(
	         "<html>\n" +
	         "<head><title>View Cookie</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" );

	      if( cookies != null ) {

	            cookie = cookies[1];
	            out.print(cookie.getName( ) + "<br>");
	            out.print(cookie.getValue( )+"<style>body{background-color:"+cookie.getValue( )+"}</style>");
	      } else {
	         out.println("<h2>No cookies founds</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
