package com.geek.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.geek.model.Ticket;

public interface TicketService extends CrudService<Ticket,Long>{
	boolean TicketValid(Ticket ticket);
	
	List<Ticket> findByProblemName(String name);
	
	Page<Ticket> findByStatus(String name,Pageable pageable);
	
}
