package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

/**
 * Servlet implementation class SummaryController
 */
@WebServlet("/SummaryController")
public class SummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
	
		
		Integer visitCount=new Integer(0);
		if(session.isNew()) {
			session.setAttribute("visiterCounter", visitCount);
		}
		visitCount=(Integer)session.getAttribute("visiterCounter");
		visitCount=visitCount+1;
		
		session.setAttribute("visiterCounter", visitCount);
		
		
		Integer siteCounter=(Integer)request.getServletContext().getAttribute("siteVisitor");
		if(siteCounter==null || siteCounter==0) {
			siteCounter=1;
		}else {
			siteCounter=siteCounter+1;
		}
		request.getServletContext().setAttribute("siteVisitor", siteCounter);
		
		PrintWriter out=response.getWriter();
		
		out.println("<h1>Visitor Counter(Session) "+visitCount+"</h1>");
		out.println("<h1>Visitor Counter(Server) "+siteCounter+"</h1>");
		out.println("<h1>Session ID "+session.getId()+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
