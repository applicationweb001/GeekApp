package com.geek.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.geek.model.Request;
import com.geek.model.Ticket;

public interface TicketRepository extends PagingAndSortingRepository<Ticket,Long>{
	/**
     * @return newest categoryId
     */
    @Query(value = "SELECT MAX(id) FROM Ticket")
    Long findTopByOrderByIdDesc();

    /**
     * @param category  title of an article
     * @return          List of articles with the same category
     */
    
    @Query("SELECT a FROM Ticket a WHERE a.id=:id")
    List<Ticket> findByTicketId(@Param("id") Long ticket);

    @Query("SELECT t FROM Ticket t join fetch t.ticketTechnicians tt join fetch tt.technician WHERE t.id=:id")
    List<Ticket> fetchByTicketIdWithTicketTechnicianWithTechnincian(Long id);
  
    @Query( "SELECT DISTINCT e FROM Ticket e JOIN FETCH e.problems p WHERE p.name=:name")
    List<Ticket> findAllByProblems(@Param("name") String name);

    Page<Ticket> findByStatus(String status,Pageable pageable);
    
}
