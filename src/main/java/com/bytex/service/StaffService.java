package com.bytex.service;

import com.bytex.model.Response;
import com.bytex.model.Ticket;
import com.bytex.repository.ResponseRepository;
import com.bytex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // Create ticket response to customer
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }

    // View assigned tickets
    public List<Ticket> getAssignedTickets(Long staffId) {
        return ticketRepository.findByStaffId(staffId);
    }

    // Change ticket status (open/closed/pending)
    public Ticket updateTicketStatus(Long ticketId, String status) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setStatus(status);
            return ticketRepository.save(ticket);
        }
        return null;
    }

    // Archive resolved tickets
    public void archiveTicket(Long ticketId) {
        // In a real app, you might have an "archived" status or move to another table.
        // For simplicity, we'll just delete it.
        ticketRepository.deleteById(ticketId);
    }
}
