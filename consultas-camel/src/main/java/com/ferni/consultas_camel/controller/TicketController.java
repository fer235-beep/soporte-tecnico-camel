package com.ferni.consultas_camel.controller;

import com.ferni.consultas_camel.model.Ticket;
import com.ferni.consultas_camel.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Alta de ticket
    @PostMapping
    public Ticket crear(@RequestBody Ticket ticket) {
        return ticketService.crearTicket(ticket);
    }

    // Listar todos
    @GetMapping
    public List<Ticket> listar() {
        return ticketService.listarTickets();
    }

    // Baja / cierre de ticket
    @PutMapping("/{id}/cerrar")
    public void cerrar(@PathVariable Long id) {
        ticketService.cerrarTicket(id);
    }
}
