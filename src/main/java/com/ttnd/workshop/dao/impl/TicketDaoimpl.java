package com.ttnd.workshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ttnd.workshop.dao.TicketDao;
import com.ttnd.workshop.entities.Ticket;
import com.ttnd.workshop.utils.HibernateUtil;

public class TicketDaoimpl implements TicketDao{
	
	public Integer save(Ticket e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + e.toString());
		return e.getTicketId();

	}

	public List<Ticket> get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Ticket> ticket = session.createQuery("FROM ticket").list();
		session.close();
		System.out.println("Found " + ticket.size() + " Users");
		return ticket;
 
	}
	/*
	public User findByUserNameAndPass(String userName, String password){
		Query query= HibernateUtil.getSessionFactory().openSession().
		        createQuery("from User where userName=:userName and password=:password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
	
		return user;
	}*/

}
