package com.ferni.consultas_camel.service;

import com.ferni.consultas_camel.model.Ticket;
import com.ferni.consultas_camel.repository.TicketRepository;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ProducerTemplate producerTemplate;

    public TicketService(TicketRepository ticketRepository, ProducerTemplate producerTemplate) {
        this.ticketRepository = ticketRepository;
        this.producerTemplate = producerTemplate;
    }

    public Ticket crearTicket(Ticket ticket) {
        ticket.setEstado("ABIERTO");
        ticket.setFechaHora(LocalDateTime.now());
        Ticket guardado = ticketRepository.save(ticket);
        producerTemplate.sendBody("direct:nuevo-ticket", guardado);
        return guardado;
    }

    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    public void cerrarTicket(Long id) {
        ticketRepository.findById(id).ifPresent(ticket -> {
            ticket.setEstado("CERRADO");
            ticketRepository.save(ticket);
            producerTemplate.sendBody("direct:cierre-ticket", ticket);
        });
    }
}
