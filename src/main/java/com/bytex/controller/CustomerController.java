package com.bytex.controller;

import com.bytex.model.Ticket;
import com.bytex.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new support ticket
    @PostMapping("/tickets")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return customerService.createTicket(ticket);
    }

    // View their ticket status
    @GetMapping("/tickets/{customerId}")
    public List<Ticket> getTickets(@PathVariable Long customerId) {
        return customerService.getTicketsByCustomerId(customerId);
    }

    // Add additional information to their ticket
    @PutMapping("/tickets/{ticketId}")
    public Ticket updateTicket(@PathVariable Long ticketId, @RequestBody Ticket ticketDetails) {
        return customerService.updateTicket(ticketId, ticketDetails);
    }

    // Cancel their ticket
    @DeleteMapping("/tickets/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        customerService.deleteTicket(ticketId);
    }
}
