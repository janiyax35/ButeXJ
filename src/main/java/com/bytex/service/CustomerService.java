package com.bytex.service;

import com.bytex.model.Ticket;
import com.bytex.repository.TicketRepository;
import com.bytex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new support ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // View their ticket status
    public List<Ticket> getTicketsByCustomerId(Long customerId) {
        return ticketRepository.findByCustomerId(customerId);
    }

    // Add additional information to their ticket
    public Ticket updateTicket(Long ticketId, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setDescription(ticketDetails.getDescription());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    // Cancel their ticket
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
