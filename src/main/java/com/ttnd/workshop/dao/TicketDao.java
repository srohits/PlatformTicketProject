package com.ttnd.workshop.dao;

import java.util.List;

import com.ttnd.workshop.entities.Ticket;

public interface TicketDao {
	Integer save(Ticket ticket);

	List<Ticket> get();

	//void update(Ticket ticket);

	//Ticket findByID(Integer id);
	//Ticket findByUserNameAndPass(String userName, String password);
}
