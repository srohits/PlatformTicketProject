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

public class MyProfileController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User udata = (User)session.getAttribute("userdata");
		
		RequestDispatcher rs = request.getRequestDispatcher("MyProfile.jsp?uname="+udata.getFirstName()+"&lastname="+udata.getLastName()+"&email="+udata.getEmail()+"&lastlogin="+udata.getLastLogin());
		rs.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//HttpSession session = request.getSession(false);
		HttpSession session =request.getSession();
		User user = (User) session.getAttribute("userdata");
		String password = (String)request.getParameter("nwp");
		UserDao userDao=new UserDaoImpl();
		userDao.updatePassword(user,password);
		
		PrintWriter pd = response.getWriter();
		pd.println("Password is successfully changed");
		RequestDispatcher rd = request.getRequestDispatcher("MyProfile.jsp");
		rd.forward(request, response);
	}
}
