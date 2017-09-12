package com.ttnd.workshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttnd.workshop.dao.UserDao;
import com.ttnd.workshop.dao.impl.UserDaoImpl;
import com.ttnd.workshop.entities.User;

/**
 * Servlet implementation class UserDataServlet
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(fname.isEmpty()||lname.isEmpty()||email.isEmpty()||uname.isEmpty()||pass.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("reg.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			User user=new User();
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setEmail(email);
			user.setUserName(uname);
			user.setPassword(pass);
			user.setLastLogin(java.util.Calendar.getInstance().getTime());;
			
			UserDao userDao=new UserDaoImpl();
			
			if(userDao.findByUseName(uname))
			{
				RequestDispatcher rd = request.getRequestDispatcher("reg.jsp");
				out.println("<font color=red>UserName Already Exist!!</font>");
			rd.include(request, response);
				
			}
			else
			{
			userDao.save(user);
		
			HttpSession session = request.getSession();
			session.setAttribute("username", fname);
			session.setAttribute("userdata",user);
			String username = (String) session.getAttribute("username");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp?uname="+username);
			
			rd.forward(request, response);
			
			out.println("<font color=red>User Registered Successfully!!</font>");
			rd.include(request, response);
			}
		}
	}

}
