package edu.weber.cs4230.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import edu.weber.cs4230.DAL.*;
import edu.weber.group.bean.Registration;

/**
 * 
 * This handles the request form login.html
 * 
 * 
 * Servlet implementation class LoginController
 * 
 * @see Login.html
 * 
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Registration r;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        this.r=r;
        // TODO Auto-generated constructor stub
    }
    
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
		doPost(request, response);
	}

	/**
	 * 
	 * @see Login.html
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			if (request.getParameter("logout") != null) {
				request.getSession().invalidate();
				response.sendRedirect("");
				return;
			}
		
		int status = 0;	
		String user  = request.getParameter("username");
		String pass = UsersDAO.Hash(request.getParameter("password"));
		Registration bean = new Registration();
		bean.setUsername(user);
		boolean gUser = UsersDAO.getUser(bean);
		if (gUser == false){
			status = 2;
			bean.setStatus(status);
			request.setAttribute("bean",  bean);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			return;
		}
		
		String password = bean.getPassword();

		if (!pass.equals(password)){
			status = 3;
			bean.setStatus(status);
			request.setAttribute("bean",  bean);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			return;
		}
		else 
		{
			
			request.getSession().setAttribute("isLogin", true);
			request.getSession().setAttribute("UserData",  bean);
			response.sendRedirect("UserArea/Welcome.jsp");
			
		}
		
		
		
		}
		catch (Exception e){
			System.out.println(e);
		}
		
	
	}

}
