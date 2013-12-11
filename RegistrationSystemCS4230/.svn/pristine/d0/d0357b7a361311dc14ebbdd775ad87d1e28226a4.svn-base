package edu.weber.cs4230.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.ws.runtime.dev.Session;

import edu.weber.cs4230.DAL.UsersDAO;
import edu.weber.group.bean.Registration;

/**
 * 
 * 
 * 
 * 
 * This class contains all the code needed to allow the user to edit there information.
 * Update.jsp, changepassword.jsp and changeemail.jsp all rely on this "Controller".
 * 
 * 
 * 
 *  @see changeemail.jsp
 *  @see changepassword.jsp
 * 
 */
@WebServlet("/Edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Registration r;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        this.r=r;
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 
	 * This is what processes the request. by default either for changepassword.jsp or changeemail.jsp
	 * 
	 * @see changeemail.jsp
	 * @see changepassword.jsp
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Registration bean = (Registration) request.getSession().getAttribute("UserData");
			int status = 0;
			
			String button = request.getParameter("submit");
			System.out.println(button);
			button = button.toLowerCase();
			if (button.equals("change email")){
				//String pwd = bean.getPassword();
				//String password = request.getParameter("password");
				//password = UsersDAO.Hash(password);
				String email = request.getParameter("email");
				String confirm = request.getParameter("confirm");
				
				//if (pwd.equals(password)){
				//	status = 4;
				//	bean.setStatus(status);
				//	request.setAttribute("bean",  bean);
				//	RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
				//	rd.forward(request, response);
				///	return;
			//	}
				
				if (!email.equals(confirm)){
					status = 5;
					bean.setStatus(status);
					request.setAttribute("bean",  bean);
					RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
					rd.forward(request, response);
					return;
				}
				
				bean.setEmail(email);
				UsersDAO.updateEmail(bean);
				response.sendRedirect(request.getContextPath());
			}
			
			
			if (button.equals("change password")){
				String pwd = bean.getPassword();
				String password = UsersDAO.Hash( request.getParameter("oldpassword") );
				password = UsersDAO.Hash(password);
				System.out.println(pwd + " :pass " + password);
				String newPass = request.getParameter("password");
				String confirm = request.getParameter("confirmPassword");
				
				if (request.getSession().getAttribute("resetPassword") == null) {
					if (!pwd.equals(password)){
						status = 6;
						bean.setStatus(status);
						request.setAttribute("bean",  bean);
						request.getSession().invalidate();
						RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
						rd.forward(request, response);
						return;
					}
				}
				if(!newPass.equals(confirm)){
					status = 7;
					bean.setStatus(status);
					request.setAttribute("bean",  bean);
					RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
					rd.forward(request, response);
					return;
				}
				
				bean.setPassword(newPass);
				UsersDAO.updatePassword(bean);
				response.sendRedirect(request.getContextPath());
			}
			
			
		}
		
		catch (Exception e){
			e.printStackTrace();
			response.sendError(500);
		}
	}

}
