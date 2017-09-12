package com.ttnd.workshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttnd.workshop.dao.TicketDao;
import com.ttnd.workshop.dao.UserDao;
import com.ttnd.workshop.dao.impl.TicketDaoimpl;
import com.ttnd.workshop.dao.impl.UserDaoImpl;
import com.ttnd.workshop.entities.Ticket;
import com.ttnd.workshop.entities.User;

/**
 * Servlet implementation class TicketControl
 */
public class TicketControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("hey Book your ticket now");
		
		RequestDispatcher rd = request.getRequestDispatcher("newTicket.jsp");
		rd.include(request, response);
		
		String uname = request.getParameter("fname");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
		String tn = request.getParameter("tn");
		
	
		
		if(uname.isEmpty()||state.isEmpty()||district.isEmpty())
		{
			RequestDispatcher ra = request.getRequestDispatcher("newTicket.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			ra.include(request, response);
		}
		
		int ti = Integer.parseInt(tn);
		ti = ti*5;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uname = request.getParameter("fname");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
		String tn = request.getParameter("tn");
		int ti = Integer.parseInt(tn);
		ti = ti*5;
		Ticket tic=new Ticket();
		tic.setuserName(uname);
		tic.settotalcost(ti);
		tic.setdistrict(district);
		tic.setState(state);
		TicketDao ticketDao=new TicketDaoimpl();
		ticketDao.save(tic);
		RequestDispatcher rb = request.getRequestDispatcher("print.jsp?uname="+tic.getuserName()+"&state="+tic.getState()+"&district="+tic.getdistrict()+"&ti="+tic.gettotalcost());			
		rb.forward(request, response);

			
		}
		
}
