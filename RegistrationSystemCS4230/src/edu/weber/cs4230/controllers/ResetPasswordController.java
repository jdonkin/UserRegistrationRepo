package edu.weber.cs4230.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.weber.cs4230.DAL.UsersDAO;
import edu.weber.cs4230.lib.SimpleMailer;
import edu.weber.group.bean.Registration;

/**
 * 
 * The reset password handling code
 * 
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/ResetPassword")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static edu.weber.cs4230.lib.SimpleMailer mailer = new edu.weber.cs4230.lib.SimpleMailer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see resetpassword.jsp
	 * @see changepassword.jsp
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("authCode") != null && 
			request.getParameter("userName") != null) {
			
			
			Registration r = new Registration();
			r.setUsername(request.getParameter("userName"));
			if (UsersDAO.getUser(r)) {
				
				if (!(UsersDAO.Hash(r.getPassword() + r.getUsername()).equals(request.getParameter("authCode")))) {
					response.sendError(500);
					System.out.println("1: " + UsersDAO.Hash(r.getPassword() + r.getUsername()) + " : " + request.getParameter("authCode"));
					return;
				}
			
				request.getSession().setAttribute("resetPassword", true);
				request.getSession().setAttribute("isLogin", true);
				request.getSession().setAttribute("UserData",  r);
				response.sendRedirect("UserArea/changepassword.jsp");
			} else {
				response.sendError(500);
				System.out.println("2");
				return;
			}
			
			
		} else {
			response.sendError(500);
			System.out.println("3");
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String message = "";
		Registration user = new Registration();
		if (!UsersDAO.getUserByEmail(email, user)) {
			request.getSession().setAttribute("BadEmail", true);
			response.sendRedirect(request.getContextPath() + "/ForgotPass.jsp");
		}
		
		try {
		
		BufferedReader r = new BufferedReader( new InputStreamReader( SimpleMailer.class.getResourceAsStream("email_template.html") ));
		char[] buff = new char[1024];
		int c = r.read(buff);
		while (c != -1) {
			char[] tmp = java.util.Arrays.copyOf(buff,c);
			message = message + new String(tmp);
			c = r.read(buff);
		}
		
		message = message.replace("{serverAddress}", "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
		message = message.replace("{authCode}", UsersDAO.Hash( user.getPassword() + user.getUsername()));
		message = message.replace("{userName}", user.getUsername());
		
		mailer.SendMail(email, "Password Reset", message); 
		
		request.getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
		return;
		
		} catch (Exception e) {
			System.out.println(e.toString());
			response.sendError(500);
		}
		
	}
	
	

}
