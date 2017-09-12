package com.ttnd.workshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttnd.workshop.entities.User;

public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession s = request.getSession(false);
		s.invalidate();
		/*
		RequestDispatcher ra = request.getRequestDispatcher("Index.jsp");
		ra.forward(request, response);
		*/
		PrintWriter out = response.getWriter();
		out.println("You are successfully loggedout");
		//response.sendRedirect("Index.jsp");
		RequestDispatcher ra = request.getRequestDispatcher("Index.jsp");
		ra.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ttpSession session = request.getSession(false);
		//User udata = (User)session.getAttribute("userdata");/
		RequestDispatcher x = request.getRequestDispatcher("passchange.jsp");
		x.include(request, response);
	}
}
