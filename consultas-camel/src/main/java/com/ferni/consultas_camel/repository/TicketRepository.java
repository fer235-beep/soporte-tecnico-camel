package com.ferni.consultas_camel.repository;

import com.ferni.consultas_camel.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
