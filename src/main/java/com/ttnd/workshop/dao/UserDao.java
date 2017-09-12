package com.ttnd.workshop.dao;

import java.util.List;

import com.ttnd.workshop.entities.User;

public interface UserDao {

	
	Integer save(User user);

	List<User> get();

	void update(User user);
    boolean findByUseName(String uname);
	User findByID(Integer id);
	void updatePassword(User user,String pwd);
	User findByName(String uname);

	User findByUserNameAndPass(String userName, String password);

}
