package com.bytex.controller;

import com.bytex.model.Response;
import com.bytex.model.Ticket;
import com.bytex.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Create ticket response to customer
    @PostMapping("/responses")
    public Response createResponse(@RequestBody Response response) {
        return staffService.createResponse(response);
    }

    // View assigned tickets
    @GetMapping("/tickets/{staffId}")
    public List<Ticket> getAssignedTickets(@PathVariable Long staffId) {
        return staffService.getAssignedTickets(staffId);
    }

    // Change ticket status (open/closed/pending)
    @PutMapping("/tickets/{ticketId}/status")
    public Ticket updateTicketStatus(@PathVariable Long ticketId, @RequestBody String status) {
        return staffService.updateTicketStatus(ticketId, status);
    }

    // Archive resolved tickets
    @DeleteMapping("/tickets/{ticketId}")
    public void archiveTicket(@PathVariable Long ticketId) {
        staffService.archiveTicket(ticketId);
    }
}
