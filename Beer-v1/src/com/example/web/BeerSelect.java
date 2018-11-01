package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

/**
 * Servlet implementation class SelectBeer
 */
@WebServlet("/SelectBeer")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		
//		out.println("Beer Selection Advice <br>");
		String c=request.getParameter("color");
//		out.println("<br>Got Beer Color "+c);
		
		BeerExpert be=new BeerExpert();
		List<String>result=be.getBrand(c);
		
		request.setAttribute("styles", result);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("result.jsp");
		
		requestDispatcher.forward(request, response);
		
		
//		Iterator<String> it=result.iterator();
//		while (it.hasNext()) {
//			out.println("<br>try: "+it.next());

//		}
	}

}
