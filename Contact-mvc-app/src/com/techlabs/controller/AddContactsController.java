package com.techlabs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.techlabs.model.ContactService;
import com.techlabs.model.Contacts;

/**
 * Servlet implementation class AddContactsController
 */
@WebServlet("/AddContacts")
public class AddContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		request.setAttribute("errMsg", "");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Views/addContact.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("contactId");
		String name=request.getParameter("contactName");
		String email=request.getParameter("contactEmail");
		String state=request.getParameter("contactState");
		String gender=request.getParameter("contactGender");
		
		response.getWriter().println(id);
		
		if(!id.equals("") && !name.equals("") && !email.equals("") && !gender.equals("")) {
			Contacts contacts=new Contacts(id, name, email, state, gender);		
			ContactService.getInstance().addContact(contacts);		
			response.sendRedirect("Contacts");
		}else {
			Contacts contacts=new Contacts(id, name, email,state ,gender);
			request.setAttribute("contact", contacts);
			request.setAttribute("errMsg", "All fields required");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Views/addContact.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
