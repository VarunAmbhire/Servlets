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
 * Servlet implementation class EditController
 */
@WebServlet("/Edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Views/Edit.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);
		
		String id=request.getParameter("editId");
		String name=request.getParameter("editName");
		String eMail=request.getParameter("editEmail");
		String state=request.getParameter("editState");
		String gender=request.getParameter("editGender");
		
		System.out.println(state);
		
		if(!id.equals("") && !name.equals("") && !eMail.equals("") && !gender.equals("")) {	
			System.out.println(state);
			Contacts contact=new Contacts(id, name, eMail, state,gender);
			ContactService.getInstance().updateContact(contact);		
			response.sendRedirect("Contacts");
		}else {
			response.sendRedirect("Edit?id="+id);
//			request.setAttribute("id", Integer.parseInt(id));
//			doGet(request, response);
//			Contacts contacts=new Contacts(Integer.parseInt(id), name, eMail, gender);
//			request.setAttribute("id", id);
//			request.setAttribute("errMsg", "All fields required");
//			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Views/Edit.jsp");
//			requestDispatcher.forward(request, response);
		}
	}

}
