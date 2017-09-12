package com.ttnd.workshop.dao.impl;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ttnd.workshop.dao.UserDao;
import com.ttnd.workshop.entities.User;
import com.ttnd.workshop.utils.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public Integer save(User e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + e.toString());
		return e.getUserId();

	}

	public List<User> get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<User> Users = session.createQuery("FROM User").list();
		session.close();
		System.out.println("Found " + Users.size() + " Users");
		return Users;
 
	}

	public void update(User e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User em = (User) session.load(User.class, e.getUserId());
		em.setLastName(e.getLastName());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + e.toString());

	}

	
	public void updatePassword(User user,String pwd)
	{
		Session session =HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("update from User set password=:pwd where userName=:usr");
		query.setParameter("pwd", pwd);
		query.setParameter("usr", user.getUserName());
	query.executeUpdate();
	session.getTransaction().commit();
	}
	public void delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());

	}
	public User findByName(String us){

	Session session = HibernateUtil.getSessionFactory().openSession();
	Query query=session.createQuery("from User where userName=:usr");
	query.setParameter("usr", us);


	User user = (User)query.uniqueResult();
	session.close();
	return user;
}

	public User findByID(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		User e = (User) session.load(User.class, id);
		session.close();
		return e;
	}
	
	public User findByUserNameAndPass(String userName, String password){
		Query query= HibernateUtil.getSessionFactory().openSession().
		        createQuery("from User where userName=:uname and password=:pword");
		query.setParameter("uname", userName);
		query.setParameter("pword", password);
		User user = (User) query.uniqueResult();
		
			
	
		return user;
	}
	public boolean findByUseName(String s)
	{
	User user=null;
		Query query =HibernateUtil.getSessionFactory().openSession().
				createQuery("from User Where userName=:unam ");
		query.setParameter("unam", s);
		try
		{
			
		user = (User) query.uniqueResult();
		}
		catch(NonUniqueResultException e)
		{
			System.out.println(e);
		}
	
		if(user!= null){
		return true;
		}
		else
		{
			return false;
		}
		}

	}

