package com.tramdt.repository;

import com.tramdt.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Page<Ticket> findAllByNameContaining(String search, Pageable pageable);
    Page<Ticket> findAllByBookingCodeContaining(String search, Pageable pageable);
    Page<Ticket> findAllByDepartureContaining(String search, Pageable pageable);
}
