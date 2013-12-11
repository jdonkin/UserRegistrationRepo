package edu.weber.cs4230.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.weber.cs4230.DAL.UsersDAO;
import edu.weber.group.bean.Registration;

/**
 * 
 * 
 * 
 * This handles the request for registration and setting up users.
 * 
 * Servlet implementation class RegisterController
 * 
 * @see Registration.jsp
 * 
 * 
 * 
 * 
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Registration r;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        
        this.r = r;
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		}
		catch(Exception e){
			response.sendError(500);
		}
	}

	/**
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			String username = request.getParameter("username");
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("firstName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int status = 0;
			Registration bean = new Registration();
			
			bean.setUsername(username);
			boolean gUser = UsersDAO.getUser(bean);
			
			
			bean.setLastName(lastName);
			bean.setFirstName(firstName);
			bean.setPassword(password);
			bean.setEmail(email);
			
			if (!gUser) {
				
				
				
				UsersDAO.newUser(bean);
				
				response.sendRedirect(request.getContextPath());
				
			} else {
				status = 1;
				bean.setStatus(status);
				request.getSession().setAttribute("bean", bean);
				response.sendRedirect(request.getContextPath() + "/Registration.jsp");
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
	}



}
