package com.ttnd.workshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import com.ttnd.workshop.dao.UserDao;
import com.ttnd.workshop.dao.impl.UserDaoImpl;
import com.ttnd.workshop.entities.User;

/**
 * Servlet implementation class UserDataServlet
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Page");
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(uname.isEmpty()||pass.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			
			UserDao userDao=new UserDaoImpl();
			User user=userDao.findByUserNameAndPass(uname, pass);
			
			
			if(user!=null){
				String userFirstName = user.getFirstName();
				String userpass = user.getPassword();
				HttpSession session = request.getSession();
				session.setAttribute("username", userFirstName);
				session.setAttribute("pass", userpass);
				session.setAttribute("userdata",user);
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp?uname="+userFirstName);
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				out.println("<font color=red><center>Invalid User!!</center></font>");
				rd.include(request, response);
			}
			
		}
	}

}
