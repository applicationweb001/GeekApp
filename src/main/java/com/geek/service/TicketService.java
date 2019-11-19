package com.geek.service;


import java.util.List;

import com.geek.model.Ticket;

public interface TicketService extends CrudService<Ticket,Long>{
	boolean TicketValid(Ticket ticket);
	
	List<Ticket> findByProblemName(String name);
}
